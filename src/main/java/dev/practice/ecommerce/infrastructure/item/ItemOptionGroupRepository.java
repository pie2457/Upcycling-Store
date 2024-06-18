package dev.practice.ecommerce.infrastructure.item;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.ecommerce.domain.item.ItemOptionGroup;

public interface ItemOptionGroupRepository extends JpaRepository<ItemOptionGroup, Long> {
}
