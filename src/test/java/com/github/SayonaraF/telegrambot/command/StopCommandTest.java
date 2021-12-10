package com.github.SayonaraF.telegrambot.command;

import static com.github.SayonaraF.telegrambot.command.CommandName.STOP;
import static com.github.SayonaraF.telegrambot.command.StopCommand.STOP_MESSAGE;

public class StopCommandTest extends AbstructCommandTest {
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
