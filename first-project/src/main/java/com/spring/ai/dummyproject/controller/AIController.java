package com.spring.ai.dummyproject.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AIController {
	
	private ChatClient chatClient;
	
	AIController(ChatClient.Builder builder){
		chatClient = builder.build();
	}

	
	@GetMapping("")
	public ResponseEntity<?> getAnswer(@RequestParam("q") String question){
		var res = chatClient.prompt(question).call().content();
		return ResponseEntity.ok(res);
	}
}
