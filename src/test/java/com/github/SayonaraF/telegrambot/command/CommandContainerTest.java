package com.github.SayonaraF.telegrambot.command;

import com.github.SayonaraF.telegrambot.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {

    private CommandContainer container;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        container = new CommandContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = container.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        String unknownCommand = "/sadsffQW";
        Command command = container.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
