package com.wangbo.repository;

import com.wangbo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    @QueryHints({@QueryHint(name = org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value = "true")})
    @Query("FROM Department d")
    List<Department> getAll();
}
