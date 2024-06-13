package dev.practice.ecommerce.common.exception;

import dev.practice.ecommerce.common.response.ErrorCode;

public class EntityNotFoundException extends BaseException {

	public EntityNotFoundException() {
		super(ErrorCode.COMMON_INVALID_PARAMETER);
	}
}
