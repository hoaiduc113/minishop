package com.hoaiduc.core.service.impl;

import com.hoaiduc.core.dao.DetailBillDao;
import com.hoaiduc.core.persistence.data.entity.DetailBill;
import com.hoaiduc.core.service.DetailBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailBillServiceImpl implements DetailBillService
{
    @Autowired
    DetailBillDao detailBillDao;

    public void save(DetailBill detailBill)
    {
        detailBillDao.save(detailBill);
    }
}
