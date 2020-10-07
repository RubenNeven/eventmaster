package com.eventmaster.backend.controller.event.mapper;

import com.eventmaster.backend.controller.event.dto.CategoryDto;
import com.eventmaster.backend.controller.event.dto.CategoryDtoList;
import com.eventmaster.backend.entity.event.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public CategoryDto map(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .categoryName(category.getName())
                .build();
    }

    public CategoryDtoList convertToCategoryDtoList(List<Category> categories){
        return CategoryDtoList.builder()
                .categories(categories.stream().map(this::map).collect(Collectors.toList()))
                .build();
    }
}
