package model;

import java.util.Arrays;
import java.util.Objects;

public class Order {
    private final String customer;
    private final Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket == null ? null : basket.clone();
    }

    @Override
    public String toString() {
        return "Заказ[покупатель=" + customer
                + ", корзина=" + Arrays.toString(basket) + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Order order = (Order) object;

        if (!Objects.equals(customer, order.customer)) {
            return false;
        }

        if (basket == order.basket) {
            return true;
        }

        if (basket == null || order.basket == null) {
            return false;
        }

        if (basket.length != order.basket.length) {
            return false;
        }

        boolean basketsEqual = true;

        for (int i = 0; i < basket.length; i++) {
            Product product = basket[i];
            Product otherProduct = order.basket[i];

            if (product == null) {
                if (otherProduct != null) {
                    basketsEqual = false;
                    break;
                }
            } else if (!product.equals(otherProduct)) {
                basketsEqual = false;
                break;
            }
        }

        return basketsEqual;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(customer);
        result = 31 * result + Arrays.hashCode(basket);
        return result;
    }
}