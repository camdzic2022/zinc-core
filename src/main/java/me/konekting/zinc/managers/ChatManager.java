package me.konekting.zinc.managers;

public class ChatManager {

    private boolean chatMuted = false;
    public boolean isChatMuted(){
        return chatMuted;
    }
    public void setChatMuted(boolean chatMuted){
        this.chatMuted = chatMuted;
    }

}
