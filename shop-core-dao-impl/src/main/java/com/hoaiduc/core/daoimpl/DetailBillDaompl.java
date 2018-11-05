package com.hoaiduc.core.daoimpl;

import com.hoaiduc.core.dao.DetailBillDao;
import com.hoaiduc.core.data.daoimpl.AbstractDao;
import com.hoaiduc.core.persistence.data.entity.DetailBill;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class DetailBillDaompl extends AbstractDao<Integer, DetailBill> implements DetailBillDao
{

}
