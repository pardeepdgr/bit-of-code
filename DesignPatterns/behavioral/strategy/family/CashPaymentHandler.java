package strategy.family;

import strategy.PaymentStrategy;

public class CashPaymentHandler implements PaymentStrategy {

	@Override
	public String makePayment(double amount) {
		return "Payment is done by using Cash";
	}

}