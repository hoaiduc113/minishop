package com.hoaiduc.core.data.daoimpl;

import com.hoaiduc.core.constant.CoreConstant;
import com.hoaiduc.core.data.dao.GenericDao;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import sun.plugin.dom.core.CoreConstants;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class AbstractDao<ID extends Serializable,T > implements GenericDao<ID ,T >
{
    private Class<T> persistenceClass;
    public AbstractDao()
    {
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];

    }
    public String getPersistenceClass() {
        return persistenceClass.getSimpleName();
    }

    @Autowired
    SessionFactory sessionFactory;
    @Transactional
    public List<T> findAll()
    {
        Session session= sessionFactory.getCurrentSession();
        StringBuilder sql =new StringBuilder("from ");
        sql.append(this.getPersistenceClass());
        List<T> t=(List<T>)session.createQuery(sql.toString()).getResultList();
        return t;
    }
    @Transactional
    public T save(T entity)
    {
        Session session= sessionFactory.getCurrentSession();
        session.persist(entity);
        return entity;
    }
    @Transactional
    public List<T> getProduct(int begin,int end)
    {
        Session session= sessionFactory.getCurrentSession();
        StringBuilder sql=new StringBuilder("from ");
        sql.append(this.getPersistenceClass());
        List<T> list=(List<T>) session.createQuery(sql.toString()).setFirstResult(begin).setMaxResults(end).getResultList();
        return list;
    }
    @Transactional

    public T findByID(ID id)
    {
        T result=null;

        Session session= sessionFactory.getCurrentSession();
        try
        {
            result=(T) session.get(persistenceClass,id);
            if(result==null)
            {
                throw new ObjectNotFoundException(" NOT FOUND " +id, null);

            }
            return result;
        }
        catch (HibernateException e)
        {

        }
        return result;
    }

    @Transactional
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, String whereClause)
    {
        List<T> list=new ArrayList<T>();
        Session session= sessionFactory.getCurrentSession();
        Object totalItem=0;
        Object[] nameQuery= CoreConstant.buildNameQuery(property);
        try
        {
            StringBuilder sql=new StringBuilder(" from   ");
            sql.append(getPersistenceClass()).append(" where 1=1 ").append(nameQuery[0]);
            if(sortExpression!=null)
            {
                sql.append(" order by ").append(sortExpression);
                sql.append(" "+(sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            if(whereClause!=null)
            {
                sql.append(whereClause);
            }
            Query query=session.createQuery(sql.toString());
            setParameterToQuery(nameQuery,query);
            if(offset!=null && offset>=0)
            {
                query.setFirstResult(offset);
            }
            if(limit!=null && limit>0)
            {
                query.setMaxResults(limit);
            }
            list=query.list();
            StringBuilder sql2=new StringBuilder("select  count(*) from ");
            sql2.append(getPersistenceClass()).append(" where 1=1 ").append(nameQuery[0]);
            if(whereClause !=null)
            {
                sql2.append(whereClause);
            }
            Query query2=session.createQuery(sql2.toString());
            setParameterToQuery(nameQuery,query2);
            totalItem=query2.list().get(0);
        }
        catch (HibernateException e)
        {

        }
        return new Object[]{totalItem,list};
    }
    @Transactional
    public T update(T t)
    {
        Session session= sessionFactory.getCurrentSession();
        T result=null;
        try
        {
            Object object=session.merge(t);
            result=(T) object;
            return result;
        }
        catch (HibernateException e)
        {

        }
        return result;
    }

    private void setParameterToQuery(Object[] nameQuery, Query query)
    {
        if(nameQuery.length==3)
        {
            //the first parameter is the colum name in table
            //the seconds is the paramter user transission
            String[] params=(String[]) nameQuery[1];
            Object[] values=(Object[]) nameQuery[2];
            for(int i2=0;i2<params.length;i2++)
            {
                query.setParameter(params[i2],values[i2]);
            }
        }
    }


}
