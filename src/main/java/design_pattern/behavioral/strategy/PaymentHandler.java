package design_pattern.behavioral.strategy;

public class PaymentHandler {

	private PaymentStrategy strategy;

	public PaymentHandler(PaymentStrategy strategy) {
		this.strategy = strategy;
	}
	
	public String makePayment(double amount){
		return strategy.makePayment(amount);
	}
}
