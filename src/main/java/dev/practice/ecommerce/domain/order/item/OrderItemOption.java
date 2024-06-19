package dev.practice.ecommerce.domain.order.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.practice.ecommerce.common.exception.InvalidParamException;
import dev.practice.ecommerce.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "order_item_options")
public class OrderItemOption extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_item_option_group_id")
	private OrderItemOptionGroup orderItemOptionGroup;
	private Integer ordering;
	private String itemOptionName;
	private Long itemOptionPrice;

	@Builder
	public OrderItemOption(
		OrderItemOptionGroup orderItemOptionGroup,
		Integer ordering,
		String itemOptionName,
		Long itemOptionPrice) {

		if (orderItemOptionGroup == null)
			throw new InvalidParamException("OrderItemOption.orderItemOptionGroup");
		if (ordering == null)
			throw new InvalidParamException("OrderItemOption.ordering");
		if (itemOptionName == null)
			throw new InvalidParamException("OrderItemOption.itemOptionName");
		if (itemOptionPrice == null)
			throw new InvalidParamException("OrderItemOption.itemOptionPrice");

		this.orderItemOptionGroup = orderItemOptionGroup;
		this.ordering = ordering;
		this.itemOptionName = itemOptionName;
		this.itemOptionPrice = itemOptionPrice;
	}
}
