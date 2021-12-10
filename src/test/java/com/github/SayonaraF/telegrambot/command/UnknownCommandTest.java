package com.github.SayonaraF.telegrambot.command;

import static com.github.SayonaraF.telegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;

public class UnknownCommandTest extends AbstructCommandTest {
    @Override
    String getCommandName() {
        return "/sadsaf";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
