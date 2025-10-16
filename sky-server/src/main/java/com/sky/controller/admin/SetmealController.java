package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealservice;
    @PostMapping
    @ResponseBody
    public Result save(@RequestBody SetmealDTO setmealDTO){
        setmealservice.save(setmealDTO);
        return Result.success();
    }


    @ResponseBody
    @GetMapping("/page")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO){
        return Result.success(setmealservice.page(setmealPageQueryDTO));
    }


    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids){
        setmealservice.delete(ids);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result<SetmealVO> getById(@PathVariable Long id){
        return Result.success(setmealservice.getById(id));
    }

    @PutMapping
    @ApiOperation("修改套餐")
    public Result update(@RequestBody SetmealDTO setmealDTO) {
        setmealservice.update(setmealDTO);
        return Result.success();
    }
    @PostMapping("/status/{status}")
    @ApiOperation("套餐起售停售")
    public Result startOrStop(@PathVariable Integer status, Long id) {
        setmealservice.startOrStop(status, id);
        return Result.success();
    }
}
