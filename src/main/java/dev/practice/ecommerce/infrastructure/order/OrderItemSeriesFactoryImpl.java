package dev.practice.ecommerce.infrastructure.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.domain.item.ItemReader;
import dev.practice.ecommerce.domain.order.Order;
import dev.practice.ecommerce.domain.order.OrderCommand;
import dev.practice.ecommerce.domain.order.OrderItemSeriesFactory;
import dev.practice.ecommerce.domain.order.OrderStore;
import dev.practice.ecommerce.domain.order.item.OrderItem;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderItemSeriesFactoryImpl implements OrderItemSeriesFactory {
	private final ItemReader itemReader;
	private final OrderStore orderStore;

	@Override
	public List<OrderItem> store(Order order, OrderCommand.RegisterOrder requestOrder) {
		return requestOrder.getOrderItemList().stream()
			.map(orderItemRequest -> {
				var item = itemReader.getItemBy(orderItemRequest.getItemToken());
				var initOrderItem = orderItemRequest.toEntity(order, item);
				var orderItem = orderStore.store(initOrderItem);

				orderItemRequest.getOrderItemOptionGroupList().forEach(orderItemOptionGroupRequest -> {
					var initOrderItemOptionGroup = orderItemOptionGroupRequest.toEntity(orderItem);
					var orderItemOptionGroup = orderStore.store(initOrderItemOptionGroup);

					orderItemOptionGroupRequest.getOrderItemOptionList().forEach(orderItemOptionRequest -> {
						var initOrderItemOption = orderItemOptionRequest.toEntity(orderItemOptionGroup);
						orderStore.store(initOrderItemOption);
					});
				});
				return orderItem;
			}).collect(Collectors.toList());
	}
}
