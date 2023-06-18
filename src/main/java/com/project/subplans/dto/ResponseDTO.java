package com.project.subplans.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {

    private String code;
    private String message;
    private Object content;

}
