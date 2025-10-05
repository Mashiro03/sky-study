package com.sky.service;

import com.sky.context.BaseContext;
import com.sky.dto.DishDTO;
import org.springframework.transaction.annotation.Transactional;
public interface DishService {

    @Transactional
    public void savewithFlavor(DishDTO dishDTO);

}
