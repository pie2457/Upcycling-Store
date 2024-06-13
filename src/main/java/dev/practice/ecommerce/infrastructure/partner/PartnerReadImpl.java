package dev.practice.ecommerce.infrastructure.partner;

import org.springframework.stereotype.Component;

import dev.practice.ecommerce.common.exception.EntityNotFoundException;
import dev.practice.ecommerce.domain.partner.Partner;
import dev.practice.ecommerce.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PartnerReadImpl implements PartnerReader {
	private final PartnerRepository partnerRepository;

	@Override
	public Partner getPartner(String partnerToken) {
		return partnerRepository.findByPartnerToken(partnerToken)
			.orElseThrow(EntityNotFoundException::new);
	}
}
