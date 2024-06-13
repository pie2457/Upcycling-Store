package dev.practice.ecommerce.common.exception;

import dev.practice.ecommerce.common.response.ErrorCode;

public class InvalidParamException extends BaseException {

	public InvalidParamException(String errorMsg) {
		super(errorMsg, ErrorCode.COMMON_INVALID_PARAMETER);
	}
}
