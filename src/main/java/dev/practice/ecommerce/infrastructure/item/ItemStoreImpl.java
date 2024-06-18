package dev.practice.ecommerce.infrastructure.item;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.domain.item.Item;
import dev.practice.ecommerce.domain.item.ItemStore;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemStoreImpl implements ItemStore {
	private final ItemRepository itemRepository;

	@Override
	public Item store(Item item) {
		return itemRepository.save(item);
	}
}
