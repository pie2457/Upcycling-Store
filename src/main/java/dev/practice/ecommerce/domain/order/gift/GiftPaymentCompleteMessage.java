package dev.practice.ecommerce.domain.order.gift;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class GiftPaymentCompleteMessage {
	private String orderToken;
}
