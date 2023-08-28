package com.example.monofriend.sender;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Component
public class MonoFriendTelegramBotSender extends DefaultAbsSender {
    @Value("${telegram.bot.token}")
    private String botToken;

    protected MonoFriendTelegramBotSender() {
        super(new DefaultBotOptions());
    }
    @Override
    public String getBotToken() {
        return botToken;
    }
}
