package org.test.telegrambots.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.test.telegrambots.command.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandHandler {
    private final Map<String, BotCommand> commands = new HashMap<>();


    public CommandHandler(ViewTreeCommand viewTreeCommand, HelpCommand helpCommand, AddChildrenElementCommand addChildrenElementCommand, AddElementCommand addElementCommand, RemoveElementCommand removeElementCommand, TestCommand testCommand) {
        commands.put("/viewTree", viewTreeCommand);
        commands.put("/help", helpCommand);
        commands.put("/addChildrenElement", addChildrenElementCommand);
        commands.put("/addElement", addElementCommand);
        commands.put("/removeElement", removeElementCommand);
        commands.put("/test", testCommand);
    }

    public void handleCommand(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String command = update.getMessage().getText().split(" ")[0];
            BotCommand botCommand = commands.get(command);
            if (botCommand != null) {
                botCommand.execute(update);
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
