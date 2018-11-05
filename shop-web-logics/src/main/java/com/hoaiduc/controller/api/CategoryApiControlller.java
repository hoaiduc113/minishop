package com.hoaiduc.controller.api;

import com.hoaiduc.core.dto.CategoryDTO;
import com.hoaiduc.core.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/ajax/api/",produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryApiControlller
{
    @Autowired
    CategoryService categoryService;
    @GetMapping("categorys")
    public ResponseEntity<List<CategoryDTO>> findAll()
    {
        List<CategoryDTO> categoryDTOList=categoryService.findAll();
        if(categoryDTOList.isEmpty())
        {
            return new ResponseEntity<List<CategoryDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CategoryDTO>>(categoryDTOList,HttpStatus.OK);
    }
}
