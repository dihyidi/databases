package com.app.controller;

import com.app.dto.LoginDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/login")
@RestController
@AllArgsConstructor
@Slf4j
public class LoginController {
    private final String PASSWORD = "Diana123";
    private final String SUCCESSFUL_LOGIN_MESSAGE = "User logged in successfully :)";
    private final String FAILED_LOGIN_MESSAGE = "Incorrect password :(";

    @RequestMapping(method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String login(@RequestBody LoginDto loginDto) {
        log.info("Login started");

        if(loginDto.getPassword().equals(PASSWORD)) {
            log.info(SUCCESSFUL_LOGIN_MESSAGE);
            return SUCCESSFUL_LOGIN_MESSAGE;
        }

        log.error(FAILED_LOGIN_MESSAGE);
        return FAILED_LOGIN_MESSAGE;
    }
}
