package calc;

public class AdapterCompute extends BasicOperations implements ICompute {
    public double add(double a, double b){
        return addition(a, b);
    }
    public double sub(double a, double b){
        return subtraction(a, b);
    }
    public double mult(double a, double b){
        return multiplication(a, b);
    }
    public double div(double a, double b){
        return division(a, b);
    }
}
