package com.spring.agent.project.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class WeatherAgent {
	
	private ChatClient chatClient;
	
	WeatherAgent(ChatClient.Builder builder){
		chatClient = builder.build();
	}
	
	public String getWeatherResponse(String city) {
		return chatClient.prompt()
				.user("You are helpful Weather Agent. Provide current wather info for "+city)
				.call()
				.content();
	}

}
