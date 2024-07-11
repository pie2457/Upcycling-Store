package dev.practice.ecommerce.interfaces.order.gift;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.practice.ecommerce.application.order.OrderFacade;
import dev.practice.ecommerce.application.order.gift.GiftFacade;
import dev.practice.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gift-orders")
public class GiftOrderApiController {
	private final OrderFacade orderFacade;
	private final GiftFacade giftFacade;
	private final GiftOrderDtoMapper giftOrderDtoMapper;

	@PostMapping("/init")
	public CommonResponse registerOrder(@RequestBody @Valid GiftOrderDto.RegisterOrderRequest request) {
		var orderCommand = giftOrderDtoMapper.of(request);
		var orderToken = orderFacade.registerOrder(orderCommand);
		var response = giftOrderDtoMapper.of(orderToken);
		return CommonResponse.success(response);
	}

	@PostMapping("/payment-order")
	public CommonResponse paymentOrder(@RequestBody @Valid GiftOrderDto.PaymentRequest request) {
		var orderPaymentCommand = giftOrderDtoMapper.of(request);
		giftFacade.paymentOrder(orderPaymentCommand);
		return CommonResponse.success("OK");
	}
}
