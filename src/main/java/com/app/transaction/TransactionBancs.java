package com.app.transaction;


import com.app.IBancs;
import com.app.model.TransactionModel;
import lombok.Getter;
import lombok.Setter;


import java.text.MessageFormat;

@Getter @Setter
class TransactionBancs implements IBancs {
	private String txn_code;
	private Double amt;
	private Double fee_amt;
	private String numberIdentificationUserCard;
	private TransactionModel transactionResponse = new TransactionModel();

	@Override
	 public void parse_1(TransactionModel transactionModel) {
		transactionResponse.txn_code = transactionModel.txn_code;
	 }

	 @Override
	 public void parse_2(TransactionModel transactionModel) {
		 transactionResponse.amt = transactionModel.amt;
	 }

	 @Override
	 public void parse_3(TransactionModel transactionModel) {
		 transactionResponse.fee_amt = transactionModel.fee_amt;
	 }

	@Override
	public void build_1(TransactionModel transactionModel) {
		transactionResponse.txn_code = transactionModel.txn_code;
	}

	@Override
	public void build_2(TransactionModel transactionModel) {
		transactionResponse.amt = transactionModel.amt;
	}

	@Override
	public void build_3(TransactionModel transactionModel) {
		transactionResponse.fee_amt = transactionModel.fee_amt;
	}

	@Override
	public void build_4(TransactionModel transactionModel) {
		Double totalAmount = 0.0;
		if(transactionModel.txn_code.equalsIgnoreCase("B") && transactionModel.fee_amt > 0){
			transactionResponse.txn_code_response = "DENIED";
		}
		if(transactionModel.txn_code.equalsIgnoreCase("A")){
			totalAmount = (transactionModel.amt + transactionModel.fee_amt);
			transactionResponse.amt = totalAmount;
			transactionResponse.fee_amt = 0.0;
			transactionResponse.txn_code_response = "APPROVED";
		}
		transactionResponse.numberIdentificationUserCard = transactionModel.numberIdentificationUserCard;
	}

	@Override
	public void addNumberIdentification(String numberIdentification) {
		numberIdentificationUserCard = numberIdentification;
	}

	@Override
	public String createTrx(TransactionModel transactionModel) {
	 	System.out.println(MessageFormat.format("{0}{1}{2}{3}{4}", transactionModel.txn_code, transactionModel.amt, transactionModel.fee_amt, transactionModel.txn_code_response, transactionModel.numberIdentificationUserCard));
		return MessageFormat.format("{0}{1}{2}{3}{4}", transactionModel.txn_code, transactionModel.amt, transactionModel.fee_amt, transactionModel.txn_code_response, transactionModel.numberIdentificationUserCard);
	}

	@Override
	public String operationTrx(TransactionModel transactionRequest) {
		parse_1(transactionRequest);
		parse_2(transactionRequest);
		parse_3(transactionRequest);
		build_1(transactionRequest);
		build_2(transactionRequest);
		build_3(transactionRequest);
		build_4(transactionRequest);
		return createTrx(transactionResponse);
	}

	@Override
	public TransactionModel readTrx(String transaction) {
		TransactionModel transactionRequest = new TransactionModel();
		transactionRequest.txn_code = transaction.substring(0,1);
		transactionRequest.amt = Double.parseDouble(transaction.substring(1,4));
		transactionRequest.fee_amt = Double.parseDouble(transaction.substring(6,8));
		transactionRequest.numberIdentificationUserCard = transaction.substring(10, 20);
		return transactionRequest;
	}

}

