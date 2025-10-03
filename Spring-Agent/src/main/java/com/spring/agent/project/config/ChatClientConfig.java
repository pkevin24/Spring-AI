package com.spring.agent.project.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Autowired
    private ChatModel chatModel;

    @Bean
    public ChatClient.Builder chatClientBuilder() {
        return ChatClient.builder(chatModel);
    }
}
