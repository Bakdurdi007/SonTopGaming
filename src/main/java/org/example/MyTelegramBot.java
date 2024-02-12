package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Random;

public class MyTelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public String getBotToken() {
        return "";
    }

    Random random = new Random();
    int Number = random.nextInt(10) + 1;  // 1 dan 10 gacha.


    @Override
    public void onUpdateReceived(Update update) {
        String Message = update.getMessage().getText();
        long UserChatId = update.getMessage().getChatId();

        System.out.println(" >>> " + Number);
        String Natija = "";

        if (Number == Integer.parseInt(Message)) {
            Natija = " Siz men o'ylagan sonni topdingiz! \n Men Yana yangi son o'yladim uni ham topib ko'ringchi! ";
            Number = random.nextInt(10) + 1;  // 1 dan 10 gacha.
        } else if (Number > Integer.parseInt(Message)) {
            Natija = " Kattaroq son kiriting! ";
        } else if (Number < Integer.parseInt(Message)) {
            Natija = " Kichikroq son kiriting ";
        }

        SendMessage sendMessage = new SendMessage();

        sendMessage.setText(Natija);
        sendMessage.setChatId(String.valueOf(UserChatId));

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
