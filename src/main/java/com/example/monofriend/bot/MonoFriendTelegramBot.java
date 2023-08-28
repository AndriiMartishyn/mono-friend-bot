package com.example.monofriend.bot;

import com.example.monofriend.config.MonoFriendBotConfig;
import com.example.monofriend.dispatcher.MonoBotDispatcher;
import com.example.monofriend.model.UserRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
@AllArgsConstructor
public class MonoFriendTelegramBot extends TelegramLongPollingBot {
    private final MonoFriendBotConfig monoFriendBotConfig;
    private final MonoBotDispatcher monoBotDispatcher;

    @Override
    public String getBotToken() {
        return monoFriendBotConfig.getMonoFriendBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var userRequest =
                    UserRequest.builder()
                            .update(update)
                            .chatId(update.getMessage().getChatId())
                            .build();
            monoBotDispatcher.dispatch(userRequest);
        }
    }

    @Override
    public String getBotUsername() {
        return monoFriendBotConfig.getMonoFriendBotName();
    }
}
