package org.savegpt.modules.Runner;

import com.plexpt.chatgpt.ChatGPT;
import okhttp3.OkHttpClient;

public class GPTConnection {


    private final com.plexpt.chatgpt.ChatGPT chatGPT;


    public GPTConnection(String bearerToken){
        this.chatGPT = ChatGPT.builder().apiKey(bearerToken).build().init();
    }


    public String authenticateRequest(String prompt){
        return this.chatGPT.init().chat(prompt);
    }




}
