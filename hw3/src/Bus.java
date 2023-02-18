public class Bus extends RoadTransport{
    public Bus(String brand, String model, String color, String fuelType, int year, int crew, int passengers) {
        super(brand, model, color, fuelType, year);
        this.setCrew(crew);
        this.setPassengerCapacity(passengers);
    }

    @Override
    public String toString() {
        return this.getBrand() + " " +
                this.getModel() + ", год выпуска: " +
                this.getYear() + ", экипаж " +
                this.getCrew() + ", вместимость пассажиров: " +
                this.getPassengerCapacity() + ".";
    }
}
