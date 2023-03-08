package calc;

public class BasicOperations implements IBasicOperations {

    @Override
    public double addition(double a, double b) {
        return a + b;
    }

    @Override
    public double subtraction(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double division(double a, double b) {
        double c = 0.0;
        try{
            c = a / b;
        } catch (ArithmeticException e){
            System.out.println("Деление на 0!");
        }
        return c;
    }
}
