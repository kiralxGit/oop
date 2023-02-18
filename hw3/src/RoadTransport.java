public abstract class RoadTransport extends Transport {
    private String roadType;
    private int wheels;
    private double wheelSize;
    private boolean running;


    RoadTransport(String brand, String model, String color, String fuelType, int year) {
        super(brand, model, color, fuelType, year);
    }

    RoadTransport(String brand, String model, String color, String fuelType, int year, String roadType, int wheels) {
        this(brand, model, color, fuelType, year);
        this.roadType = roadType;
        this.wheels = wheels;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning() {
        if (this.isRunning()) {
            this.running = false;
        } else {
            this.running = true;
        }
    }

    private void start() {
        System.out.println("Начали движение...");
    }

    private void stop() {
        System.out.println("...Приехали");
    }

    public void driving(String location) {
        if (!(this.isRunning())) {
            System.out.println("Двигатель заглушен! Запустите двигатель!");
        } else {
            this.start();
            System.out.println(this.getBrand() + " " + this.getModel() + " едет к " + location);
            this.stop();
        }
    }
}
