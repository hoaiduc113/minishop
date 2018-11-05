package com.hoaiduc.core.daoimpl;

import com.hoaiduc.core.constant.CoreConstant;
import com.hoaiduc.core.dao.BillDao;
import com.hoaiduc.core.data.daoimpl.AbstractDao;
import com.hoaiduc.core.persistence.data.entity.Bill;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class BillDaoImp extends AbstractDao<Integer, Bill> implements BillDao
{
    @Autowired
    SessionFactory sessionFactory;
    @Transactional
    public List<DetailProduct> findDetailBillByID(int id)
    {
        Session session= sessionFactory.getCurrentSession();
        List<DetailProduct> bill=null;
        try
        {
            StringBuilder sql =new StringBuilder(" from DetailProduct d JOIN FETCH  d.idProduct JOIN FETCH d.size JOIN FETCH d.colorProduct  JOIN FETCH d.listDetailBill l JOIN FETCH l.detailBillId b where b.idBill= :idBill");
            bill=( List<DetailProduct>) session.createQuery(sql.toString()).setParameter("idBill",id).getResultList();
            return bill;
        }
        catch (Exception e)
        {
            return bill=null;
        }

    }



}
