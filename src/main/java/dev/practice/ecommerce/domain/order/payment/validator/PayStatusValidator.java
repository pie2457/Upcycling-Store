package dev.practice.ecommerce.domain.order.payment.validator;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.common.exception.InvalidParamException;
import dev.practice.ecommerce.domain.order.Order;
import dev.practice.ecommerce.domain.order.OrderCommand;

@org.springframework.core.annotation.Order(value = 3)
@Component
public class PayStatusValidator implements PaymentValidator {

	@Override
	public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
		if (order.isAlreadyPaymentComplete())
			throw new InvalidParamException("이미 결제완료된 주문입니다");
	}
}

