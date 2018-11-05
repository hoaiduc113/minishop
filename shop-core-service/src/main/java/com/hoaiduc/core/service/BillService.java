package com.hoaiduc.core.service;

import com.hoaiduc.core.dto.BillDTO;
import com.hoaiduc.core.dto.DetailProductDTO;
import com.hoaiduc.core.persistence.data.entity.Bill;

import java.util.List;

public interface BillService
{
    void save(Bill bill);
    List<DetailProductDTO> findDetailBillByID(int id);
    List<BillDTO>          limitDetailBill(int  begin,int end);
    BillDTO                findByID(int id);
    Bill                   findUpdate(int id);
    BillDTO                update(Bill bill);
}
