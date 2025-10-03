package com.spring.agent.project.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class WeatherTool {
	
	@Tool(description = "Get the weather for a city")
	public String getWeather(String city) {
		return "Its 28 degree celcius in "+city;
	}

}
