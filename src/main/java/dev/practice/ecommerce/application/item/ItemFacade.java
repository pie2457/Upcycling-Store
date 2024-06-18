package dev.practice.ecommerce.application.item;

import org.springframework.stereotype.Service;

import dev.practice.ecommerce.domain.item.ItemCommand;
import dev.practice.ecommerce.domain.item.ItemInfo;
import dev.practice.ecommerce.domain.item.ItemService;
import dev.practice.ecommerce.domain.notification.NotificationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemFacade {
	private final ItemService itemService;
	private final NotificationService notificationService;

	public String registerItem(ItemCommand.RegisterItemRequest request, String partnerToken) {
		var itemToken = itemService.registerItem(request, partnerToken);
		notificationService.sendEmail("email", "title", "description");
		return itemToken;
	}

	public void changeOnSaleItem(String itemToken) {
		itemService.changeOnSale(itemToken);
	}

	public void changeEndOfSaleItem(String itemToken) {
		itemService.changeEndOfSale(itemToken);
	}

	public ItemInfo.Main retrieveItemInfo(String itemToken) {
		return itemService.retrieveItemInfo(itemToken);
	}
}
