package com.hoaiduc.core.convert;

import com.hoaiduc.core.dto.*;
import com.hoaiduc.core.persistence.data.entity.Bill;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class BillConvert
{
    private ModelMapper modelMapper=new ModelMapper();
    public BillDTO convertBillDTO(Bill bill)
    {
        BillDTO billDTO=new BillDTO();
        modelMapper.map(bill,billDTO);
        return billDTO;
    }
    public List<BillDTO> converBill(List<Bill> listBill)
    {
        List<BillDTO> billDTOList=new ArrayList<BillDTO>();
        for(Bill bill:listBill)
        {
           BillDTO billDTO=new BillDTO();
           modelMapper.map(bill,billDTO);
           billDTOList.add(billDTO);
        }
        return billDTOList;
    }
    public List<DetailProductDTO> converDetailBill(List<DetailProduct> listDetailProduct)
    {
        int size=0;
        List<DetailProductDTO> list=new ArrayList<DetailProductDTO>();
        List<DetailBillDTO> detailBillDTOList=new ArrayList<DetailBillDTO>();
        for(int i=0;i<listDetailProduct.size();i++)
        {
            DetailBillDTO detailBillDTO=new DetailBillDTO();
            DetailProductDTO detailProductDTO=new DetailProductDTO();
            SizeDTO sizeDTO=new SizeDTO();
            ColorProductDTO colorProductDTO=new ColorProductDTO();
            sizeDTO.setSizeName(listDetailProduct.get(i).getSize().getSizeName());
            sizeDTO.setIdSize(listDetailProduct.get(i).getSize().getIdSize());
            colorProductDTO.setColorName(listDetailProduct.get(i).getColorProduct().getColorName());
            colorProductDTO.setIdColorProduct(listDetailProduct.get(i).getColorProduct().getIdColorProduct());
            detailProductDTO.setColorProductDTO(colorProductDTO);
            detailProductDTO.setSizeDTO(sizeDTO);
            detailBillDTO.setAmount(listDetailProduct.get(i).getListDetailBill().get(0).getAmount());
            detailBillDTO.setPrice(listDetailProduct.get(i).getListDetailBill().get(0).getPrice());
            detailBillDTOList.add(detailBillDTO);
            detailProductDTO.setListDetailBillDTO(detailBillDTOList);
            modelMapper.map(listDetailProduct.get(i),detailProductDTO);
            list.add(detailProductDTO);

        }

//        for(int i=0;i<size;i++)
//        {
//            DetailProductDTO detailProductDTO=new DetailProductDTO();
//
//
//            detailProductDTO.setListDetailBillDTO(detailBillDTOList);
//            list.add(detailProductDTO);
//
//        }
        return list;
    }

}
