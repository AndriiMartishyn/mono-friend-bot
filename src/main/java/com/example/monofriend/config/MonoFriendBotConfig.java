package com.example.monofriend.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class MonoFriendBotConfig {
    @Value("${telegram.bot.name}")
    private String monoFriendBotName;
    @Value("${telegram.bot.token}")
    private String monoFriendBotToken;
}
