package com.github.SayonaraF.telegrambot.bot;

import com.github.SayonaraF.telegrambot.command.CommandContainer;
import com.github.SayonaraF.telegrambot.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Locale;

import static com.github.SayonaraF.telegrambot.command.CommandName.NO;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    public TelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().toLowerCase(Locale.ROOT).trim();
            if (message.startsWith(COMMAND_PREFIX)) {

                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);

            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }

        }
    }
}
