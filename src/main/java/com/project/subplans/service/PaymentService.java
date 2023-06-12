package com.project.subplans.service;

import com.project.subplans.dto.ChargeRequestDTO;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import jakarta.annotation.PostConstruct;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
//    @Value("${stripe.secret.key}")
    private String stripeSecretKey="sk_test_51NHa3qSHQTfZ29uMx21oWuZHx3WP2bZ5mNjuWioXr1ShiGjeKCAypZ7KBvMdm87v6BAo65Jmda8YGzeVM07rNgkP00Iav4poZM";

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;
    }

    public String paymentProcess(ChargeRequestDTO chargeRequestDTO) throws StripeException {
//        Map chargeParams = new HashMap();

//        chargeParams.put("amount", chargeRequestDTO.getAmount());
//        chargeParams.put("currency", chargeRequestDTO.getCurrency());
//        chargeParams.put("description", chargeRequestDTO.getDescription());
//        chargeParams.put("source", chargeRequestDTO.getStripeToken());

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                        .setAmount(chargeRequestDTO.getAmount())
                        .setCurrency(chargeRequestDTO.getCurrency())
                        .build();

        PaymentIntent intent = PaymentIntent.create(params);
        String clientSecret = intent.getClientSecret();
        chargeRequestDTO.setStripeToken(clientSecret);


//        return Charge.create(chargeParams);
        return clientSecret;
    }
}