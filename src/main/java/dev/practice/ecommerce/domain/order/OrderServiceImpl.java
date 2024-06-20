package dev.practice.ecommerce.domain.order;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderStore orderStore;
	private final OrderItemSeriesFactory orderItemSeriesFactory;

	@Override
	public String registerOrder(OrderCommand.RegisterOrder registerOrder) {
		Order order = orderStore.store(registerOrder.toEntity());
		orderItemSeriesFactory.store(order, registerOrder);
		return order.getOrderToken();
	}
}
