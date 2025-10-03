package com.spring.agent.project.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.spring.agent.project.tools.FinanceTool;
import com.spring.agent.project.tools.WeatherTool;

@Service
public class AgentService {
    
    private final ChatClient chatClient;
    
    public AgentService(ChatClient.Builder chatClientBuilder, 
                        WeatherTool weatherTool, 
                        FinanceTool financeTool) {
        this.chatClient = chatClientBuilder
                .defaultTools(weatherTool, financeTool)
                .build();
    }
    
    public String execute(String userMessage) {
        return chatClient.prompt()
                .user(userMessage)
                .call()
                .content();
    }
}