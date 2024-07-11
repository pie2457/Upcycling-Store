package dev.practice.ecommerce.interfaces.order.gift;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.SqsMessageHeaders;
import org.springframework.stereotype.Component;

import dev.practice.ecommerce.domain.order.gift.GiftMessageChannelSender;
import dev.practice.ecommerce.domain.order.gift.GiftPaymentCompleteMessage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GiftMessageAwsSqsSender implements GiftMessageChannelSender {
	private final String SQS_QUEUE_NAME = "order-payComplete-live.fifo";
	private final QueueMessagingTemplate queueMessagingTemplate;

	@Override
	public void paymentComplete(GiftPaymentCompleteMessage message) {
		try {
			Map<String, Object> headers = new HashMap<>();
			headers.put(SqsMessageHeaders.SQS_GROUP_ID_HEADER, "item-queues");
			headers.put(SqsMessageHeaders.SQS_DEDUPLICATION_ID_HEADER, UUID.randomUUID().toString());
			queueMessagingTemplate.convertAndSend(SQS_QUEUE_NAME, message, headers);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
