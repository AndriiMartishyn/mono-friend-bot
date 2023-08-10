package com.example.monofriend.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
public class MonoFriendBotConfig {
    @Value("${telegram.bot.name}")
    private String monoFriendBotName;
    @Value("${telegram.bot.token}")
    private String monoFriendBotToken;
}
