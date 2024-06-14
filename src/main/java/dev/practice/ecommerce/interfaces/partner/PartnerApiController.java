package dev.practice.ecommerce.interfaces.partner;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.practice.ecommerce.application.partner.PartnerFacade;
import dev.practice.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {
	private final PartnerFacade partnerFacade;

	@PostMapping
	public CommonResponse registerPartner(PartnerDto.RegisterRequest request) {
		var command = request.toCommand();
		var partnerInfo = partnerFacade.registerPartner(command);
		var response = new PartnerDto.RegisterResponse(partnerInfo);
		return CommonResponse.success(response);
	}
}
