package com.hoaiduc.core.data.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<ID extends Serializable,T  >
{
    List<T> findAll();
    T       save(T entity);
    List<T> getProduct(int begin,int end);
    T       findByID(ID id);
    Object[] findByProperty(Map<String,Object> property,String sortExpression,String sortDirection,Integer offset,Integer limit,String whereClause);
    T update(T t);
}
