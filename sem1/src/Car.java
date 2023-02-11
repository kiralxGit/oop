import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Car {
    String model;
    String color;
    Integer year;
    Integer power;
    Integer weight;
    Integer maxCargoWeight;
    double price;
    private boolean engineOn;
    private List<Fruit> fruits;

    public Car(String model, String color, Integer power, Integer year, Integer weight, double price, Integer maxCargoWeight) {
        this.model = model;
        this.color = color;
        this.power = power;
        this.year = year;
        this.weight = weight;
        this.price = price;
        this.maxCargoWeight = maxCargoWeight;
        this.fruits = new ArrayList<>();
    }

    //    public Car (){
//    }
    public void start() {
        this.engineOn = true;
        System.out.println("Машина запущена!");
    }

    public void stop() {
        this.engineOn = false;
        System.out.println("Машина заглушена!");
    }

    public void driveTo(String location) {
        if (this.engineOn) {
            System.out.println("Наша машина " + this.model + " едет к " + location);
        } else {
            System.out.printf(model + " не поедет в %s! Машина не запущена :(\n", location);
        }
    }

    public void addFruits(Fruit fruit) {
        if ((this.getWeightFruits() + fruit.weight) <= this.maxCargoWeight) {
            this.fruits.add(fruit);
            System.out.printf("Фрукт %s добавлен в %s!\n", fruit.name, this.model);
        } else {
            System.out.printf("Фрукт %s не влез в %s!\n", fruit.name, this.model);
        }
    }

    public double getWeightFruits() {
        if (fruits.isEmpty()) return 0.00;
        double weightFruit = 0.00;
        for (int i = 0; i < this.fruits.size(); i++) {
            weightFruit += this.fruits.get(i).weight;
        }
        return weightFruit;
    }

    public List<Fruit> getFruits() {
        return this.fruits;
    }

    public double travelTime(double distance) {
        if (!engineOn) {
            System.out.println("Авто " + model + " не запущено!");
            return -1;
        }
        double totalWeight = this.weight + this.getWeightFruits();
        double speedMax = power / (totalWeight / 1000);
        //System.out.printf("макс. скорость %s: %.2f\n", model, speedMax);
        Random r = new Random();
        double badRoadCoefficient = (r.nextInt(20) + 80) / 100.00;
        //System.out.println("проблемы в дороге, коэффициент: " + badRoadCoefficient);
        return round(distance / (speedMax * badRoadCoefficient));
    }

    private double round(double d) {
        d *= 100;
        int i = (int) d;
        return (double) i / 100;
    }

    public void getInfo() {
        System.out.println("Авто {" +
                "модель='" + model + '\'' +
                ", мощность=" + power +
                ", цвет=" + color +
                ", вес=" + weight +
                ", цена=" + price +
                ", год=" + year +
                ", запущена=" + engineOn +
                ", вместимость=" + maxCargoWeight +
                ", заполнено=" + getWeightFruits() +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(year, car.year) && Objects.equals(power, car.power) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, year, power, price);
    }
}
