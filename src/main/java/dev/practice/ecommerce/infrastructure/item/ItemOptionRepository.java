package dev.practice.ecommerce.infrastructure.item;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.ecommerce.domain.item.ItemOption;

public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {
}
