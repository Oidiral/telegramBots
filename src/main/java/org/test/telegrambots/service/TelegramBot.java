package org.test.telegrambots.service;

import org.test.telegrambots.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;
    final CommandHandler commandHandler;

    public TelegramBot(BotConfig config, CommandHandler commandHandler) {
        super(config.getToken());
        this.config = config;
        this.commandHandler = commandHandler;
    }


    @Override
    public void onUpdateReceived(Update update) {
        commandHandler.handleCommand(update);
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }
}
