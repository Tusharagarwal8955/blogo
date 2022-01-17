package com.aruiga.blogo.repositories;

import java.util.List;

import com.aruiga.blogo.entities.BlogEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Integer> {

    @Query(value = "select * from blog_entity order by creation_date DESC",nativeQuery=true)
    List<BlogEntity> sortByDate();
}

