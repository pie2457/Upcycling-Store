package dev.practice.ecommerce.domain.order.payment.validator;

import dev.practice.ecommerce.domain.order.Order;
import dev.practice.ecommerce.domain.order.OrderCommand;

public interface PaymentValidator {
	void validate(Order order, OrderCommand.PaymentRequest request);
}
