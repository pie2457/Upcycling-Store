package dev.practice.ecommerce.application.partner;

import org.springframework.stereotype.Service;

import dev.practice.ecommerce.domain.notification.NotificationService;
import dev.practice.ecommerce.domain.partner.PartnerCommand;
import dev.practice.ecommerce.domain.partner.PartnerInfo;
import dev.practice.ecommerce.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartnerFacade {
	private final PartnerService partnerService;
	private final NotificationService notificationService;

	public PartnerInfo registerPartner(PartnerCommand command) {
		var partnerInfo = partnerService.registerPartner(command);
		notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");
		return partnerInfo;
	}
}
