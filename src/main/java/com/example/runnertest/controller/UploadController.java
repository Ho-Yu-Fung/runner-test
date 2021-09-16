package com.example.runnertest.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {
    @PostMapping("/upload")
    public Map up(@RequestParam("file") MultipartFile[] files, HttpServletRequest request){
        HashMap<Object, Object> res = new HashMap<>();
        for(MultipartFile file: files){
            if (file.isEmpty()){
                res.put("msg","失败");
            }
            String filename = file.getOriginalFilename();
            File des = new File(System.getProperty("user.dir")+"/src/main/resources/static/up/"+filename);
            try{
                file.transferTo(des);
                String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+filename;
                res.put("msg","success");
                res.put("path",des);
                res.put("url",url);
            } catch (IOException e) {
                e.printStackTrace();
                res.put("msg","失败");
            }
        }
        return res;
    }
    @RequestMapping("/f")
    public ModelAndView f(){
        ModelAndView view = new ModelAndView();
        view.setViewName("upfile.html");
        return view;
    }
}

