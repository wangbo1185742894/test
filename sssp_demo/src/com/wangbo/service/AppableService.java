package com.wangbo.service;

import com.wangbo.entity.AppAble;
import com.wangbo.repository.AppableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppableService {

    @Autowired
    AppableRepository appableRepository;

    public String getAppAble(String appname){
        AppAble appAble = appableRepository.getAppAbleByAppname(appname);
        if (appAble == null){
            return "0";
        }
        return appAble.getAble();
    }
}
