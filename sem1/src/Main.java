public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Soarer", "red",115, 1988, 1200,50500.00, 100);
        Car car2 = new Car("Noah", "silver",160, 2017, 1550,60100.00, 250);
        car1.start();
        car1.driveTo("Moscow");
        car2.driveTo("SPb");
        Fruit fr1 = new Fruit("tomato", "red", 20.00, 100.10);
        Fruit fr2 = new Fruit("pumpkin ", "orange", 80.00, 200.12);
        car1.addFruits(fr1);
        car1.addFruits(fr1);
        car1.addFruits(fr2);
        car2.addFruits(fr1);
        car2.addFruits(fr2);
        car2.addFruits(fr2);
        car2.addFruits(fr2);
        System.out.println("Вес фруктов в машине " + car1.getModel() + ": " + car1.getWeightFruits());
        System.out.println("Вес фруктов в машине " + car2.getModel() + ": " +car2.getWeightFruits());

        race(1000, car1, car2);
    }
    static void race(Integer distance, Car car1, Car car2){
        car1.start();
        car2.start();
        System.out.println("Гонка началась!");
        double time1 = 0.0;
        double time2 = 0.0;
        double step = distance / 10;
        for (int i = 0, e = 1; i < distance; i+=step, e++) {
            double tempTime1 = car1.travelTime(step);
            time1 += tempTime1;
            double tempTime2 = car2.travelTime(step);
            time2 += tempTime2;
            if(tempTime1<tempTime2){
                System.out.printf("На этапе %d лидирует авто: %s\n", e, car1.getModel());
            } else if (tempTime2<tempTime1) {
                System.out.printf("На этапе %d лидирует авто: %s\n", e, car2.getModel());
            } else {
                System.out.printf("На этапе %d авто идут ноздря в ноздрю\n", e);
            }
        }

        System.out.printf("Общее время за гонку:\n\t%s = %.2f\n\t%s = %.2f\n", car1.getModel(), time1, car2.getModel(), time2);
        if(time1<time2){
            System.out.printf("Выигрывает авто: %s\n", car1.getModel());
        } else if (time2<time1) {
            System.out.printf("Выигрывает авто: %s\n", car2.getModel());
        } else {
            System.out.println("Ничья!");
        }
    }
}
