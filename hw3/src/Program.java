import java.sql.SQLOutput;

public class Program {
    public static void main(String[] args) {
        Car car1 = new Car("Mercedes", "Viano", "Yellow", "diesel",2020);
        Car car2 = new Car("Fiat", "Bravo", "Blue", "gasoline",2011);
        Bus bus1 = new Bus("Man", "Lion’s City", "White", "diesel",2014, 2, 100);
        car1.driving("SPb");
        car2.setRunning();
        car2.driving("Moscow");
        bus1.setRunning();
        bus1.driving("Сочи");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(bus1);
    }
}
