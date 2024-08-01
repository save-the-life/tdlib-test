package com.slfoundation.tdlib_test.Controller;

import com.slfoundation.tdlib_test.Dto.Request.UserDto.JoinDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {


    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto dto) {

    }

}
