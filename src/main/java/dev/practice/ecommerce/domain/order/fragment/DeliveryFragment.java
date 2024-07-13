package dev.practice.ecommerce.domain.order.fragment;

import java.security.InvalidParameterException;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.StringUtils;

import dev.practice.ecommerce.domain.order.OrderCommand;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class DeliveryFragment {
	private String receiverName;
	private String receiverPhone;
	private String receiverZipcode;
	private String receiverAddress;
	private String receiverDetailAddress;
	private String etcMessage;

	@Builder
	public DeliveryFragment(
		String receiverName, String receiverPhone, String receiverZipcode,
		String receiverAddress, String receiverDetailAddress, String etcMessage) {
		if (StringUtils.isEmpty(receiverName))
			throw new InvalidParameterException("DeliveryFragment.receiverName");
		if (StringUtils.isEmpty(receiverPhone))
			throw new InvalidParameterException("DeliveryFragment.receiverPhone");
		if (StringUtils.isEmpty(receiverZipcode))
			throw new InvalidParameterException("DeliveryFragment.receiverZipcode");
		if (StringUtils.isEmpty(receiverAddress))
			throw new InvalidParameterException("DeliveryFragment.receiverAddress");
		if (StringUtils.isEmpty(receiverDetailAddress))
			throw new InvalidParameterException("DeliveryFragment.receiverDetailAddress");
		if (StringUtils.isEmpty(etcMessage))
			throw new InvalidParameterException("DeliveryFragment.etcMessage");

		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverZipcode = receiverZipcode;
		this.receiverAddress = receiverAddress;
		this.receiverDetailAddress = receiverDetailAddress;
		this.etcMessage = etcMessage;
	}

	public static DeliveryFragment from(OrderCommand.UpdateReceiverRequest receiverRequest) {
		return DeliveryFragment.builder()
			.receiverName(receiverRequest.getReceiverName())
			.receiverPhone(receiverRequest.getReceiverPhone())
			.receiverZipcode(receiverRequest.getReceiverZipcode())
			.receiverAddress(receiverRequest.getReceiverAddress())
			.receiverDetailAddress(receiverRequest.getReceiverDetailAddress())
			.etcMessage(receiverRequest.getEtcMessage())
			.build();
	}
}
