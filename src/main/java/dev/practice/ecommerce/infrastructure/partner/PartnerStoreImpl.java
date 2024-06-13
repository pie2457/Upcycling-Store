package dev.practice.ecommerce.infrastructure.partner;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import dev.practice.ecommerce.common.exception.InvalidParamException;
import dev.practice.ecommerce.domain.partner.Partner;
import dev.practice.ecommerce.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {

	private final PartnerRepository partnerRepository;

	@Override
	public Partner store(Partner partner) {
		if (StringUtils.isEmpty(partner.getPartnerToken()))
			throw new InvalidParamException("partner.getPartnerToken()");
		if (StringUtils.isEmpty(partner.getPartnerName()))
			throw new InvalidParamException("partner.getPartnerName()");
		if (StringUtils.isEmpty(partner.getBusinessNo()))
			throw new InvalidParamException("partner.getBusinessNo()");
		if (StringUtils.isEmpty(partner.getEmail()))
			throw new InvalidParamException("partner.getEmail()");
		if (partner.getStatus() == null)
			throw new InvalidParamException("partner.getStatus()");

		return partnerRepository.save(partner);
	}
}

