package com.hoaiduc.core.convert;

import com.hoaiduc.core.dto.CategoryDTO;
import com.hoaiduc.core.persistence.data.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class CategoryConvert
{
    private ModelMapper modelMapper=new ModelMapper();
    public List<CategoryDTO> convertCategory(List<Category> litsCategory)
    {
        List<CategoryDTO> categoryDTOList=new ArrayList<CategoryDTO>();
        CategoryDTO categoryDTO=null;
        for(Category category:litsCategory)
        {
            categoryDTO=new CategoryDTO();
            categoryDTO.setCategoryName(category.getCategoryName());
            categoryDTO.setIdCategoryProducts(category.getIdCategoryProducts());
            categoryDTOList.add(categoryDTO);

        }
        return categoryDTOList;
    }
}
