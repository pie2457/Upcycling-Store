package dev.practice.ecommerce.interfaces.order.gift;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.practice.ecommerce.domain.order.payment.PayMethod;
import dev.practice.ecommerce.interfaces.order.OrderDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class GiftOrderDto {

	@Getter
	@Setter
	@ToString
	public static class RegisterOrderRequest {
		@NotNull(message = "userId 는 필수값 입니다.")
		private Long userId;

		@NotBlank(message = "payMethod 는 필수값 입니다.")
		private String payMethod;

		private final String receiverName = "TEMP_VALUE";
		private final String receiverPhone = "TEMP_VALUE";
		private final String receiverZipcode = "TEMP_VALUE";
		private final String receiverAddress = "TEMP_VALUE";
		private final String receiverDetailAddress = "TEMP_VALUE";
		private final String etcMessage = "TEMP_VALUE";
		private List<GiftOrderDto.RegisterOrderItem> orderItemList;
	}

	@Getter
	@Setter
	@ToString
	public static class RegisterOrderItem {
		@NotNull(message = "orderCount 는 필수값 입니다.")
		private Integer orderCount;

		@NotBlank(message = "itemToken 는 필수값 입니다.")
		private String itemToken;

		@NotBlank(message = "itemName 는 필수값 입니다.")
		private String itemName;

		@NotNull(message = "itemPrice 는 필수값 입니다.")
		private Long itemPrice;

		private List<OrderDto.RegisterOrderItemOptionGroupRequest> orderItemOptionGroupList;
	}

	@Getter
	@Setter
	@ToString
	public static class RegisterOrderItemOptionGroupRequest {
		@NotNull(message = "ordering 는 필수값 입니다.")
		private Integer ordering;

		@NotBlank(message = "itemOptionGroupName 는 필수값 입니다.")
		private String itemOptionGroupName;

		private List<OrderDto.RegisterOrderItemOptionRequest> orderItemOptionList;
	}

	@Getter
	@Setter
	@ToString
	public static class RegisterOrderItemOptionRequest {
		@NotNull(message = "ordering 는 필수값 입니다.")
		private Integer ordering;

		@NotBlank(message = "itemOptionName 는 필수값 입니다.")
		private String itemOptionName;

		@NotNull(message = "itemOptionPrice 는 필수값 입니다.")
		private Long itemOptionPrice;

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

	@Getter
	@ToString
	public static class RegisterResponse {
		private String orderToken;
	}
}
