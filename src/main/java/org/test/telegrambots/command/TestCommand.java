package org.test.telegrambots.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TestCommand implements BotCommand {
    @Override
    public String execute(Update update) {
        return update.getMessage().getText();
    }
}
