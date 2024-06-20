package dev.practice.ecommerce.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.ecommerce.domain.order.item.OrderItemOption;

public interface OrderItemOptionRepository extends JpaRepository<OrderItemOption, Long> {
}
