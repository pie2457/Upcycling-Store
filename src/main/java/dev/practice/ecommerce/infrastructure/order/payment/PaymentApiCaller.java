package dev.practice.ecommerce.infrastructure.order.payment;

import dev.practice.ecommerce.domain.order.OrderCommand;
import dev.practice.ecommerce.domain.order.payment.PayMethod;

public interface PaymentApiCaller {
	boolean support(PayMethod payMethod);

	void pay(OrderCommand.PaymentRequest request);
}
