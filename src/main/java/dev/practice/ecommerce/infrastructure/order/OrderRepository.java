package dev.practice.ecommerce.infrastructure.order;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.ecommerce.domain.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	Optional<Order> findByOrderToken(String orderToken);
}
