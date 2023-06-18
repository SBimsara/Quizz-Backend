
package com.project.subplans.service;

import com.project.subplans.dto.PaymentRequestDTO;
import com.project.subplans.dto.PaymentResponseDTO;
import com.project.subplans.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class PaymentService {
    private final StripeService stripeService;

    public PaymentService(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    public PaymentResponseDTO initiatePayment(PaymentRequestDTO PaymentRequestDTO) {
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        try {
            long amount = PaymentRequestDTO.getAmount();
            if (amount==0 || isNull(amount)) {
                responseDTO.setMessage("Please enter a amount");
                return responseDTO;
            }
            PaymentIntent paymentIntent = stripeService.createPaymentIntent(amount);
            responseDTO.setMessage("Payment initiated");
            responseDTO.setClientSecret(paymentIntent.getClientSecret());
        } catch (StripeException e) {
            e.printStackTrace();
            responseDTO.setMessage("Internal server error");
        }
        return responseDTO;
    }
}
