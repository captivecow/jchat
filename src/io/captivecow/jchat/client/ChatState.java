package io.captivecow.jchat.client;

public enum ChatState implements State {
    LOGIN {
        @Override
        public void update(JChatView jChatView) {
            System.out.println("Update login state");
        }
    },
    CONNECTING {
        @Override
        public void update(JChatView jChatView) {
            System.out.println("Update view to connecting state.");
            jChatView.setConnectingView();
        }
    }
}
