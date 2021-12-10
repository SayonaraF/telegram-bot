package com.github.SayonaraF.telegrambot.service;

import com.github.SayonaraF.telegrambot.bot.TelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private TelegramBot telegramBot;

    @BeforeEach
    public void init() {
        telegramBot = Mockito.mock(TelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(telegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatID = "test_char_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatID, message);

        Mockito.verify(telegramBot).execute(sendMessage);
    }
}
