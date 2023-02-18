public abstract class Transport {
    private String brand;
    private String model;
    private String color;
    private String fuelType;
    private int year;
    private int speedMax;
    private int crew;
    private int passengerCapacity;
    private int cargoCapacity;

    Transport(String brand, String model, String color, String fuelType, int year) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
        this.year = year;
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getYear() {
        return year;
    }

    public int getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(int speedMax) {
        this.speedMax = speedMax;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }
}
