package dev.practice.ecommerce.infrastructure.item;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.common.exception.EntityNotFoundException;
import dev.practice.ecommerce.domain.item.Item;
import dev.practice.ecommerce.domain.item.ItemInfo;
import dev.practice.ecommerce.domain.item.ItemReader;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ItemReaderImpl implements ItemReader {
	private final ItemRepository itemRepository;

	@Override
	public Item getItemBy(String itemToken) {
		return itemRepository.findByItemToken(itemToken)
			.orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<ItemInfo.ItemOptionGroupInfo> getItemOptionSeries(Item item) {
		var itemOptionGroupList = item.getItemOptionGroupList();
		return itemOptionGroupList.stream()
			.map(itemOptionGroup -> {
				var itemOptionList = itemOptionGroup.getItemOptionList();
				var itemOptionInfoList = itemOptionList.stream()
					.map(ItemInfo.ItemOptionInfo::new)
					.collect(Collectors.toList());

				return new ItemInfo.ItemOptionGroupInfo(itemOptionGroup, itemOptionInfoList);
			}).collect(Collectors.toList());
	}
}
