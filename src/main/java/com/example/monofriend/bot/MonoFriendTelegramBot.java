package com.example.monofriend.bot;

import com.example.monofriend.config.MonoFriendBotConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@AllArgsConstructor
public class MonoFriendTelegramBot extends TelegramLongPollingBot {
    private final MonoFriendBotConfig monoFriendBotConfig;

    @Override
    public String getBotToken() {
        return monoFriendBotConfig.getMonoFriendBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
    }

    @Override
    public String getBotUsername() {
        return monoFriendBotConfig.getMonoFriendBotName();
    }
}
