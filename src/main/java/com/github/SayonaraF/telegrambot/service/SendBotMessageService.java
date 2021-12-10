package com.github.SayonaraF.telegrambot.service;

public interface SendBotMessageService {

    void sendMessage(String chatID, String message);
}
