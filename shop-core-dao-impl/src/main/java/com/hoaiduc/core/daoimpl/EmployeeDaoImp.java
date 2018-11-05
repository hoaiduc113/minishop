package com.hoaiduc.core.daoimpl;

import com.hoaiduc.core.dao.EmployeeDao;
import com.hoaiduc.core.data.daoimpl.AbstractDao;
import com.hoaiduc.core.persistence.data.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import javax.transaction.Transactional;
@Repository
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class EmployeeDaoImp extends AbstractDao<String, Employee> implements EmployeeDao
{
    @Autowired
    SessionFactory sessionFactory;
    @Transactional
    public Employee checkLogin(String email, String password)
    {
        Session session= sessionFactory.getCurrentSession();
        Employee employee=null;
        try
        {
            StringBuilder sql =new StringBuilder("from Employee e JOIN FETCH e.roll where e.email= :email AND e.password= :password");
            employee=(Employee) session.createQuery(sql.toString()).setParameter("email",email).setParameter("password",password).getSingleResult();
            if(employee!=null)
            {
                return employee;
            }
            else
            {
                employee=null;
            }
        }
        catch (Exception e)
        {
            return employee=null;
        }


        return employee;
    }
    @Transactional

    public boolean isExist(String email)
    {
        Session session= sessionFactory.getCurrentSession();
        Employee employee=null;
        try
        {
            StringBuilder sql =new StringBuilder("from Employee e where e.email= :email ");
            employee=(Employee) session.createQuery(sql.toString()).setParameter("email",email).getSingleResult();
            if(employee!=null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
