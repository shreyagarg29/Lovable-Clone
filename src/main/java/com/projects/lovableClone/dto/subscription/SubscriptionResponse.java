package com.projects.lovableClone.dto.subscription;

import java.time.Instant;

public record SubscriptionResponse(
        PlanResponse plan,
        String status, // check if enum also works
        Instant periodEnd,
        Long tokensUsedThisCycle
) {
}
