package com.example.demo.repositories;

import com.example.demo.entity.URLEntity;
import com.example.demo.service.URLService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface URLRepository extends JpaRepository<URLEntity,Long> {
    @Query("SELECT url FROM URLEntity url where url.userId.name = :name")
    List<URLEntity> findAllByUserName(String name);

    @Query("SELECT url FROM URLEntity url where url.shortURL LIKE %:shortUrl")
    URLEntity getByShortURL(String shortUrl);
}
