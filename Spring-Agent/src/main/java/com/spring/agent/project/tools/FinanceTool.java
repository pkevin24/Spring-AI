package com.spring.agent.project.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class FinanceTool {
	
	@Tool(description="Get stock price for a company")
	public String getStockPrice(String symbol) {
		//Use third party API to get info on Stocks
		return "Price of "+symbol+" is $10";
	}

}
