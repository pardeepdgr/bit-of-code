package design_pattern.behavioral.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

import design_pattern.behavioral.strategy.family.CashPaymentHandler;
import design_pattern.behavioral.strategy.family.CreditCardPaymentHandler;
import design_pattern.behavioral.strategy.family.DebitCardPaymentHandler;

public class PaymentHandlerTest {

	@Test
	public void testPayment_Cash() {
		PaymentHandler handler = new PaymentHandler(new CashPaymentHandler());
		assertEquals("Payment is done by using Cash",
				handler.makePayment(100.00));
	}

	@Test
	public void testPayment_DebitCard() {
		PaymentHandler handler = new PaymentHandler(
				new DebitCardPaymentHandler());
		assertEquals("Payment is done by using Debit Card",
				handler.makePayment(100.00));
	}

	@Test
	public void testPayment_CreditCard() {
		PaymentHandler handler = new PaymentHandler(
				new CreditCardPaymentHandler());
		assertEquals("Payment is done by using Credit Card",
				handler.makePayment(100.00));
	}

}
