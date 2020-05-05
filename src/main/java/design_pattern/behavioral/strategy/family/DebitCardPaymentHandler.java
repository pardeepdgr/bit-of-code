package design_pattern.behavioral.strategy.family;

import design_pattern.behavioral.strategy.PaymentStrategy;

public class DebitCardPaymentHandler implements PaymentStrategy {

	@Override
	public String makePayment(double amount) {
		return "Payment is done by using Debit Card";
	}

}
