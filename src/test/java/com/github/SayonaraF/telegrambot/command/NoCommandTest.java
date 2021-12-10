package com.github.SayonaraF.telegrambot.command;

import static com.github.SayonaraF.telegrambot.command.CommandName.NO;
import static com.github.SayonaraF.telegrambot.command.NoCommand.NO_MESSAGE;

public class NoCommandTest extends AbstructCommandTest {
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
