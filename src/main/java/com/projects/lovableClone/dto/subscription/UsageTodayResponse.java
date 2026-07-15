package com.projects.lovableClone.dto.subscription;

public record UsageTodayResponse(
        Integer tokensUsed,
        Integer tokensList, //comes form plan
        Integer previewsRunning,
        Integer previewsLimit //comes from plan user has
) {
}
