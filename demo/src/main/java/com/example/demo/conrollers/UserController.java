package com.example.demo.conrollers;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Operation(summary = "Создание пользователя", description = "Создание пользователя после чего можно пользоваться апи")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "возвращает true, если создал"),
    })
    @PostMapping("/create")
    public Boolean create(@RequestParam String name, @RequestParam String password){
       return userService.create(name, password);
    }
}
