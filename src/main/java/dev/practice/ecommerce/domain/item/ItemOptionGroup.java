package dev.practice.ecommerce.domain.item;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import dev.practice.ecommerce.common.exception.InvalidParamException;
import dev.practice.ecommerce.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "item_option_groups")
public class ItemOptionGroup extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
	private Integer ordering;
	private String itemOptionGroupName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itemOptionGroup", cascade = CascadeType.PERSIST)
	private List<ItemOption> itemOptionList = Lists.newArrayList();

	@Builder
	public ItemOptionGroup(Item item, Integer ordering, String itemOptionGroupName) {
		if (item == null)
			throw new InvalidParamException("ItemOptionGroup.item");
		if (ordering == null)
			throw new InvalidParamException("ItemOptionGroup.ordering");
		if (StringUtils.isBlank(itemOptionGroupName))
			throw new InvalidParamException("ItemOptionGroup.itemOptionGroupName");

		this.item = item;
		this.ordering = ordering;
		this.itemOptionGroupName = itemOptionGroupName;
	}
}
