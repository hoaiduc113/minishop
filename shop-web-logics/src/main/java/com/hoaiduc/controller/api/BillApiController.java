package com.hoaiduc.controller.api;

import com.hoaiduc.core.constant.CoreConstant;
import com.hoaiduc.core.dto.BillDTO;
import com.hoaiduc.core.dto.DetailProductDTO;
import com.hoaiduc.core.persistence.data.entity.Bill;
import com.hoaiduc.core.service.BillService;
import com.hoaiduc.core.service.impl.BillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/ajax/api/",produces = MediaType.APPLICATION_JSON_VALUE)
public class BillApiController
{
    @Autowired
    BillServiceImp billServiceImp;
    @PostMapping("bill")
    public ResponseEntity<Void> save(@RequestBody Bill bill, UriComponentsBuilder uriComponentsBuilder)
    {
        billServiceImp.save(bill);
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("bill/{id}").buildAndExpand(bill.getIdBill()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @GetMapping("limitbills")
    public ResponseEntity<List<BillDTO>> getLimitDetailBill()
    {
        List<BillDTO> billDTOList= billServiceImp.limitDetailBill(0, CoreConstant.MAXIEM);
        if(billDTOList==null)
        {
            return new ResponseEntity<List<BillDTO>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND

        }
        return new ResponseEntity<List<BillDTO>>(billDTOList,HttpStatus.OK);

    }
    @GetMapping("bills")
    public ResponseEntity<List<DetailProductDTO>> get(@RequestParam("id") int id)
    {
        List<DetailProductDTO> detailProductDTO=billServiceImp.findDetailBillByID(id);
            if(detailProductDTO==null)
            {
                return new ResponseEntity<List<DetailProductDTO>>(HttpStatus.NOT_FOUND);
            }
         return new ResponseEntity< List<DetailProductDTO>>(detailProductDTO,HttpStatus.OK);
    }
    @GetMapping("bill")
    public ResponseEntity<BillDTO> getBill(@RequestParam("id") int id)
    {
        BillDTO bill=billServiceImp.findByID(id);
        if(bill==null)
        {
            return new ResponseEntity<BillDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity< BillDTO>(bill,HttpStatus.OK);
    }
    @PutMapping("bills")
    public ResponseEntity<BillDTO> update(@RequestParam("id") int id,@RequestBody Bill bill)
    {
        Bill currentBill=billServiceImp.findUpdate(id);
        if(currentBill==null)
        {
            return new ResponseEntity<BillDTO>(HttpStatus.NOT_FOUND);
        }
        currentBill.setStatuss(bill.getStatuss());
        BillDTO billDTO=billServiceImp.update(currentBill);
        return new ResponseEntity<BillDTO>(billDTO,HttpStatus.OK);
    }
}
