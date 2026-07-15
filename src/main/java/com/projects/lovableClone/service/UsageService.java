package com.projects.lovableClone.service;

import com.projects.lovableClone.dto.subscription.PlanLimitsResponse;
import com.projects.lovableClone.dto.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {
    UsageTodayResponse getTodayUsage(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitOfUser(Long userId);
}
