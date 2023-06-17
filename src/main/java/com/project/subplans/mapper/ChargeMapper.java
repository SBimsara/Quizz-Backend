package com.project.subplans.mapper;

import com.project.subplans.dto.ChargeRequestDTO;
import com.project.subplans.dto.ChargeResponseDTO;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChargeMapper {

    @Autowired
    private ChargeResponseDTO chargeResponseDTO;

    public ChargeResponseDTO toChargeResponse(Charge charge) {
//        Charge charge = new Charge();
        chargeResponseDTO.setStatus(charge.getStatus());
        chargeResponseDTO.setId(charge.getId());
        chargeResponseDTO.setTransactionId(chargeResponseDTO.getTransactionId());

        return chargeResponseDTO;
    }
}
