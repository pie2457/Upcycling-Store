package dev.practice.ecommerce.infrastructure.item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.ecommerce.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	Optional<Item> findByItemToken(String itemToken);
}
