package com.app;


import com.app.model.TransactionModel;

/**
 * The interface Bancs.
 */
public interface IBancs {
    void parse_1(TransactionModel transactionModel);
    void parse_2(TransactionModel transactionModel);
    void parse_3(TransactionModel transactionModel);
    void build_1(TransactionModel transactionModel);
    void build_2(TransactionModel transactionModel);
    void build_3(TransactionModel transactionModel);
    void build_4(TransactionModel transactionModel);
    void addNumberIdentification(String numberIdentification);
    String createTrx(TransactionModel transactionModel);
    String operationTrx(TransactionModel transactionModel);
    TransactionModel readTrx(String transaction);
}
