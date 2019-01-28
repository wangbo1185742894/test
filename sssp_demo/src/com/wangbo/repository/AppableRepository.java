package com.wangbo.repository;

import com.wangbo.entity.AppAble;
import com.wangbo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppableRepository extends JpaRepository<AppAble,Integer> {

    public AppAble getAppAbleByAppname(String name);

}
