package dev.practice.ecommerce.domain.order.gift;

import dev.practice.ecommerce.domain.order.OrderCommand;

public interface GiftOrderService {
	void paymentOrder(OrderCommand.PaymentRequest request);
}
