package com.github.SayonaraF.telegrambot.command;

import static com.github.SayonaraF.telegrambot.command.CommandName.HELP;
import static com.github.SayonaraF.telegrambot.command.HelpCommand.HELP_MESSAGE;

public class HelpCommandTest extends AbstructCommandTest {
    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
