package model;

import java.util.Objects;

public class Product {
    private final int id;
    private final String name;
    private final int price;
    private final String category;

    public Product(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Товар[артикул=" + id
                + ", название=" + name
                + ", цена=" + price
                + ", категория=" + category + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Product product = (Product) object;
        return id == product.id
                && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }
}
