package com.example.monofriend.config;

import com.example.monofriend.bot.MonoFriendTelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Slf4j
@Component
public class MonoFriendBotInitializer {
    private final MonoFriendTelegramBot monoFriendTelegramBot;

    public MonoFriendBotInitializer(MonoFriendTelegramBot monoFriendTelegramBot) {
        this.monoFriendTelegramBot = monoFriendTelegramBot;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void createMonoBot() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(monoFriendTelegramBot);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }
}
