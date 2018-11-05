package com.hoaiduc.controller.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoaiduc.core.constant.CoreConstant;
import com.hoaiduc.core.dto.*;

import com.hoaiduc.core.persistence.data.entity.*;

import com.lowagie.text.Paragraph;
import org.dom4j.rule.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping(value = "/ajax/")
@SessionAttributes({"user", "cart"})
public class ApiController {

    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("login")
    private int login(@RequestParam String dataJson, ModelMap modelMap) {
        String json;
        ObjectMapper object = new ObjectMapper();
        JsonNode jsonObject;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        EmployeeDTO employee;
        try {
            jsonObject = object.readTree(dataJson);

            employeeDTO.setEmail(jsonObject.get("emails").asText());
            employeeDTO.setPassword(jsonObject.get("passwords").asText());
            RestTemplate restTemplate = new RestTemplate();
            employee = restTemplate.postForObject(CoreConstant.LINK + "login", employeeDTO, EmployeeDTO.class);
            if (employee != null) {
                modelMap.addAttribute("user", employee);
                return 1;

            } else {
                return 0;

            }


        } catch (IOException e) {
            e.printStackTrace();

        }

        return 0;
    }

    @PostMapping("registration")
    private boolean registration(@RequestParam String dataJson) {
        String json;
        ObjectMapper object = new ObjectMapper();
        JsonNode jsonObject;
        Employee employee = new Employee();
        try {
            jsonObject = object.readTree(dataJson);
            employee.setEmail(jsonObject.get("email").asText());
            employee.setPassword(jsonObject.get("matkhau").asText());
            Roll roll = new Roll();
            roll.setIdRoll(1);
            employee.setRoll(roll);


        } catch (IOException e) {
            return false;

        }
        try {
            RestTemplate restTemplate = new RestTemplate();

            URI uri = restTemplate.postForLocation(CoreConstant.LINK + "save", employee, Employee.class);

            return true;

        } catch (HttpStatusCodeException exception) {

            return false;
        }
    }

    @GetMapping(path = "listproducts", produces = "text/plain; charset=utf-8")
    @ResponseBody
    private StringBuilder paging(int beginPage) {
        Set<ProductDTO> lisProductDTOS = getJsonPaging(beginPage);
        StringBuilder html = new StringBuilder("");
        for (ProductDTO productDTO : lisProductDTOS) {
            html.append("<div class='col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women'>");
            html.append("<div class='block2'>");
            html.append("<div class='block2-pic hov-img0 label-new' data-label='New'>");
            html.append("<img src=/resources/images/sanpham/"+productDTO.getImage()+"/>");
            html.append("<a href='#' class='block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1'>");
            html.append("Quick View");
            html.append("</a>");
            html.append("</div>");
            html.append("<div class='block2-txt flex-w flex-t p-t-14'>");
            html.append("<div class='block2-txt-child1 flex-col-l'>");
            html.append("<a href='product-detail/" + productDTO.getIdProduct() + "' class='stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6'>");
            html.append("<span>'" + productDTO.getProductName() + "'</span>");
            html.append("</a>");
            html.append("<span class='stext-105 cl3'>");
            html.append(productDTO.getPrice());
            html.append("</span>");
            html.append("</div>");
            html.append("<div class='block2-txt-child2 flex-r p-t-3'>");
            html.append("<a href='#' class='btn-addwish-b2 dis-block pos-relative js-addwish-b2'>");
            html.append("<img class='icon-heart1 dis-block trans-04' src='/template/web/images/icons/icon-heart-01.png' alt='ICON'>");
            html.append("<img class='icon-heart2 dis-block trans-04 ab-t-l' src='/template/web/images/icons/icon-heart-02.png' alt='ICON'> ");
            html.append("</a>");
            html.append("</div>");
            html.append("</div>");
            html.append("</div>");
            html.append("</div>");
        }
        return html;
    }

    private Set<ProductDTO> getJsonPaging(int beginPage) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(CoreConstant.LINK + "product/")
                .queryParam("id", beginPage);
        List<LinkedHashMap<String, Object>> List;
        Set<ProductDTO> productDTOList = new HashSet<ProductDTO>();
        List = restTemplate.getForObject(builder.toUriString(), List.class);
        for (LinkedHashMap<String, Object> productDTO : List)
        {

            ProductDTO dto = new ProductDTO();

            dto.setDescribes(productDTO.get("describes").toString());
            dto.setGender(productDTO.get("gender").toString());
            dto.setIdProduct(Integer.parseInt(productDTO.get("idProduct").toString()));
            dto.setImage(productDTO.get("image").toString());
            dto.setPrice(productDTO.get("price").toString());
            dto.setProductName(productDTO.get("productName").toString());
            productDTOList.add(dto);

        }
        return productDTOList;
    }

    @GetMapping(path = "paging")
    @ResponseBody
    private StringBuilder listPagination(@RequestParam int number) {
        int begin = number - 1;
        StringBuilder html = new StringBuilder("");
        if (begin % 4 == 0) {
            begin += 1;

            double variable = 0;
            List<LinkedHashMap<String, Object>> List;
            List = restTemplate.getForObject(CoreConstant.LINK + "paging", List.class);
            double numbers = Math.ceil((double) List.size() / CoreConstant.MAXPAGINATION);
            for (int i = begin; i <= numbers; i++) {
                if (begin == numbers) {
                    variable = begin;
                    break;
                } else if (i % 4 == 0) {
                    variable = i;
                    break;
                } else if (i == numbers) {
                    variable = i;
                }

            }
            html.append("<a href='#' id='previouspage'>");
            html.append("«");
            html.append("</a>");
            for (int i = begin; i <= variable; i++) {
                html.append("<a href='#' class='flex-c-m how-pagination1 trans-04 m-all-7 pagingitem  '>");
                html.append(i);
                html.append("</a>");
            }
            html.append("<a href='#' id='nextpage'>");
            html.append("»");
            html.append("</a>");
            return html;
        } else {
            return html;
        }

    }

    @GetMapping(path = "previouspage")
    @ResponseBody
    private StringBuilder previousPage(@RequestParam int numbers) {
        int i = numbers - 4;
        StringBuilder html = new StringBuilder("");
        html.append("<a href='#' id='previouspage'>");
        html.append("«");
        html.append("</a>");
        for (int begin = i; begin <= numbers - 1; begin++) {
            html.append("<a href='#' class='flex-c-m how-pagination1 trans-04 m-all-7 pagingitem  '>");
            html.append(begin);
            html.append("</a>");
        }
        html.append("<a href='#' id='nextpage'>");
        html.append("»");
        html.append("</a>");
        return html;

    }

    @GetMapping(path = "colorproduct", produces = "text/plain;charset=utf-8")
    @ResponseBody
    private StringBuilder getColorProduct(@RequestParam String size, @RequestParam int idProduct) {

        StringBuilder html = new StringBuilder("");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(CoreConstant.LINK + "productbyid/")
                .queryParam("id", idProduct);
        ProductDTO productDTO = restTemplate.getForObject(builder.toUriString(), ProductDTO.class);
        List<DetailProductDTO> listDetailProductDTO = (List<DetailProductDTO>) productDTO.getListDetailProductDTO();
        html.append("<select class='js-select2' name='time' id='color'>");
        for (DetailProductDTO detailProductDTO : listDetailProductDTO) {
            if (detailProductDTO.getSizeDTO().getSizeName().equals(size)) {
                html.append("<option class='colors' data-colorproduct='" + detailProductDTO.getColorProductDTO().getIdColorProduct() + "'>");
                html.append(detailProductDTO.getColorProductDTO().getColorName());
                html.append("</option>");
            }
        }
        html.append("</select>");
        return html;
    }

    @GetMapping("addcard")
    @ResponseBody
    private StringBuilder addCart(@RequestParam int idColor, @RequestParam int idSize, @RequestParam int amount, @RequestParam int idProduct,
                                  @RequestParam String price, @RequestParam String productName, @RequestParam String sizeName, @RequestParam String colorName, @RequestParam int idDetailProduct, @RequestParam String ImageProduct,
                                  HttpSession httpSession) {
        StringBuilder numberInCart = new StringBuilder();
        if (null == httpSession.getAttribute("cart")) {
            List<CartDTO> listCart = new ArrayList<CartDTO>();
            CartDTO cartDTO = new CartDTO();
            cartDTO.setAmount(amount);
            cartDTO.setColorName(colorName);
            cartDTO.setIdDetailProduct(idDetailProduct);
            cartDTO.setIdColor(idColor);
            cartDTO.setSizeName(sizeName);
            cartDTO.setProductName(productName);
            cartDTO.setPrice(price);
            cartDTO.setIdProduct(idProduct);
            cartDTO.setIdSize(idSize);
            cartDTO.setImage(ImageProduct);
            listCart.add(cartDTO);
            httpSession.setAttribute("cart", listCart);
            return numberInCart.append(listCart.size());
        } else {
            // there are two case
            // the first case user add same idproduct but diffirent idcolor,idsize
            // the second case user add same idproduct ,idsize,idcolor, :get current
            // possiont ,increment amount in listcart
            List<CartDTO> list = (List<CartDTO>) httpSession.getAttribute("cart");
            int position = checkProductAlreadyExist(list, idColor, idSize, idProduct);
            if (position == -1) {
                CartDTO newCart = new CartDTO();
                newCart.setAmount(amount);
                newCart.setColorName(colorName);
                newCart.setIdDetailProduct(idDetailProduct);
                newCart.setIdColor(idColor);
                newCart.setSizeName(sizeName);
                newCart.setProductName(productName);
                newCart.setPrice(price);
                newCart.setIdProduct(idProduct);
                newCart.setIdSize(idSize);
                newCart.setImage(ImageProduct);
                list.add(newCart);
            } else {
                int newQuality = list.get(position).getAmount() + amount;
                list.get(position).setAmount(newQuality);
            }
        }
        List<CartDTO> mySize = (List<CartDTO>) httpSession.getAttribute("cart");

        return numberInCart.append(mySize.size());
    }

    private int checkProductAlreadyExist(List<CartDTO> listNewCart, int idColor, int idSize, int idProduct) {
        for (int i = 0; i < listNewCart.size(); i++) {
            if (listNewCart.get(i).getIdColor() == idColor && listNewCart.get(i).getIdSize() == idSize && listNewCart.get(i).getIdProduct() == idProduct) {
                return i;
            }
        }
        return -1;
    }

    @GetMapping("getid")
    @ResponseBody
    private int getIdDetailProduct(@RequestParam int idProduct, @RequestParam String sizeName, @RequestParam String colorName) {
        int id = -1;
        DetailProductDTO dto = new DetailProductDTO();
        ProductDTO productDTO = new ProductDTO();
        SizeDTO sizeDTO = new SizeDTO();
        sizeDTO.setSizeName(sizeName);
        ColorProductDTO colorProductDTO = new ColorProductDTO();
        colorProductDTO.setColorName(colorName);
        productDTO.setIdProduct(idProduct);
        dto.setIdProduct(productDTO);
        dto.setSizeDTO(sizeDTO);
        dto.setColorProductDTO(colorProductDTO);

        ProductDTO productDTOs = restTemplate.postForObject(CoreConstant.LINK + "detailproduct/", dto, ProductDTO.class);
        for (DetailProductDTO dtos : productDTOs.getListDetailProductDTO()) {
            id = dtos.getIdDetailProduct();
        }
        return id;
    }

    @GetMapping(path = "viewcart", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public StringBuilder viewCart(HttpSession httpSession) {
        StringBuilder html = new StringBuilder("");
        int totalMoney = 0;
        html.append("<div id='viewcart' class='header-cart-content flex-w js-pscroll'>");
        html.append("<ul class='header-cart-wrapitem w-full'>");
        if (null != httpSession.getAttribute("cart")) {
            List<CartDTO> cartDTOList = (List<CartDTO>) httpSession.getAttribute("cart");
            for (CartDTO cart : cartDTOList) {
                html.append("<li class='header-cart-item flex-w flex-t m-b-12'>");
                html.append("<div class='header-cart-item-img'>");
                html.append("<img src=/resources/images/sanpham/"+cart.getImage()+"/>");
                html.append("</div>");
                html.append("<div class='header-cart-item-txt p-t-8'>");
                html.append("<a href='#' class='header-cart-item-name m-b-18 hov-cl1 trans-04'>");
                html.append(cart.getProductName());
                html.append("</a>");
                html.append("<span class='header-cart-item-info'>");
                html.append(cart.getAmount() + "x" + cart.getPrice());
                html.append("</span>");
                html.append("</div>");
                html.append("</li>");
                totalMoney += converCurrecy(cart.getPrice(), cart.getAmount());
            }
        }
        html.append("</ul>");
        html.append("<div class='w-full'>");
        html.append("<div class='header-cart-total w-full p-tb-40'>");
        html.append("Total:");
        html.append(totalMoney);
        html.append("</div>");
        html.append("<div class='header-cart-buttons flex-w w-full'>");
        html.append("<a href='/product-cart' class='flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10'>");
        html.append("View Cart");
        html.append("</a>");
        html.append("<a href='shoping-cart.html' class='flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-b-10'>");
        html.append("Check Out");
        html.append("</a>");
        html.append("</div>");
        html.append("</div>");

        return html;
    }

    private int converCurrecy(String money, int amount) {
        int totalMoney = 0;
        StringBuilder price = new StringBuilder("");
        String[] value = money.split("\\.");
        for (String s : value) {
            price.append(s);


        }
        totalMoney = (Integer.parseInt(price.toString())) * amount;


        return totalMoney;
    }

    @GetMapping("updatecart")
    @ResponseBody
    private void updateCart(@RequestParam int amount, @RequestParam int idProduct, @RequestParam int idSize, @RequestParam int idColor, HttpSession httpSession) {
        if (null != httpSession.getAttribute("cart")) {
            List<CartDTO> cartDTOList = (List<CartDTO>) httpSession.getAttribute("cart");
            int position = checkProductAlreadyExist(cartDTOList, idColor, idSize, idProduct);
            cartDTOList.get(position).setAmount(amount);

        }
    }

    @GetMapping("deletecart")
    @ResponseBody
    private void deleteCart(@RequestParam int idProduct, @RequestParam int idSize, @RequestParam int idColor, HttpSession httpSession) {
        if (null != httpSession.getAttribute("cart")) {
            List<CartDTO> cartDTOList = (List<CartDTO>) httpSession.getAttribute("cart");
            int position = checkProductAlreadyExist(cartDTOList, idColor, idSize, idProduct);
            cartDTOList.remove(position);

        }
    }

    @PostMapping("bill")
    public void addBill(@RequestParam String dataJson,HttpSession httpSession) {
        EmployeeDTO  id=null;
        ObjectMapper mapper = new ObjectMapper();
        BillDTO billDTO = new BillDTO();
        Employee employee = new Employee();
        Bill bill = new Bill();
        if(null!=httpSession.getAttribute("user"))
        {
             id=(EmployeeDTO) httpSession.getAttribute("user");
             employee.setIdemployee(id.getIdemployee());

        }
        try
        {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            billDTO = mapper.readValue(dataJson, BillDTO.class);
            bill.setCustomerName(billDTO.getCustomerName());
            bill.setPhoneNumber(billDTO.getPhoneNumber());
            bill.setAddressDelivery(billDTO.getAddressDelivery());
            bill.setStatuss(0);
            bill.setDateFounded(timeStamp);
            bill.setIdemployee(employee);
            RestTemplate restTemplate = new RestTemplate();
            URI uri  = restTemplate.postForLocation( CoreConstant.LINK+"bill", bill,Bill.class);
           if(null!=httpSession.getAttribute("cart"))
           {
               List<CartDTO>  cartDTOList=(List<CartDTO>)httpSession.getAttribute("cart");


               for(CartDTO item:cartDTOList)
               {
                   String str=uri.toASCIIString();
                   String parts[]=str.split("/");

                   int idBill=Integer.parseInt(parts[(parts.length)-1]);


                   DetailBill detailBill=new DetailBill();
                   DetailBillId detailBillId=new DetailBillId();
                   detailBillId.setIdBill(idBill);
                   detailBillId.setIdDetailProduct(item.getIdDetailProduct());
                   detailBill.setDetailBillId(detailBillId);
                   detailBill.setAmount(item.getAmount());
                   detailBill.setPrice(item.getPrice());
                   restTemplate.postForLocation( CoreConstant.LINK+"adddetailbill", detailBill,DetailBill.class);

               }

           }
        }
        catch (HttpStatusCodeException exception)
        {

            System.out.print(exception);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Autowired
    ServletContext context;

    @PostMapping("UploadFile")
    @ResponseBody
    public String UploadFile(MultipartHttpServletRequest request)
    {

//        String path_save_file = context.getRealPath("");

        Iterator<String> listNames = request.getFileNames();
        List<MultipartFile> files  =  request.getFiles(listNames.next());
        List<String> fileNames = new ArrayList<String>();

        for(MultipartFile multipartFile :files)
        {

            String fileName = multipartFile.getOriginalFilename();
            fileNames.add(fileName);
            File imageFile = new File(context.getRealPath("/resources/images/sanpham/"), fileName);
            try {
                multipartFile.transferTo(imageFile);            }
            catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            System.out.print(imageFile);

        }


        return "true";
    }
    @GetMapping(path = "detailbill", produces = "text/plain;charset=utf-8")
    public StringBuilder updateBill(@RequestParam int idBill)
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(CoreConstant.LINK+"bill")
                .queryParam("id", idBill);
        BillDTO billDTO=restTemplate.getForObject(builder.toUriString(),BillDTO.class);
        StringBuilder stringBuilder=new StringBuilder("");
        stringBuilder.append("<table class='table' id='table'>");
        stringBuilder.append("<tr>");
        stringBuilder.append("<td colspan='4'>");
        stringBuilder.append("<table style='width:100%'>");
        stringBuilder.append("<tr>");
        stringBuilder.append("<td>Mã đơn hàng:"+billDTO.getIdBill()+" <b style='color:red'>1 </b></td>");
        stringBuilder.append("<td>Tên khách hàng: <b style='color:red;'>"+billDTO.getCustomerName()+" </b></td>");
        stringBuilder.append("<td>Tình Trạng:");
        stringBuilder.append("<select id='sl_tinhtranghoadon'>");
        stringBuilder.append("<optgroup>");
        stringBuilder.append("<option data-option="+billDTO.getStatuss()+" value='chờ kiểm duyệt'>chờ kiểm duyệt</option>");
        stringBuilder.append("<option  data-option="+billDTO.getStatuss()+" value='đã hủy'>đã hủy</option>");
        stringBuilder.append("<option  data-option="+billDTO.getStatuss()+" value='đang giao hàng'>đang giao hàng</option>");
        stringBuilder.append("<option  data-option="+billDTO.getStatuss()+" value='hoàn thành'>hoàn thành</option>");


        stringBuilder.append("</optgroup>");
        stringBuilder.append("</select>");
        stringBuilder.append("</td>");
        stringBuilder.append("</tr>");
        stringBuilder.append("</table>");
        stringBuilder.append("</td>");
        stringBuilder.append("</tr>");

        stringBuilder.append("<tr>");
        stringBuilder.append("<td><b>Sản phẩm</b></td>");
        stringBuilder.append("<td><b>Hình ảnh</b></td>");
        stringBuilder.append("<td><b>Size</b></td>");
        stringBuilder.append("<td><b>mau</b></td>");
        stringBuilder.append("<td><b>Số lượng đặt</b></td>");
        stringBuilder.append("<td><b>Đơn giá đặt</b></td>");
        stringBuilder.append("</tr>");
        stringBuilder.append("<tr >");
        UriComponentsBuilder builders = UriComponentsBuilder.fromHttpUrl(CoreConstant.LINK + "bills")
                  .queryParam("id", idBill);
        ResponseEntity<List<DetailProductDTO>> response = restTemplate.exchange(
                builders.toUriString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DetailProductDTO>>(){});
        List<DetailProductDTO> detailProductDTOList = response.getBody();
        for(int i=0;i<detailProductDTOList.size();i++)
        {
            stringBuilder.append("<tr>");
            stringBuilder.append("<td data-detailproduct="+detailProductDTOList.get(i).getIdDetailProduct()+" >"+detailProductDTOList.get(i).getIdProduct().getProductName()+"</td>");
            stringBuilder.append("<td ><img width='150' height='150' src=/resources/images/sanpham/"+detailProductDTOList.get(i).getIdProduct().getImage()+" width='150' height='50' /></td>");
            stringBuilder.append("<td >"+detailProductDTOList.get(i).getSizeDTO().getSizeName()+"</td>");
            stringBuilder.append("<td >"+detailProductDTOList.get(i).getColorProductDTO().getColorName()+"</td>");
            stringBuilder.append("<td class='detail-product' data-id="+detailProductDTOList.get(i).getIdDetailProduct()+">"+ detailProductDTOList.get(i).getListDetailBillDTO().get(0).getAmount()+"</td>");
            stringBuilder.append("<td>"+ detailProductDTOList.get(i).getListDetailBillDTO().get(0).getPrice()+"</td>");
            stringBuilder.append("</tr>");
        }
        stringBuilder.append("<tr>");

        stringBuilder.append("<td align='right' colspan='8'>Tổng tiền: đồng</td>");
        stringBuilder.append("</tr>");
        stringBuilder.append("</table>");
        return stringBuilder;
    }
    @GetMapping("updatebill")
    private void updateDetailProduct(@RequestParam int idDetailPoduct,@RequestParam int amount)
    {
        UriComponentsBuilder builders = UriComponentsBuilder.fromHttpUrl(CoreConstant.LINK + "detailproducts")
                .queryParam("id", idDetailPoduct);
        RestTemplate restTemplate = new RestTemplate();
        DetailProduct detailProduct=new DetailProduct();
        detailProduct.setAmount(amount);
        restTemplate.put(builders.toUriString(),detailProduct);
    }
    @GetMapping("updatebills")
    private void updateBill (@RequestParam int idBill,@RequestParam int currentStatus)
    {
        UriComponentsBuilder builders = UriComponentsBuilder.fromHttpUrl(CoreConstant.LINK + "bills")
                .queryParam("id", idBill);
        RestTemplate restTemplate = new RestTemplate();
        Bill bill=new Bill();
        bill.setStatuss(currentStatus);
        restTemplate.put(builders.toUriString(),bill);

    }



}
