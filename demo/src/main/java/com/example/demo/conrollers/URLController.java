package com.example.demo.conrollers;

import com.example.demo.service.URLService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
@RequestMapping("/url")
public class URLController {

    private final URLService urlService;

    public URLController(URLService urlService) {
        this.urlService = urlService;
    }

    @Operation(summary = "Возвращает историю измененых ссылок", description = "Возвращают мапу, shortURL против его longURL")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Апи возвращены"),
    })
    @GetMapping("/history/{name}")
    public Map<String, String> getAllURLByUnit(@PathVariable(name = "name") String name) {
        return urlService.getAllByUserName(name);
    }


    @Operation(summary = "Редиректит на оригинал ссылки",
            description = "В свагере нет смысла её вводить, сразу в строку поиска браузера надо")
    @GetMapping("/{shortUrl}")
    public RedirectView redirect(@PathVariable String shortUrl) {
        String longUrl = urlService.getURL(shortUrl);
        return new RedirectView(longUrl);
    }

    @Operation(summary = "Создает сокращенную апи", description = "Создает сокращенную апи по введенной ссылке")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Апи создана"),
    })
    @PostMapping("/create")
    public String create(@RequestParam String longURL) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();

        return urlService.createShortURL(longURL, userId);
    }
}
