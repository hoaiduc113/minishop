package com.hoaiduc.core.daoimpl;

import com.hoaiduc.core.dao.ProductDao;
import com.hoaiduc.core.data.daoimpl.AbstractDao;
import com.hoaiduc.core.persistence.data.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Map;

@Repository
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class ProducDaoImp  extends AbstractDao<Integer, Product> implements ProductDao
{
    @Autowired
    SessionFactory sessionFactory;
    @Transactional
    public Product getProductById(int id)
    {
        Session session= sessionFactory.getCurrentSession();
        Product product=null;
        try
        {
            StringBuilder sql =new StringBuilder("from Product p JOIN FETCH p.listDetailProduct l JOIN FETCH l.size JOIN FETCH l.colorProduct JOIN FETCH l.imageProduct where p.idProduct= :idProduct ");
            product=(Product) session.createQuery(sql.toString()).setParameter("idProduct",id).getSingleResult();
            return product;
        }
        catch (Exception e)
        {
            return product=null;
        }

    }
    @Transactional
    public Product getIdDetailProduct(int idProduct,String sizeName,String colorName)
    {
        Session session= sessionFactory.getCurrentSession();
        Product product=null;
        try
        {
            StringBuilder sql =new StringBuilder("from Product p JOIN FETCH p.listDetailProduct l JOIN FETCH l.size s JOIN FETCH l.colorProduct c where p.idProduct= :idProduct AND s.sizeName= :sizeName AND c.colorName= :colorName ");
            product=(Product) session.createQuery(sql.toString()).setParameter("idProduct",idProduct).setParameter("sizeName",sizeName).setParameter("colorName",colorName).getSingleResult();

            return product;
        }
        catch (Exception e)
        {
            return product=null;
        }
    }


}
