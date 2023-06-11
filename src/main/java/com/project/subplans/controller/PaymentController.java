package com.project.subplans.controller;


import com.project.subplans.dto.ChargeRequestDTO;
import com.project.subplans.dto.ChargeResponseDTO;
import com.project.subplans.mapper.ChargeMapper;
import com.project.subplans.service.PaymentService;
import com.project.subplans.util.StatusList;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/payment")
@CrossOrigin(origins="http://192.168.1.4:19000")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private final ChargeMapper chargeMapper;


    @PostMapping(value = "/charge")
    public ChargeResponseDTO charge(@RequestBody ChargeRequestDTO chargeRequestDTO) throws StripeException {
        Charge charge = paymentService.charge(chargeRequestDTO);
        return chargeMapper.toChargeResponse(charge);
    }



}
