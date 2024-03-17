package com.hahu.springai.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {

    private final ChatClient chatClient;

    public SummaryService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getSummary(String text) {
        return chatClient.call(text);
    }
}
