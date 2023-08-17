package io.captivecow.jchat.client;

import javax.swing.SwingUtilities;

public class ChatController {

    private JChatView jChatview;
    private ChatModel chatModel;

    public ChatController(){
        jChatview = new JChatView(this);
        chatModel = new ChatModel(jChatview);
        SwingUtilities.invokeLater(jChatview);
    }

    public void connect(){
        System.out.println("Connect pressed, sent to controller.");
        chatModel.changeState(ChatState.CONNECTING);
    }
}
