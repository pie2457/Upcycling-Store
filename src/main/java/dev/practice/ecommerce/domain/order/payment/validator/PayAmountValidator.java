package dev.practice.ecommerce.domain.order.payment.validator;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.common.exception.InvalidParamException;
import dev.practice.ecommerce.domain.order.Order;
import dev.practice.ecommerce.domain.order.OrderCommand;

@org.springframework.core.annotation.Order(value = 1)
@Component
public class PayAmountValidator implements PaymentValidator {

	@Override
	public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
		if (!order.calculateTotalAmount().equals(paymentRequest.getAmount()))
			throw new InvalidParamException("주문가격이 불일치합니다");
	}
}
