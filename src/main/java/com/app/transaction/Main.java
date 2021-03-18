package com.app.transaction;

import com.app.model.TransactionModel;

public class Main {

    public static void main(String[] args) {
        TransactionBancs transactionBancs = new TransactionBancs();
        TransactionModel transactionRequest = transactionBancs.readTrx("A1000010001712462224");
        transactionBancs.operationTrx(transactionRequest);
    }
}
