package com.projects.lovableClone.service;

import com.projects.lovableClone.dto.subscription.CheckoutRequest;
import com.projects.lovableClone.dto.subscription.CheckoutResponse;
import com.projects.lovableClone.dto.subscription.PortalResponse;
import com.projects.lovableClone.dto.subscription.SubscriptionResponse;
import org.jspecify.annotations.Nullable;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
