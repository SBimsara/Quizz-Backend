package com.project.subplans.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class ChargeResponseDTO {

    public String status;
    public String id;
    public String transactionId;
}
