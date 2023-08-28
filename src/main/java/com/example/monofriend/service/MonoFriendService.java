package com.example.monofriend.service;

import com.example.monofriend.model.UserRequest;
import com.example.monofriend.sender.MonoFriendTelegramBotSender;
import com.example.monofriend.utils.MessageBundleKeys;
import com.example.monofriend.utils.MonoMessageProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@AllArgsConstructor
@Service
@Slf4j
public class MonoFriendService {
    private final MonoMessageProvider monoMessageProvider;
    private final MonoFriendTelegramBotSender monoFriendTelegramBotSender;

    public void sendWelcomeMessage(UserRequest userRequest) {
        String userName = userRequest.getUpdate().getMessage().getChat().getFirstName();
        String welcomeText = monoMessageProvider.getMessage(MessageBundleKeys.WELCOME_MESSAGE_KEY,
                userName);
        SendMessage generatedMessage = new SendMessage();
        generatedMessage.setChatId(String.valueOf(userRequest.getChatId()));
        generatedMessage.setText(welcomeText);
        try {
            monoFriendTelegramBotSender.execute(generatedMessage);
        } catch (TelegramApiException e) {
            log.error("something wrong with sending welcome message");
        }
    }

    public boolean checkCommandExists(Message message, String commandName) {
        if (!message.getText().equals(commandName)) {
            log.error("No command or message found");
            return false;
        }
        return true;
    }
}
