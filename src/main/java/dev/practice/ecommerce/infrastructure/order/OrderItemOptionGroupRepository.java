package dev.practice.ecommerce.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.ecommerce.domain.order.item.OrderItemOptionGroup;

public interface OrderItemOptionGroupRepository extends JpaRepository<OrderItemOptionGroup, Long> {
}
