package dev.practice.ecommerce.infrastructure.item;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.domain.item.ItemOption;
import dev.practice.ecommerce.domain.item.ItemOptionStore;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemOptionStoreImpl implements ItemOptionStore {
	private final ItemOptionRepository itemOptionRepository;

	@Override
	public void store(ItemOption itemOption) {
		itemOptionRepository.save(itemOption);
	}
}
