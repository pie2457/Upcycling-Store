package dev.practice.ecommerce.application.order.gift;

import org.springframework.stereotype.Service;

import dev.practice.ecommerce.domain.order.OrderCommand;
import dev.practice.ecommerce.domain.order.gift.GiftOrderService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GiftFacade {
	private final GiftOrderService giftOrderService;

	public void paymentOrder(OrderCommand.PaymentRequest request) {
		giftOrderService.paymentOrder(request);
	}
}
