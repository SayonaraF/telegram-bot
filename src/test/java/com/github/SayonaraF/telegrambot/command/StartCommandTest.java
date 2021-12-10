package com.github.SayonaraF.telegrambot.command;

import static com.github.SayonaraF.telegrambot.command.CommandName.START;
import static com.github.SayonaraF.telegrambot.command.StartCommand.START_MESSAGE;

public class StartCommandTest extends AbstructCommandTest {
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
