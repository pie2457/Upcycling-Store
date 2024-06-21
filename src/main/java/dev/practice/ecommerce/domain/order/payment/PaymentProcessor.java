package dev.practice.ecommerce.domain.order.payment;

import dev.practice.ecommerce.domain.order.Order;
import dev.practice.ecommerce.domain.order.OrderCommand;

public interface PaymentProcessor {
	void pay(Order order, OrderCommand.PaymentRequest request);
}
