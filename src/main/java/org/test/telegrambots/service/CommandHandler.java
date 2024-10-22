package org.test.telegrambots.service;

import org.test.telegrambots.command.BotCommand;
import org.test.telegrambots.command.ViewTreeCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandHandler {
    private final Map<String, BotCommand> commands = new HashMap<>();

    public CommandHandler(ViewTreeCommand viewTreeCommand) {
        commands.put("/viewTree", viewTreeCommand);
    }

    public void handleCommand(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String command = update.getMessage().getText().split(" ")[0];
            BotCommand botCommand = commands.get(command);
            if (botCommand != null) {
                botCommand.execute(update);
            }else {

            }
        }
    }
}
