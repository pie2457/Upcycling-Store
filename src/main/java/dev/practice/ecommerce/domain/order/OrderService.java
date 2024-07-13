package dev.practice.ecommerce.domain.order;

public interface OrderService {
	String registerOrder(OrderCommand.RegisterOrder registerOrder);

	void paymentOrder(OrderCommand.PaymentRequest paymentRequest);

	OrderInfo.Main retrieveOrder(String orderToken);

	void updateReceiver(String orderToken, OrderCommand.UpdateReceiverRequest receiverRequest);
}
