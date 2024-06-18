package dev.practice.ecommerce.domain.item;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	private final ItemStore itemStore;
	private final ItemReader itemReader;
	private final ItemOptionSeriesFactory itemOptionSeriesFactory;

	@Override
	@Transactional
	public String registerItem(ItemCommand.RegisterItemRequest command, String partnerToken) {
		var initItem = command.toEntity(partnerToken);
		var item = itemStore.store(initItem);
		itemOptionSeriesFactory.store(command, item);
		return item.getItemToken();
	}

	private Item getItem(String itemToken) {
		return itemReader.getItemBy(itemToken);
	}

	@Override
	@Transactional
	public void changeOnSale(String itemToken) {
		var item = getItem(itemToken);
		item.changeOnSales();
	}

	@Override
	@Transactional
	public void changeEndOfSale(String itemToken) {
		var item = getItem(itemToken);
		item.changeEndOfSales();
	}

	@Override
	public ItemInfo.Main retrieveItemInfo(String itemToken) {
		var item = getItem(itemToken);
		var itemOptionGroupInfoList = itemReader.getItemOptionSeries(item);
		return new ItemInfo.Main(item, itemOptionGroupInfoList);
	}
}
