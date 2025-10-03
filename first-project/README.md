# Spring AI First Project

A simple Spring Boot application demonstrating basic Spring AI integration with OpenAI's GPT models.

## Overview

This project showcases the fundamental capabilities of Spring AI by providing a REST API endpoint that accepts questions and returns AI-generated responses using OpenAI's language models.

## Features

- **Simple AI Chat Interface**: REST API endpoint that accepts questions and returns AI responses
- **OpenAI Integration**: Uses Spring AI's OpenAI starter for seamless integration
- **Spring Boot 3.5.6**: Built with the latest Spring Boot framework
- **Java 17**: Uses modern Java features

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- OpenAI API key

## Setup

1. **Clone the repository** (if not already done):
   ```bash
   cd /Users/kevinprince/Documents/Software/Spring AI/first-project
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

The application will start on `http://localhost:8080`

## Usage

### API Endpoint

**GET** `/api`

Ask questions to the AI model by sending a GET request with a query parameter.

**Parameters:**
- `q` (required): Your question or prompt for the AI

**Example:**
```bash
curl "http://localhost:8080/api?q=What%20is%20Spring%20AI?"
```

**Response:**
```json
"Spring AI is a framework that provides abstractions for integrating AI capabilities into Spring applications..."
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/spring/ai/dummyproject/
│   │       ├── controller/
│   │       │   └── AIController.java    # REST controller handling AI requests
│   │       └── FirstProjectApplication.java  # Main Spring Boot application
│   └── resources/
│       └── application.properties       # Configuration file
└── test/
    └── java/
        └── com/spring/ai/dummyproject/
            └── FirstProjectApplicationTests.java
```

## Key Components

### AIController
- REST controller that handles HTTP requests
- Uses Spring AI's `ChatClient` to interact with OpenAI
- Provides a simple question-answer interface

### Configuration
- Uses `application.properties` for basic configuration
- Requires `SPRING_AI_OPENAI_API_KEY` environment variable

## Dependencies

- **Spring Boot Starter Web**: Provides REST API capabilities
- **Spring AI OpenAI Starter**: Integrates with OpenAI's GPT models
- **Spring Boot Starter Test**: Testing framework

## Environment Variables

| Variable | Description | Required |
|----------|-------------|----------|
| `SPRING_AI_OPENAI_API_KEY` | Your OpenAI API key | Yes |

## Troubleshooting

1. **API Key Issues**: Ensure your OpenAI API key is correctly set in the environment variable
2. **Port Conflicts**: The application runs on port 8080 by default
3. **Network Issues**: Ensure you have internet connectivity for OpenAI API calls

## Next Steps

This project serves as a foundation for more complex AI integrations. You can extend it by:
- Adding more sophisticated prompt engineering
- Implementing conversation history
- Adding user authentication
- Integrating with databases for persistent storage

## License

This project is for educational purposes and demonstrates Spring AI capabilities.

