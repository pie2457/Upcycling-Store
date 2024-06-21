package dev.practice.ecommerce.infrastructure.order.payment;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.domain.order.OrderCommand;
import dev.practice.ecommerce.domain.order.payment.PayMethod;

@Component
public class NaverPayApiCaller implements PaymentApiCaller {
	@Override
	public boolean support(PayMethod payMethod) {
		return PayMethod.NAVER_PAY == payMethod;
	}

	@Override
	public void pay(OrderCommand.PaymentRequest request) {
		//TO-DO 구현
	}
}
