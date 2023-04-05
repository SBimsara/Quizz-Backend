package com.project.subplans.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisteredUserCountDTO {

    private Date date;
    private int count;
}
