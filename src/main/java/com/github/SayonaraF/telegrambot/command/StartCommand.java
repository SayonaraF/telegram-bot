package com.github.SayonaraF.telegrambot.command;

import com.github.SayonaraF.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {

    private SendBotMessageService sendBotMessageService;

    public static final String START_MESSAGE = "Привет, я Telegram Bot. Я помогу тебе быть в курсе последних статей авторов," +
            "которые тебе интересны. Я еще маленький и мало что умею.";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
