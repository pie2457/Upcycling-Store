package dev.practice.ecommerce.infrastructure.order.payment;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.domain.order.Order;
import dev.practice.ecommerce.domain.order.OrderCommand;
import dev.practice.ecommerce.domain.order.payment.PaymentProcessor;
import dev.practice.ecommerce.domain.order.payment.validator.PaymentValidator;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentProcessorImpl implements PaymentProcessor {
	private final List<PaymentValidator> paymentValidatorList;
	private final List<PaymentApiCaller> paymentApiCallerList;

	@Override
	public void pay(Order order, OrderCommand.PaymentRequest request) {
		paymentValidatorList.forEach(paymentValidator -> paymentValidator.validate(order, request));
		PaymentApiCaller paymentApiCaller = routingApiCaller(request);
		paymentApiCaller.pay(request);
	}

	private PaymentApiCaller routingApiCaller(OrderCommand.PaymentRequest request) {
		return paymentApiCallerList.stream()
			.filter(paymentApiCaller -> paymentApiCaller.support(request.getPayMethod()))
			.findFirst()
			.orElseThrow(InvalidParameterException::new);
	}
}
