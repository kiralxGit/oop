public class Fruit {
    String name;
    String color;
    double weight;
    double price;

    public Fruit(String name, String color, double weight, double price){
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return '{' +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
