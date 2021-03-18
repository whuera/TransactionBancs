package com.app.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class TransactionModel {
    public String txn_code;
    public Double amt;
    public Double fee_amt;
    public String txn_code_response;
    public String numberIdentificationUserCard;
}
