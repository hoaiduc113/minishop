package com.hoaiduc.core.daoimpl;

import com.hoaiduc.core.dao.BillDao;
import com.hoaiduc.core.data.daoimpl.AbstractDao;
import com.hoaiduc.core.persistence.data.entity.Category;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode= ScopedProxyMode.TARGET_CLASS)
public class CategoryDao extends AbstractDao<Integer, Category> implements com.hoaiduc.core.dao.CategoryDao
{
}
