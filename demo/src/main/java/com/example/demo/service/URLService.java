package com.example.demo.service;

import com.example.demo.entity.URLEntity;
import com.example.demo.repositories.URLRepository;
import com.example.demo.repositories.UserRepository;
import org.hashids.Hashids;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class URLService {
    private static final Hashids hashids = new Hashids("",9);
    public static final String URL = "http://localhost:8080/url/";
    private static long idCounter = new Date().getTime();
    private final URLRepository urlRepository;
    private final UserRepository userRepository;

    public URLService(URLRepository urlRepository, UserRepository userRepository) {
        this.urlRepository = urlRepository;
        this.userRepository = userRepository;
    }

    public  Map<String,String> getAllByUserName(String name){
        Map<String,String> history = new HashMap<>();
        var urlList = urlRepository.findAllByUserName(name);

        for(var url: urlList){
            history.put(url.getShortURL(),url.getLongURL());
        }
        return history;
    }

    public String createShortURL(String longURL, String userName) {
        String shortUrl = URL + hashids.encode(idCounter++);
        var user = userRepository.findByName(userName);

        var urlEntity = URLEntity.builder()
                .userId(user)
                .longURL(longURL)
                .shortURL(shortUrl).build();
        urlRepository.save(urlEntity);

        return shortUrl;
    }


    public String getURL(String shortUrl) {
        var urlEntity = urlRepository.getByShortURL(shortUrl);
        return urlEntity.getLongURL();
    }
}
