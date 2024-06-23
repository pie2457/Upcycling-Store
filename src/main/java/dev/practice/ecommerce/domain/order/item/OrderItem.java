package dev.practice.ecommerce.domain.order.item;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import dev.practice.ecommerce.common.exception.InvalidParamException;
import dev.practice.ecommerce.domain.AbstractEntity;
import dev.practice.ecommerce.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	private Integer orderCount;
	private String partnerToken;
	private Long itemId;
	private String itemName;
	private String itemToken;
	private Long itemPrice;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItem", cascade = CascadeType.PERSIST)
	private List<OrderItemOptionGroup> orderItemOptionGroupList = Lists.newArrayList();

	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;

	@Getter
	@AllArgsConstructor
	public enum DeliveryStatus {
		BEFORE_DELIVERY("배송전"),
		DELIVERY_PREPARE("배송준비중"),
		DELIVERING("배송중"),
		COMPLETE_DELIVERY("배송완료");

		private final String description;
	}

	@Builder
	public OrderItem(
		Order order,
		Integer orderCount,
		String partnerToken,
		Long itemId,
		String itemName,
		String itemToken,
		Long itemPrice
	) {
		if (order == null)
			throw new InvalidParamException("OrderItem.order");
		if (orderCount == null)
			throw new InvalidParamException("OrderItem.orderCount");
		if (partnerToken == null)
			throw new InvalidParamException("OrderItem.partnerToken");
		if (itemId == null && StringUtils.isEmpty(itemName))
			throw new InvalidParamException("OrderItem.itemNo and itemName");
		if (StringUtils.isEmpty(itemToken))
			throw new InvalidParamException("OrderItem.itemToken");
		if (itemPrice == null)
			throw new InvalidParamException("OrderItem.itemPrice");

		this.order = order;
		this.orderCount = orderCount;
		this.partnerToken = partnerToken;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemToken = itemToken;
		this.itemPrice = itemPrice;
		this.deliveryStatus = DeliveryStatus.BEFORE_DELIVERY;
	}

	public Long calculateTotalAmount() {
		var itemOptionTotalAmount = orderItemOptionGroupList.stream()
			.mapToLong(OrderItemOptionGroup::calculateTotalAmount)
			.sum();
		return (itemPrice + itemOptionTotalAmount) * orderCount;
	}
}
