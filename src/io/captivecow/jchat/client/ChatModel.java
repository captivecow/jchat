package io.captivecow.jchat.client;

public class ChatModel {

    private ChatState chatState;
    private final ModelObserver observer;

    public ChatModel(ModelObserver observer){
        chatState = ChatState.LOGIN;
        this.observer = observer;
    }

    public void changeState(ChatState chatState){
        if(this.chatState != chatState){
            System.out.println("State has changed to: " + chatState);
            this.chatState = chatState;
            notifyStateObserver();
        }
    }

    public void notifyStateObserver(){
        observer.updateState(this.chatState);
    }
}
