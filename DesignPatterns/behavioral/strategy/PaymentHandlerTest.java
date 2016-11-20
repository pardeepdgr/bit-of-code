package strategy;

import static org.junit.Assert.*;

import org.junit.Test;

import strategy.family.CashPaymentHandler;
import strategy.family.CreditCardPaymentHandler;
import strategy.family.DebitCardPaymentHandler;

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
