# Spring-AI Project

The Spring-AI project leverages Spring Boot and Spring AI to create a RESTful service that summarizes articles. It uses the OpenAI API to generate concise summaries of articles provided by the user.

## Overview

This project contains a Spring Boot application that defines an endpoint to receive article titles and URIs. It then communicates with the OpenAI service to generate a summary of the article, aiming to capture the essential points and main conclusions in a concise manner.

## Components

- `ArticleSummaryController`: A REST controller that handles POST requests to the `/summary` endpoint, accepting an `Article` object and returning a `Summary` object.
- `Article`: A data record that represents an article with a title and URI.
- `Summary`: A data record that encapsulates the article title, URI, and its generated summary.
- `SummaryService`: A service that communicates with the OpenAI API to generate summaries based on a provided prompt.

## Configuration

The application requires the following configurations in `application.yaml`:

```yaml
spring:
  application:
    name: springAI
  docker:
    compose:
      lifecycle-management: start_only
  ai:
    openai:
      api-key: ${SPRING_AI_OPENAI_API_KEY}  # Replace with your actual OpenAI API key
```

# TODO
## Enhancement for Spring-AI Project: Database Integration for Article Summaries

## Overview

Integrate database functionality into the Spring-AI project to store and retrieve article summaries. This enhancement will reduce redundant calls to the AI service by checking the database for existing summaries before generating new ones.

## Objectives

- Enable the application to store article titles, URIs, and summaries in a database.
- Before generating a new summary, check if the article's summary already exists in the database.
- If a summary exists, fetch and return it; if not, generate a new summary, store it, and then return it.

## Tasks

1. **Database Setup**
    - Initialize a PostgreSQL database.
    - Configure database connection properties in `application.yaml`.

2. **Entity Creation**
    - Define an `ArticleSummary` entity with fields for title, URI, and summary.

3. **Repository Layer**
    - Create an `ArticleSummaryRepository` to facilitate data access and manipulation.

4. **Service Layer Enhancement**
    - Update `SummaryService` to incorporate database checks and data persistence logic.

5. **Controller Adjustments**
    - Ensure the controller interacts correctly with the enhanced service layer.

6. **Testing**
    - Write unit and integration tests to cover the new functionality.

## Expected Outcome

The application should efficiently check for existing summaries in the database and avoid unnecessary AI service calls, thereby enhancing performance and reducing API usage.

## Priority

- Set the priority based on your project's current needs and roadmap.

## Notes

- Ensure proper error handling and validation throughout the new implementation.
- Document the changes and update any relevant API documentation.
