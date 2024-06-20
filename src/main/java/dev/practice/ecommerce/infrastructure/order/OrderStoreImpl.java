package dev.practice.ecommerce.infrastructure.order;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.domain.order.Order;
import dev.practice.ecommerce.domain.order.OrderStore;
import dev.practice.ecommerce.domain.order.item.OrderItem;
import dev.practice.ecommerce.domain.order.item.OrderItemOption;
import dev.practice.ecommerce.domain.order.item.OrderItemOptionGroup;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderStoreImpl implements OrderStore {
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	private final OrderItemOptionGroupRepository orderItemOptionGroupRepository;
	private final OrderItemOptionRepository orderItemOptionRepository;

	@Override
	public Order store(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public OrderItem store(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

	@Override
	public OrderItemOptionGroup store(OrderItemOptionGroup orderItemOptionGroup) {
		return orderItemOptionGroupRepository.save(orderItemOptionGroup);
	}

	@Override
	public OrderItemOption store(OrderItemOption orderItemOption) {
		return orderItemOptionRepository.save(orderItemOption);
	}
}
