package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishflavorMapper {

    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);
    @Delete("delete from sky_take_out.dish_flavor where dish_id =#{id} ")
    void deleteByDishId(Long id);

    void deleteByDishIds(List<Long> dishids);
    @Select("select *from sky_take_out.dish_flavor where dish_id =#{id}")
    List<DishFlavor> getByid(Long id);
}
