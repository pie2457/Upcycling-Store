package dev.practice.ecommerce.interfaces.order;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.practice.ecommerce.application.order.OrderFacade;
import dev.practice.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderApiController {
	private final OrderFacade orderFacade;
	private final OrderDtoMapper orderDtoMapper;

	@PostMapping("/init")
	public CommonResponse registerOrder(@RequestBody @Valid OrderDto.RegisterOrderRequest request) {
		var orderCommand = orderDtoMapper.of(request);
		var orderToken = orderFacade.registerOrder(orderCommand);
		var response = orderDtoMapper.of(orderToken);
		return CommonResponse.success(response);
	}
}
