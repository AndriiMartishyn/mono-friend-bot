package com.example.monofriend.dispatcher;

import com.example.monofriend.handler.UserRequestHandler;
import com.example.monofriend.model.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class MonoBotDispatcher {
    private final List<UserRequestHandler> handlersList;

    public boolean dispatch(UserRequest userRequest) {
        return handlersList.stream()
                .anyMatch(userRequestHandler -> {
                    if (userRequestHandler.isApplicable(userRequest)){
                        userRequestHandler.handle(userRequest);
                        return true;
                    }
                    return false;
                });
    }
}
