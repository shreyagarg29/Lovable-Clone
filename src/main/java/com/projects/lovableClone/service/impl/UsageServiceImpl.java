package com.projects.lovableClone.service.impl;

import com.projects.lovableClone.dto.subscription.PlanLimitsResponse;
import com.projects.lovableClone.dto.subscription.UsageTodayResponse;
import com.projects.lovableClone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsage(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitOfUser(Long userId) {
        return null;
    }
}
