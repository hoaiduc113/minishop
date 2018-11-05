package com.hoaiduc.core.service.impl;

import com.hoaiduc.core.convert.BillConvert;
import com.hoaiduc.core.convert.ProductConvert;
import com.hoaiduc.core.daoimpl.BillDaoImp;
import com.hoaiduc.core.dto.BillDTO;
import com.hoaiduc.core.dto.DetailProductDTO;
import com.hoaiduc.core.persistence.data.entity.Bill;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;
import com.hoaiduc.core.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillServiceImp implements BillService
{
    @Autowired
    BillDaoImp billDaoImp;
    @Autowired
    BillConvert billConvert;
    public void save(Bill bill)
    {

        billDaoImp.save(bill);
    }

    public List<DetailProductDTO> findDetailBillByID(int id)
    {
        List<DetailProduct> detailProduct = billDaoImp.findDetailBillByID(id);
        return  billConvert.converDetailBill(detailProduct);
    }

    public List<BillDTO> limitDetailBill(int begin, int end) {
        List<Bill> listBill=billDaoImp.getProduct(begin,end);
        return  billConvert.converBill(listBill);
    }

    public BillDTO findByID(int id)
    {
        Bill bill=billDaoImp.findByID(id);
        return billConvert.convertBillDTO(bill);
    }

    public Bill findUpdate(int id)
    {
        return billDaoImp.findByID(id);
    }

    public BillDTO update(Bill bill) {
        Bill currentBill=billDaoImp.update(bill);
        return billConvert.convertBillDTO(currentBill);
    }


}
