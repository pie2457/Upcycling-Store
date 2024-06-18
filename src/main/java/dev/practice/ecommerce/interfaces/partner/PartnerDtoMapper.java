package dev.practice.ecommerce.interfaces.partner;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.practice.ecommerce.domain.partner.PartnerCommand;

@Mapper(
	componentModel = "spring",
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PartnerDtoMapper {

	PartnerCommand of(PartnerDto.RegisterRequest request);
}
