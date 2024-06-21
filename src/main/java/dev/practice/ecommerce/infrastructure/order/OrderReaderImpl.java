package dev.practice.ecommerce.infrastructure.order;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.common.exception.EntityNotFoundException;
import dev.practice.ecommerce.domain.order.Order;
import dev.practice.ecommerce.domain.order.OrderReader;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderReaderImpl implements OrderReader {
	private final OrderRepository orderRepository;

	@Override
	public Order getOrder(String orderToken) {
		return orderRepository.findByOrderToken(orderToken)
			.orElseThrow(EntityNotFoundException::new);
	}
}
