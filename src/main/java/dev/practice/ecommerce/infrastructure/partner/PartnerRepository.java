package dev.practice.ecommerce.infrastructure.partner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.ecommerce.domain.partner.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
	Optional<Partner> findByPartnerToken(String partnerToken);
}
