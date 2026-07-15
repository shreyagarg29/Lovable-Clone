package com.projects.lovableClone.controller;

import com.projects.lovableClone.dto.subscription.PlanLimitsResponse;
import com.projects.lovableClone.dto.subscription.UsageTodayResponse;
import com.projects.lovableClone.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
public class UsageController {

    private final UsageService usageService;

    //Get today's usage of tokens
    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getTodayUsage(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getTodayUsage(userId));
    }

    //get limits of current cycle
    public ResponseEntity<PlanLimitsResponse> getPlanLimits(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitOfUser(userId));
    }
}
