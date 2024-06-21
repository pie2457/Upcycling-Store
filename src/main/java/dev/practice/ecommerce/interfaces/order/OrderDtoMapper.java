package dev.practice.ecommerce.interfaces.order;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.practice.ecommerce.domain.order.OrderCommand;

@Mapper(
	componentModel = "spring",
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface OrderDtoMapper {

	OrderCommand.RegisterOrder of(OrderDto.RegisterOrderRequest request);

	OrderDto.RegisterResponse of(String orderToken);
}
