package dev.practice.ecommerce.domain.order;

import java.security.InvalidParameterException;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import dev.practice.ecommerce.common.util.TokenGenerator;
import dev.practice.ecommerce.domain.AbstractEntity;
import dev.practice.ecommerce.domain.order.fragment.DeliveryFragment;
import dev.practice.ecommerce.domain.order.item.OrderItem;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "orders")
public class Order extends AbstractEntity {
	private static final String ORDER_PREFIX = "ord_";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String orderToken;
	private Long userId;
	private String payMethod;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.PERSIST)
	private List<OrderItem> orderItemList = Lists.newArrayList();

	@Embedded
	private DeliveryFragment deliveryFragment;

	private ZonedDateTime orderedAt;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Getter
	@RequiredArgsConstructor
	public enum Status {
		INIT("주문시작"),
		ORDER_COMPLETE("주문완료"),
		DELIVERY_PREPARE("배송준비"),
		IN_DELIVERY("배송중"),
		DELIVERY_COMPLETE("배송완료");

		private final String description;
	}

	@Builder
	public Order(Long userId, String payMethod, DeliveryFragment deliveryFragment) {
		if (userId == null)
			throw new InvalidParameterException("Order.userId");
		if (StringUtils.isEmpty(payMethod))
			throw new InvalidParameterException("Order.payMethod");
		if (deliveryFragment == null)
			throw new InvalidParameterException("Order.deliveryFragment");

		this.orderToken = TokenGenerator.randomCharacterWithPrefix(ORDER_PREFIX);
		this.userId = userId;
		this.payMethod = payMethod;
		this.deliveryFragment = deliveryFragment;
		this.orderedAt = ZonedDateTime.now();
		this.status = Status.INIT;
	}

	public Long calculateTotalAmount() {
		return orderItemList.stream()
			.mapToLong(OrderItem::calculateTotalAmount)
			.sum();
	}

	public void orderComplete() {
		if (this.status != Status.INIT)
			throw new IllegalStateException();
		this.status = Status.ORDER_COMPLETE;
	}

	public boolean isAlreadyPaymentComplete() {
		switch (this.status) {
			case ORDER_COMPLETE:
			case DELIVERY_PREPARE:
			case IN_DELIVERY:
			case DELIVERY_COMPLETE:
				return true;
		}
		return false;
	}
}
