package strategy.family;

import strategy.PaymentStrategy;

public class CreditCardPaymentHandler implements PaymentStrategy {

	@Override
	public String makePayment(double amount) {
		return "Payment is done by using Credit Card";
	}

}