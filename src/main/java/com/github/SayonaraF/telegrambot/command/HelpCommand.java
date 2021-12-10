package com.github.SayonaraF.telegrambot.command;

import com.github.SayonaraF.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.SayonaraF.telegrambot.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("<b>Доступные команды:</b>\n\n"
                + "Начать\\Закончить работу с ботом:\n"
                + "%s - начать работу со мной\n"
                + "%s - приостановить работу со мной\n\n"
                + "%s - получить помощь в работе со мной\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
