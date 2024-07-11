package dev.practice.ecommerce.domain.order.gift;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.practice.ecommerce.domain.order.OrderCommand;
import dev.practice.ecommerce.domain.order.OrderReader;
import dev.practice.ecommerce.domain.order.payment.PaymentProcessor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GiftOrderServiceImpl implements GiftOrderService {
	private final OrderReader orderReader;
	private final PaymentProcessor paymentProcessor;
	private final GiftMessageChannelSender giftMessageChannelSender;

	@Override
	@Transactional
	public void paymentOrder(OrderCommand.PaymentRequest paymentRequest) {
		var order = orderReader.getOrder(paymentRequest.getOrderToken());

		paymentProcessor.pay(order, paymentRequest);
		order.orderComplete();

		giftMessageChannelSender.paymentComplete(new GiftPaymentCompleteMessage(order.getOrderToken()));
	}
}
