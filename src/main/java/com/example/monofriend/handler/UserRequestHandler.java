package com.example.monofriend.handler;

import com.example.monofriend.model.UserRequest;

public interface UserRequestHandler {
    /**
     * Default common method that is used to check if message from request has
     * pre-defined command from command list to handle it with appropriate
     * handler for particular command.
     * @param userRequest
     * @return true if command is same as message text, otherwise false
     */
    boolean isApplicable(UserRequest userRequest);

    /**
     * Default common method that is used to handle user request
     * @param userRequest
     */
    void handle(UserRequest userRequest);
}
