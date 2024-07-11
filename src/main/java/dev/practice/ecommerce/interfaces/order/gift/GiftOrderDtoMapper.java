package dev.practice.ecommerce.interfaces.order.gift;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.practice.ecommerce.domain.order.OrderCommand;

@Mapper(
	componentModel = "spring",
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface GiftOrderDtoMapper {
	OrderCommand.RegisterOrder of(GiftOrderDto.RegisterOrderRequest request);

	GiftOrderDto.RegisterResponse of(String orderToken);

	OrderCommand.PaymentRequest of(GiftOrderDto.PaymentRequest request);
}
