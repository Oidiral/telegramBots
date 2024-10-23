package org.test.telegrambots.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class HelpCommand implements BotCommand {
    @Override
    public String execute(Update update) {
        return "Available commands: help, echo <text>";
    }
}
