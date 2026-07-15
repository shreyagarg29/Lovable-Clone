package com.projects.lovableClone.service.impl;

import com.projects.lovableClone.dto.subscription.PlanResponse;
import com.projects.lovableClone.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
