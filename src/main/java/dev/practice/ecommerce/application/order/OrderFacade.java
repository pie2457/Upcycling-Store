package dev.practice.ecommerce.application.order;

import org.springframework.stereotype.Service;

import dev.practice.ecommerce.domain.notification.NotificationService;
import dev.practice.ecommerce.domain.order.OrderCommand;
import dev.practice.ecommerce.domain.order.OrderInfo;
import dev.practice.ecommerce.domain.order.OrderService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderFacade {
	private final OrderService orderService;
	private final NotificationService notificationService;

	public String registerOrder(OrderCommand.RegisterOrder registerOrder) {
		var orderToken = orderService.registerOrder(registerOrder);
		notificationService.sendKakao("전화번호", "ORDER_COMPLETE");
		return orderToken;
	}

	public OrderInfo.Main retrieveOrder(String orderToken) {
		return orderService.retrieveOrder(orderToken);
	}

	public void paymentOrder(OrderCommand.PaymentRequest paymentRequest) {
		orderService.paymentOrder(paymentRequest);
		notificationService.sendKakao("전화번호", "description");
	}

	public void updateReceiverInfo(String orderToken, OrderCommand.UpdateReceiverRequest receiverRequest) {
		orderService.updateReceiver(orderToken, receiverRequest);
	}
}
