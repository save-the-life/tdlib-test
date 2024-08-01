package com.slfoundation.tdlib_test.Service;

import com.slfoundation.tdlib_test.Dto.Request.UserDto.JoinDto;
import org.drinkless.tdlib.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TelegramService {

    @Autowired
    private Client client;

    public CompletableFuture<void> authenticateUser(JoinDto dto) {

    }

}
