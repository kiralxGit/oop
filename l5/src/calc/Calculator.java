package calc;

public class Calculator implements ICalculator{

    public static String getAnswer(String equation) {
        String answer;
        Calculate calculate = new Calculate();
        equation = PrepareEquation.prepare(equation);
        try {
            answer = calculate.calculate(equation);
        } catch (Exception e) {
            answer = "Ошибка парсинга: " + e.toString();
            e.printStackTrace();
        }
        return answer;
    }


}

