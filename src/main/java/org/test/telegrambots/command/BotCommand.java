package org.test.telegrambots.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotCommand {
    String execute(Update update);
}
