package dev.practice.ecommerce.interfaces.item;

import static lombok.AccessLevel.*;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import dev.practice.ecommerce.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ItemDto {

	@Getter
	@Setter(value = PROTECTED)
	@ToString
	public static class RegisterItemRequest {
		@NotEmpty
		private String partnerToken;
		@NotEmpty
		private String itemName;
		private Long itemPrice;
		private List<RegisterItemOptionGroupRequest> itemOptionGroupList;
	}

	@Getter
	@Setter(value = PROTECTED)
	@ToString
	public static class RegisterItemOptionGroupRequest {
		private Integer ordering;
		private String itemOptionGroupName;
		private List<RegisterItemOptionRequest> itemOptionList;
	}

	@Getter
	@Setter(value = PROTECTED)
	@ToString
	public static class RegisterItemOptionRequest {
		private Integer ordering;
		private String itemOptionName;
		private Long itemOptionPrice;
	}

	@Getter
	@Builder
	@ToString
	public static class RegisterResponse {
		private final String itemToken;
	}

	@Getter
	@Setter(value = PROTECTED)
	@ToString
	public static class ChangeStatusItemRequest {
		private String itemToken;
	}

	@Getter
	@Builder
	@ToString
	public static class Main {
		private final String itemToken;
		private final String partnerToken;
		private final String itemName;
		private final Long itemPrice;
		private final Item.Status status;
		private final List<ItemOptionGroupInfo> itemOptionGroupList;
	}

	@Getter
	@Builder
	@ToString
	public static class ItemOptionGroupInfo {
		private final Integer ordering;
		private final String itemOptionGroupName;
		private final List<ItemOptionInfo> itemOptionList;
	}

	@Getter
	@Builder
	@ToString
	public static class ItemOptionInfo {
		private final Integer ordering;
		private final String itemOptionName;
		private final Long itemOptionPrice;
	}
}
