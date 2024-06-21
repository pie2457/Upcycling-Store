package dev.practice.ecommerce.interfaces.order;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import dev.practice.ecommerce.domain.order.OrderCommand;
import dev.practice.ecommerce.domain.order.OrderInfo;

@Mapper(
	componentModel = "spring",
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface OrderDtoMapper {
	@Mappings({
		@Mapping(source = "orderedAt", target = "orderedAt", dateFormat = "yyyy-MM-dd HH:mm:ss")
	})
	OrderDto.Main of(OrderInfo.Main mainResult);

	OrderCommand.RegisterOrder of(OrderDto.RegisterOrderRequest request);

	OrderDto.RegisterResponse of(String orderToken);
}
