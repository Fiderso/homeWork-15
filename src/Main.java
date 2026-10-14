import model.Order;
import model.Product;

public class Main {
    public static void main(String[] args) {
        Product smartphone = new Product(
                101, "Смартфон", 50000, "Электроника"
        );
        Product sameSmartphone = new Product(
                101, "Смартфон со скидкой", 45000, "Электроника"
        );
        Product headphones = new Product(
                102, "Наушники", 7000, "Аксессуары"
        );
        Product unknownProduct = new Product(103, null, 1000, null);
        Product sameUnknownProduct = new Product(103, null, 2000, null);

        System.out.println("Товары:");
        System.out.println(smartphone);
        System.out.println(sameSmartphone);
        System.out.println(headphones);
        System.out.println(unknownProduct);
        System.out.println(sameUnknownProduct);

        System.out.println("\nСравнение товаров:");
        System.out.println("Первый и второй: "
                + smartphone.equals(sameSmartphone)); // true
        System.out.println("Первый и третий: "
                + smartphone.equals(headphones)); // false
        System.out.println("Второй и третий: "
                + sameSmartphone.equals(headphones)); // false
        System.out.println("Товары с null в строковых полях: "
                + unknownProduct.equals(sameUnknownProduct)); // true
        System.out.println("Товар и null: "
                + smartphone.equals(null)); // false

        Order firstOrder = new Order(
                "Анна",
                new Product[]{smartphone, headphones}
        );
        Order secondOrder = new Order(
                "Анна",
                new Product[]{sameSmartphone, headphones}
        );
        Order reversedOrder = new Order(
                "Анна",
                new Product[]{headphones, smartphone}
        );
        Order otherCustomerOrder = new Order(
                "Иван",
                new Product[]{smartphone, headphones}
        );
        Order orderWithNull = new Order(
                null,
                new Product[]{smartphone, null}
        );
        Order sameOrderWithNull = new Order(
                null,
                new Product[]{sameSmartphone, null}
        );

        System.out.println("\nЗаказы:");
        System.out.println(firstOrder);
        System.out.println(secondOrder);
        System.out.println(reversedOrder);
        System.out.println(otherCustomerOrder);
        System.out.println(orderWithNull);
        System.out.println(sameOrderWithNull);

        System.out.println("\nСравнение заказов:");
        System.out.println("Первый и второй: "
                + firstOrder.equals(secondOrder)); // true
        System.out.println("Первый и третий: "
                + firstOrder.equals(reversedOrder)); // false
        System.out.println("Второй и третий: "
                + secondOrder.equals(reversedOrder)); // false
        System.out.println("Разные покупатели: "
                + firstOrder.equals(otherCustomerOrder)); // false
        System.out.println("Заказы с null: "
                + orderWithNull.equals(sameOrderWithNull)); // true
        System.out.println("Заказ и null: "
                + firstOrder.equals(null)); // false
    }
}