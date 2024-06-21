package dev.practice.ecommerce.domain.order;

public interface OrderReader {

	Order getOrder(String orderToken);
}
