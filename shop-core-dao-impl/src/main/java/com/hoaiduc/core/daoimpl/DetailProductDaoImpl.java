package com.hoaiduc.core.daoimpl;

import com.hoaiduc.core.dao.DetailProductDao;
import com.hoaiduc.core.data.daoimpl.AbstractDao;
import com.hoaiduc.core.persistence.data.entity.DetailProduct;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class DetailProductDaoImpl extends AbstractDao<Integer, DetailProduct> implements DetailProductDao
{
    @Autowired
    SessionFactory sessionFactory;
    @Transactional
    public DetailProduct updateDetailProduct(int detailProductID, int amount)
    {
        Session session= sessionFactory.getCurrentSession();

        try
        {
                DetailProduct detailProduct=(DetailProduct) session.get(DetailProduct.class,detailProductID);
                detailProduct.setAmount(amount);
                session.update(detailProduct);
                return detailProduct;
        }
        catch (HibernateException  hx)
        {

        }
        return null;
    }
}
