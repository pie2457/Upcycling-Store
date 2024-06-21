package dev.practice.ecommerce.domain.order.payment.validator;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.common.exception.InvalidParamException;
import dev.practice.ecommerce.domain.order.Order;
import dev.practice.ecommerce.domain.order.OrderCommand;

@org.springframework.core.annotation.Order(value = 2)
@Component
public class PayMethodValidator implements PaymentValidator {

	@Override
	public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
		if (!order.getPayMethod().equals(paymentRequest.getPayMethod().name())) {
			throw new InvalidParamException("주문 과정에서의 결제수단이 다릅니다.");
		}
	}
}
