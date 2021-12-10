package com.github.SayonaraF.telegrambot.command;

import com.github.SayonaraF.telegrambot.bot.TelegramBot;
import com.github.SayonaraF.telegrambot.service.SendBotMessageService;
import com.github.SayonaraF.telegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstructCommandTest {
    protected TelegramBot telegramBot = Mockito.mock(TelegramBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(telegramBot);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        Long chatID = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatID);
        Mockito.when(message.getText()).thenReturn(getCommandMessage());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(telegramBot).execute(sendMessage);
    }
}
