package com.hoaiduc.controller.api;

import com.hoaiduc.core.dto.DetailBillDTO;
import com.hoaiduc.core.persistence.data.entity.DetailBill;
import com.hoaiduc.core.service.impl.DetailBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/ajax/api/",produces = MediaType.APPLICATION_JSON_VALUE)
public class DetailBillApiController
{
    @Autowired
    DetailBillServiceImpl detailBillService;
    @PostMapping("adddetailbill")
    public ResponseEntity<Void> save(@RequestBody DetailBill detailBill, UriComponentsBuilder uriComponentsBuilder)
    {
        detailBillService.save(detailBill);
        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("detailbill/{id}").buildAndExpand(detailBill.getDetailBillId().getIdBill()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
