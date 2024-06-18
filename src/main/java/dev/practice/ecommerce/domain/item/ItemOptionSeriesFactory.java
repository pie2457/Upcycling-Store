package dev.practice.ecommerce.domain.item;

import java.util.List;

public interface ItemOptionSeriesFactory {
	List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest request, Item item);
}
