public class Car extends RoadTransport{
    public Car(String brand, String model, String color, String fuelType, int year) {
        super(brand, model, color, fuelType, year);
    }

    public Car(String brand, String model, String color, String fuelType, int year, String roadType, int wheels) {
        super(brand, model, color, fuelType, year, roadType, wheels);
    }

    @Override
    public String toString() {
        return this.getBrand() + " " +
                this.getModel() + ", год выпуска: " +
                this.getYear() + ", цвет " +
                this.getColor() + ".";
    }
}
