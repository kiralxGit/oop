/**
 * Класс продукта для реализации в вендинговой машине
 */
public class Product {
    private String name;
    private double cost;

    /**
     * Конструктор
     * @param name наименование товара
     * @param cost уена товара
     */
    Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return (this.hashCode() == o.hashCode());
    }

    @Override
    public int hashCode() {
        //return (int) (this.name.hashCode() + (this.cost * 100));
        return (int) (this.name.hashCode());
    }

    @Override
    public String toString() {
        return (String) ("Продукт: " + this.name + ", цена: " + this.cost);
    }
}
