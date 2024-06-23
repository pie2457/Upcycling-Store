package dev.practice.ecommerce.domain.order.item;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "order_item_option_groups")
public class OrderItemOptionGroup extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_item_id")
	private OrderItem orderItem;
	private Integer ordering;
	private String itemOptionGroupName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItemOptionGroup", cascade = CascadeType.PERSIST)
	private List<OrderItemOption> orderItemOptionList = Lists.newArrayList();

	@Builder
	public OrderItemOptionGroup(
		OrderItem orderItem,
		Integer ordering,
		String itemOptionGroupName
	) {
		if (orderItem == null)
			throw new InvalidParamException("OrderItemOptionGroup.orderItem");
		if (ordering == null)
			throw new InvalidParamException("OrderItemOptionGroup.ordering");
		if (StringUtils.isEmpty(itemOptionGroupName))
			throw new InvalidParamException("OrderItemOptionGroup.itemOptionGroupName");

		this.orderItem = orderItem;
		this.ordering = ordering;
		this.itemOptionGroupName = itemOptionGroupName;
	}

	public Long calculateTotalAmount() {
		return orderItemOptionList.stream()
			.mapToLong(OrderItemOption::getItemOptionPrice)
			.sum();
	}
}
