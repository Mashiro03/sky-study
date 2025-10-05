package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/admin/common")
public class CommonController {
    @Autowired
    private AliOssUtil aliossutil;
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile  file){
        log.info("文件上传");
        try {
            String originfilename=file.getOriginalFilename();
            String filename=originfilename.substring(originfilename.lastIndexOf("."));
            String objectname= UUID.randomUUID().toString()+ filename;
            String filepath=aliossutil.upload(file.getBytes(),objectname);
            return Result.success(filepath);
        } catch (IOException e) {
            log.error("文件上传失败: {}",e);
        }

        return Result.error("上传失败");
    }
}
