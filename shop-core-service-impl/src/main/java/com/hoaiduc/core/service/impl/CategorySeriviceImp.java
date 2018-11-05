package com.hoaiduc.core.service.impl;

import com.hoaiduc.core.convert.CategoryConvert;
import com.hoaiduc.core.dao.CategoryDao;
import com.hoaiduc.core.dto.CategoryDTO;
import com.hoaiduc.core.persistence.data.entity.Category;
import com.hoaiduc.core.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CategorySeriviceImp implements CategoryService
{
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    CategoryConvert categoryConvert;
    public List<CategoryDTO> findAll()
    {
        List<Category> categoryList=categoryDao.findAll();
        return categoryConvert.convertCategory(categoryList) ;
    }
}
