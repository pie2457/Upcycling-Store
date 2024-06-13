package dev.practice.ecommerce.common.exception;

import dev.practice.ecommerce.common.response.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseException extends RuntimeException {
	private ErrorCode errorCode;

	public BaseException(ErrorCode errorCode) {
		super(errorCode.getErrorMsg());
		this.errorCode = errorCode;
	}

	public BaseException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
