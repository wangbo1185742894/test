package com.wangbo.handle;


import com.wangbo.service.AppableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/appable")
public class AppableHandle {

    @Autowired
    AppableService appableService;

    @RequestMapping("/check")
    @ResponseBody
    public String appAble(@RequestParam(value = "name",required = false,defaultValue = "1")String name){

        return appableService.getAppAble(name);

    }
}
