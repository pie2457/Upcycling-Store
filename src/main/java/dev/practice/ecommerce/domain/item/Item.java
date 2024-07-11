package dev.practice.ecommerce.domain.item;

import java.security.InvalidParameterException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import dev.practice.ecommerce.common.util.TokenGenerator;
import dev.practice.ecommerce.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "items")
public class Item extends AbstractEntity {
	private static final String PREFIX_ITEM = "itm_";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String itemToken;
	private String partnerToken;
	private String itemName;
	private Long itemPrice;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.PERSIST)
	private List<ItemOptionGroup> itemOptionGroupList = Lists.newArrayList();
	@Enumerated(EnumType.STRING)
	private Status status;

	@Getter
	@RequiredArgsConstructor
	public enum Status {
		PREPARE("판매준비중"),
		ON_SALES("판매중"),
		END_OF_SALES("판매종");

		private final String description;
	}

	@Builder
	public Item(String partnerToken, String itemName, Long itemPrice) {
		if (partnerToken == null)
			throw new InvalidParameterException();
		if (StringUtils.isEmpty(itemName))
			throw new InvalidParameterException();
		if (itemPrice == null)
			throw new InvalidParameterException();

		this.itemToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_ITEM);
		this.partnerToken = partnerToken;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.status = Status.PREPARE;
	}

	public void changeOnSales() {
		this.status = Status.ON_SALES;
	}

	public void changeEndOfSales() {
		this.status = Status.END_OF_SALES;
	}
}
