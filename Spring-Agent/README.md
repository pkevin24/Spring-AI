# Spring Agent Project

A Spring Boot application demonstrating AI agents with custom tools using Spring AI framework. This project showcases how to build intelligent agents that can use specific tools to perform tasks like checking weather and getting stock prices.

## Overview

This project implements an AI agent system that can:
- Answer questions using OpenAI's language models
- Use custom tools to perform specific tasks
- Provide weather information for any city
- Retrieve stock prices for companies
- Combine AI reasoning with tool execution

## Features

- **AI Agent with Tools**: Intelligent agent that can use custom tools to answer questions
- **Weather Tool**: Get weather information for any city
- **Finance Tool**: Retrieve stock prices for companies
- **REST API Interface**: Simple HTTP endpoint to interact with the agent
- **Spring AI Integration**: Built on Spring AI framework with OpenAI models
- **Custom Port**: Runs on port 8082 to avoid conflicts

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- OpenAI API key

## Setup

1. **Navigate to the project directory**:
   ```bash
   cd /Users/kevinprince/Documents/Software/Spring AI/Spring-Agent
   ```

2. **Set up your OpenAI API key**:
   ```bash
   export SPRING_AI_OPENAI_API_KEY="your-openai-api-key-here"
   ```

3. **Build the project**:
   ```bash
   ./mvnw clean install
   ```

4. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8082`

## Usage

### API Endpoint

**GET** `/agent/ask`

Send questions to the AI agent, which can use available tools to provide comprehensive answers.

**Parameters:**
- `q` (required): Your question or request for the agent

**Example Requests:**

1. **Weather Query**:
   ```bash
   curl "http://localhost:8082/agent/ask?q=What%20is%20the%20weather%20in%20New%20York?"
   ```

2. **Stock Price Query**:
   ```bash
   curl "http://localhost:8082/agent/ask?q=What%20is%20the%20stock%20price%20of%20AAPL?"
   ```

3. **Combined Query**:
   ```bash
   curl "http://localhost:8082/agent/ask?q=Tell%20me%20about%20the%20weather%20in%20London%20and%20the%20stock%20price%20of%20TSLA"
   ```

**Response Example:**
```json
"The weather in New York is 28 degrees Celsius. The stock price of AAPL is $10."
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/spring/agent/project/
│   │       ├── config/
│   │       │   └── ChatClientConfig.java     # Chat client configuration
│   │       ├── controler/
│   │       │   └── AgentController.java      # REST controller for agent requests
│   │       ├── service/
│   │       │   ├── AgentService.java         # Main agent service logic
│   │       │   └── WeatherAgent.java         # Weather-specific agent
│   │       ├── tools/
│   │       │   ├── WeatherTool.java          # Tool for weather information
│   │       │   └── FinanceTool.java          # Tool for stock prices
│   │       └── SpringAgentApplication.java   # Main Spring Boot application
│   └── resources/
│       └── application.properties            # Configuration file
└── test/
    └── java/
        └── com/spring/agent/project/
            └── SpringAgentApplicationTests.java
```

## Key Components

### AgentService
- Main service that orchestrates the AI agent
- Integrates ChatClient with custom tools
- Handles user queries and tool execution

### WeatherTool
- Provides weather information for any city
- Currently returns mock data (28°C for any city)
- Can be extended to integrate with real weather APIs

### FinanceTool
- Retrieves stock prices for companies
- Currently returns mock data ($10 for any symbol)
- Can be extended to integrate with financial APIs

### AgentController
- REST controller handling agent requests
- Provides error handling for tool execution failures
- Returns structured responses

## Available Tools

### Weather Tool
- **Function**: `getWeather(String city)`
- **Description**: Get weather information for a specific city
- **Usage**: Agent automatically calls this tool when weather-related questions are asked

### Finance Tool
- **Function**: `getStockPrice(String symbol)`
- **Description**: Get stock price for a company symbol
- **Usage**: Agent automatically calls this tool when stock-related questions are asked

## Configuration

### Application Properties
- **Application Name**: Spring-Agent
- **Server Port**: 8082
- **OpenAI API Key**: Required via environment variable

### Environment Variables

| Variable | Description | Required |
|----------|-------------|----------|
| `SPRING_AI_OPENAI_API_KEY` | Your OpenAI API key | Yes |

## Dependencies

- **Spring Boot Starter Web**: REST API capabilities
- **Spring AI OpenAI Starter**: OpenAI model integration
- **LangGraph4j Spring AI Agent Executor**: Advanced agent execution capabilities
- **Spring Boot Starter Test**: Testing framework

## How It Works

1. **User sends a question** via the `/agent/ask` endpoint
2. **AgentService receives the query** and passes it to the ChatClient
3. **AI model analyzes the question** and determines if tools are needed
4. **Tools are executed** if the AI determines they're necessary
5. **AI combines tool results** with its knowledge to provide a comprehensive answer
6. **Response is returned** to the user

## Extending the Agent

### Adding New Tools

1. Create a new tool class with `@Component` annotation
2. Add methods with `@Tool` annotation
3. Register the tool in `AgentService` constructor
4. The AI will automatically learn to use the new tool

Example:
```java
@Component
public class NewsTool {
    @Tool(description = "Get latest news for a topic")
    public String getNews(String topic) {
        return "Latest news about " + topic + "...";
    }
}
```

### Integrating Real APIs

Replace mock implementations in tools with actual API calls:

```java
@Tool(description = "Get the weather for a city")
public String getWeather(String city) {
    // Call real weather API (OpenWeatherMap, etc.)
    return weatherApiService.getCurrentWeather(city);
}
```

## Troubleshooting

1. **API Key Issues**: Ensure your OpenAI API key is correctly set
2. **Port Conflicts**: Application runs on port 8082 by default
3. **Tool Execution Errors**: Check the error response for specific tool failures
4. **Network Issues**: Ensure internet connectivity for OpenAI API calls

## Example Interactions

- "What's the weather in Paris?" → Uses WeatherTool
- "What's the stock price of GOOGL?" → Uses FinanceTool
- "How are you doing?" → Direct AI response without tools
- "What's the weather in Tokyo and the price of MSFT?" → Uses both tools

## Future Enhancements

- Integrate with real weather APIs (OpenWeatherMap)
- Connect to financial data providers (Alpha Vantage, Yahoo Finance)
- Add more tools (news, calendar, calculator)
- Implement conversation memory
- Add user authentication and personalization
- Create a web UI for better interaction

## License

This project is for educational purposes and demonstrates Spring AI agent capabilities with custom tools.

