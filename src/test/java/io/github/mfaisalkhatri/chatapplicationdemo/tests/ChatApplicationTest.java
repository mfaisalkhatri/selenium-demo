package io.github.mfaisalkhatri.chatapplicationdemo.tests;

import io.github.mfaisalkhatri.chatapplicationdemo.pages.ChatPage;
import io.github.mfaisalkhatri.chatapplicationdemo.pages.LoginPage;
import org.testng.annotations.Test;

public class ChatApplicationTest extends BaseTest {


    @Test
    public void testUserChatting() {
        String channelName = "general";
        LoginPage loginUserOne = new LoginPage(firstUserDriver);
        LoginPage loginUserTwo = new LoginPage(secondUserDriver);

        String[] chatMessagesUserOne = new String[]{"Hi, This is faisal here", "How are you?", "I am fine! Where are you from?", "I am from Mumbai as well, nice to meet you!"};
        String[] chatMessagesUserTwo = new String[]{"Hi, This is wasiq here", "I am good, What about you?", "Mumbai and you?", "Same here!!"};

        ChatPage chatUserOne = loginUserOne.loginToChat(channelName, "faisal");
        ChatPage chatUserTwo = loginUserTwo.loginToChat(channelName, "wasiq");

        for (int i = 0; i < chatMessagesUserOne.length; i++) {
            chatUserOne.sendMessage(chatMessagesUserOne[i]);
            chatUserTwo.sendMessage(chatMessagesUserTwo[i]);
        }
        
        System.out.println("Chat Logs" + chatUserOne.getChatLog());


    }
}
