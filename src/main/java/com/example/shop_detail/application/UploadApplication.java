package com.example.shop_detail.application;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadApplication {


    void upload(MultipartFile file) throws IOException;
}
