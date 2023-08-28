package com.example.monofriend.handler.impl;

import com.example.monofriend.handler.UserRequestHandler;
import com.example.monofriend.model.UserRequest;
import com.example.monofriend.service.MonoFriendService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StartCommandHandler implements UserRequestHandler {
    private static final String COMMAND_PATTERN = "/start";
    private final MonoFriendService monoFriendService;

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return monoFriendService.checkCommandExists(userRequest.getUpdate().getMessage(), COMMAND_PATTERN);
    }

    @Override
    public void handle(UserRequest userRequest) {
        monoFriendService.sendWelcomeMessage(userRequest);
    }
}
