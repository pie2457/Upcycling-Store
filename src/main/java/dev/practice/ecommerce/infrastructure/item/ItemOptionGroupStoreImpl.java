package dev.practice.ecommerce.infrastructure.item;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.domain.item.ItemOptionGroup;
import dev.practice.ecommerce.domain.item.ItemOptionGroupStore;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemOptionGroupStoreImpl implements ItemOptionGroupStore {
	private final ItemOptionGroupRepository itemOptionGroupRepository;

	@Override
	public ItemOptionGroup store(ItemOptionGroup itemOptionGroup) {
		return itemOptionGroupRepository.save(itemOptionGroup);
	}
}
