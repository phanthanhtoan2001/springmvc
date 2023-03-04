package com.laptrinhjavaweb.controller.User.mservice.models;

import com.laptrinhjavaweb.controller.User.mservice.enums.ConfirmRequestType;

public class ConfirmResponse extends Response {
    private Long amount;
    private Long transId;
    private String requestId;
    private ConfirmRequestType requestType;
}
