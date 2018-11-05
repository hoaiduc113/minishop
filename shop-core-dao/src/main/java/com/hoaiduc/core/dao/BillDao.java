package com.hoaiduc.core.dao;

import com.hoaiduc.core.data.dao.GenericDao;
import com.hoaiduc.core.persistence.data.entity.Bill;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;

import java.util.List;

public interface BillDao extends GenericDao<Integer, Bill>
{
    List<DetailProduct> findDetailBillByID(int id);
}
