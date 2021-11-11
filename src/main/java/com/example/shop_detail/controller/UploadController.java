package com.example.shop_detail.controller;

import com.example.shop_detail.application.UploadApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class UploadController {

    @Resource
    private UploadApplication uploadApplication;

    @RequestMapping("/upload")
    public ResultData upload(MultipartFile file) throws IOException {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        uploadApplication.upload(file);
        return resultData;
    }

}
