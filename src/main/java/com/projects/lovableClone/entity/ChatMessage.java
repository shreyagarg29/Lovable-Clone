package com.projects.lovableClone.entity;

import com.projects.lovableClone.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;
    ChatSession chatSession;

    String content;
    MessageRole messageRole;
    String totalCalls; // JSON Array of tools called

    Integer tokensUsed;

    Instant createdAt;
}
