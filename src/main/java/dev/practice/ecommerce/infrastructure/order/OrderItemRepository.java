package dev.practice.ecommerce.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.ecommerce.domain.order.item.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
