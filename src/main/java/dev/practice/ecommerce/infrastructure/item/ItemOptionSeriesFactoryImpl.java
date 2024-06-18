package dev.practice.ecommerce.infrastructure.item;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import dev.practice.ecommerce.domain.item.Item;
import dev.practice.ecommerce.domain.item.ItemCommand;
import dev.practice.ecommerce.domain.item.ItemOptionGroup;
import dev.practice.ecommerce.domain.item.ItemOptionGroupStore;
import dev.practice.ecommerce.domain.item.ItemOptionSeriesFactory;
import dev.practice.ecommerce.domain.item.ItemOptionStore;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemOptionSeriesFactoryImpl implements ItemOptionSeriesFactory {
	private final ItemOptionGroupStore itemOptionGroupStore;
	private final ItemOptionStore itemOptionStore;

	@Override
	public List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest command, Item item) {
		var itemOptionGroupRequestList = command.getItemOptionGroupRequestList();
		if (CollectionUtils.isEmpty(itemOptionGroupRequestList))
			return Collections.emptyList();

		return itemOptionGroupRequestList.stream()
			.map(requestItemOptionGroup -> {
				var initItemOptionGroup = requestItemOptionGroup.toEntity(item);
				var itemOptionGroup = itemOptionGroupStore.store(initItemOptionGroup);

				requestItemOptionGroup.getItemOptionRequestList().forEach(requestItemOption -> {
					var initItemOption = requestItemOption.toEntity(itemOptionGroup);
					itemOptionStore.store(initItemOption);
				});

				return itemOptionGroup;
			}).collect(Collectors.toList());
	}
}
