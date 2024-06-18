package dev.practice.ecommerce.interfaces.partner;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	private final PartnerDtoMapper partnerDtoMapper;

	@PostMapping
	public CommonResponse registerPartner(@RequestBody @Valid PartnerDto.RegisterRequest request) {
		var command = partnerDtoMapper.of(request);
		var partnerInfo = partnerFacade.registerPartner(command);
		var response = new PartnerDto.RegisterResponse(partnerInfo);
		return CommonResponse.success(response);
	}
}
