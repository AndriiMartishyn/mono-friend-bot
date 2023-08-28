package com.example.monofriend.utils;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
@AllArgsConstructor
public class MonoMessageProvider {
    private final MessageSource messageSource;

    public String getMessage(String key, String ... args) {
        return messageSource.getMessage(key, args, Locale.US);
    }
}
