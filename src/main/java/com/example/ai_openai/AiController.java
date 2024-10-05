package com.example.ai_openai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
//create your own key from chat-gpt and then never expose the key to outer world.
@RestController
public class AiController {
    private final ChatClient chatClient;

    public AiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ai")
    Map<String, String> completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of(
                "completion",
                chatClient.prompt()
                        .user(message)
                        .call()
                        .content());
    }
}
