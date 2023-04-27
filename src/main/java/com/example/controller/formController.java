package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 文件上传controller
 */
@Controller
@Slf4j
public class formController {

    @GetMapping("/form_layouts.html")
    public String goToFormLayout() {
        return "form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart MultipartFile[] photos
    ) throws IOException {
        log.info("上传的信息，email={},username={},headerImg={},photos={}",email,username,headerImg.getSize(),photos.length);
        if(!headerImg.isEmpty()) {
            //获取文件原始的名称
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\start-springboot\\boot-test\\src\\main\\resources\\UpdataFile\\"+originalFilename));
        }
        //判断photos是否存在
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\start-springboot\\boot-test\\src\\main\\resources\\UpdataFile\\live\\" + originalFilename));
                }
            }
        }
        return "main";
    }
}
