package dev.practice.ecommerce.domain.order.gift;

public interface GiftMessageChannelSender {
	void paymentComplete(GiftPaymentCompleteMessage message);
}
