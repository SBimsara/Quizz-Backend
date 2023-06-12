package com.project.subplans.util;

public class StatusList {

    public static final String RSP_SUCCESS              ="00";
    public static final String RSP_NO_DATA_FOUND        ="01";
    public static final String RSP_NOT_AUTHORISED       ="02";
    public static final String RSP_TOKEN_EXPIRED        ="03";
    public static final String RSP_TOKEN_INVALID        ="04";
    public static final String RSP_ERROR                ="05";
    public static final String RSP_DUPLICATED           ="06";
    public static final String RSP_FAIL                 ="10";

    // Existing status codes
    public static final String RSP_DUPLICATED_EMAIL = "duplicated_email";
    public static final String RSP_DUPLICATED_USERNAME = "duplicated_username";
    public static final String RSP_DUPLICATED_CONTACT_NUMBER = "duplicated_contact_number";
    // New status code for duplicated NIC
    public static final String RSP_DUPLICATED_NIC = "duplicated_nic";
}
