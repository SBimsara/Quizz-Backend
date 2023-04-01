package com.project.subplans.dto;

public class PlanCountDTO {

    private String planName;
    private Long count;

    public PlanCountDTO(String planName, Long count) {
        this.planName = planName;
        this.count = count;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
