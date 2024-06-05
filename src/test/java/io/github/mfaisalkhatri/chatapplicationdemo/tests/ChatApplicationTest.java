package io.github.mfaisalkhatri.chatapplicationdemo.tests;

import io.github.mfaisalkhatri.chatapplicationdemo.pages.ChatPage;
import io.github.mfaisalkhatri.chatapplicationdemo.pages.LoginPage;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ChatApplicationTest extends BaseTest {


    @Test
    public void testUserChatting() {

        String channelName = "general";
        LoginPage loginUserOne = new LoginPage(firstUserDriver);
        LoginPage loginUserTwo = new LoginPage(secondUserDriver);

        String[] chatMessagesUserOne = {"Hi, This is Faisal here", "How are you?", "I am fine!", "Bye!"};
        String[] chatMessagesUserTwo = {"Hi, This is Wasiq here", "I am good, What about you?", "Good Bye!", "Thanks"};

        ChatPage chatUserOne = loginUserOne.loginToChat(channelName, "faisal");
        ChatPage chatUserTwo = loginUserTwo.loginToChat(channelName, "wasiq");

        for (int i = 0; i < chatMessagesUserOne.length; i++) {
            chatUserOne.sendMessage(chatMessagesUserOne[i]);
            chatUserTwo.sendMessage(chatMessagesUserTwo[i]);
        }
        
        assertEquals(chatUserOne.getLastChatMessage(), chatMessagesUserOne[3]);
        assertEquals(chatUserTwo.getLastChatMessage(), chatMessagesUserTwo[3]);

        System.out.println("Chat Logs \n" + chatUserOne.getChatLog());
    }
}