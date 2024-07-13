package dev.practice.ecommerce.domain.order;

import java.util.List;

import dev.practice.ecommerce.domain.item.Item;
import dev.practice.ecommerce.domain.order.fragment.DeliveryFragment;
import dev.practice.ecommerce.domain.order.item.OrderItem;
import dev.practice.ecommerce.domain.order.item.OrderItemOption;
import dev.practice.ecommerce.domain.order.item.OrderItemOptionGroup;
import dev.practice.ecommerce.domain.order.payment.PayMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class OrderCommand {

	@Getter
	@Builder
	@ToString
	public static class RegisterOrder {
		private final Long userId;
		private final String payMethod;
		private final String receiverName;
		private final String receiverPhone;
		private final String receiverZipcode;
		private final String receiverAddress;
		private final String receiverDetailAddress;
		private final String etcMessage;
		private final List<RegisterOrderItem> orderItemList;

		public Order toEntity() {
			var deliveryFragment = DeliveryFragment.builder()
				.receiverName(receiverName)
				.receiverPhone(receiverPhone)
				.receiverZipcode(receiverZipcode)
				.receiverAddress(receiverAddress)
				.receiverDetailAddress(receiverDetailAddress)
				.etcMessage(etcMessage)
				.build();

			return Order.builder()
				.userId(userId)
				.payMethod(payMethod)
				.deliveryFragment(deliveryFragment)
				.build();
		}
	}

	@Getter
	@Builder
	@ToString
	public static class RegisterOrderItem {
		private final Integer orderCount;
		private final String itemToken;
		private final String itemName;
		private final Long itemPrice;
		private List<RegisterOrderItemOptionGroup> orderItemOptionGroupList;

		public OrderItem toEntity(Order order, Item item) {
			return OrderItem.builder()
				.order(order)
				.orderCount(orderCount)
				.partnerToken(item.getPartnerToken())
				.itemId(item.getId())
				.itemToken(itemToken)
				.itemName(itemName)
				.itemPrice(itemPrice)
				.build();
		}
	}

	@Getter
	@Builder
	@ToString
	public static class RegisterOrderItemOptionGroup {
		private final Integer ordering;
		private final String itemOptionGroupName;
		private final List<RegisterOrderItemOption> orderItemOptionList;

		public OrderItemOptionGroup toEntity(OrderItem orderItem) {
			return OrderItemOptionGroup.builder()
				.orderItem(orderItem)
				.ordering(ordering)
				.itemOptionGroupName(itemOptionGroupName)
				.build();
		}
	}

	@Getter
	@Builder
	@ToString
	public static class RegisterOrderItemOption {
		private final Integer ordering;
		private final String itemOptionName;
		private final Long itemOptionPrice;

		public OrderItemOption toEntity(OrderItemOptionGroup orderItemOptionGroup) {
			return OrderItemOption.builder()
				.orderItemOptionGroup(orderItemOptionGroup)
				.ordering(ordering)
				.itemOptionName(itemOptionName)
				.itemOptionPrice(itemOptionPrice)
				.build();
		}
	}

	@Getter
	@Builder
	@ToString
	public static class PaymentRequest {
		private final String orderToken;
		private final Long amount;
		private final PayMethod payMethod;
	}

	@Getter
	@Builder
	@ToString
	public static class UpdateReceiverRequest {
		private final String giftToken;
		private final String receiverName;
		private final String receiverPhone;
		private final String receiverZipcode;
		private final String receiverAddress;
		private final String receiverDetailAddress;
		private final String etcMessage;
	}
}
