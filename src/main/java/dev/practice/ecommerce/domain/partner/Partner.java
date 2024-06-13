package dev.practice.ecommerce.domain.partner;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import dev.practice.ecommerce.common.exception.InvalidParamException;
import dev.practice.ecommerce.common.util.TokenGenerator;
import dev.practice.ecommerce.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "partners")
public class Partner extends AbstractEntity {
	private static final String PREFIX_PARTNER = "ptn_";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String partnerToken;
	private String partnerName;
	private String businessNo;
	private String email;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Getter
	@RequiredArgsConstructor
	public enum Status {
		ENABLE("활성화"), DISABLE("비활성화");
		private final String description;
	}

	@Builder
	public Partner(String partnerName, String businessNo, String email) {
		if (StringUtils.isEmpty(partnerName))
			throw new InvalidParamException("empty partnerName");
		if (StringUtils.isEmpty(businessNo))
			throw new InvalidParamException("empty businessNo");
		if (StringUtils.isEmpty(email))
			throw new InvalidParamException("empty email");

		this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
		this.partnerName = partnerName;
		this.businessNo = businessNo;
		this.email = email;
		this.status = Status.ENABLE;
	}

	public void enable() {
		this.status = Status.ENABLE;
	}

	public void disable() {
		this.status = Status.DISABLE;
	}
}
