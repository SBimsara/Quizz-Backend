package com.project.subplans.dto;


import lombok.*;

import java.util.Currency;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ChargeRequestDTO {
    private String description;
    private long amount;
    private String currency;
    private String stripeToken;
}
