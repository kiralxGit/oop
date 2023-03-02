package calc;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator {
    private static Stack numbers = new Stack<Double>();
    private static Stack operations = new Stack<Character>();
    private static Map<Character, Integer> priority= new HashMap<>();

    private static String calculate(String equation){
        List<String> equation_list = parseEquation(equation);

        for (int i = 0; i < equation_list.size(); i++) {

            if (i == (equation_list.size() - 1)  && isDouble(equation_list.get(i))) {
                double temp = Double.parseDouble(equation_list.get(i));
                numbers.push(temp);
                while (numbers.size() > 1) compute();

            } else if (equation_list.get(i).toString().charAt(0) == '(' ||
                       equation_list.get(i).toString().charAt(0) == ')') {
                if (equation_list.get(i).toString().charAt(0) == '(') {
                    operations.push(equation_list.get(i));
                } else {
                    while(operations.peek().toString().charAt(0) != '(') compute();
                    operations.pop();
                }
            } else if (priority.containsKey(equation_list.get(i).charAt(0))) {
                if(operations.size() == 0) {
                    operations.push(equation_list.get(i));
                } else if (operations.peek().toString().charAt(0) == '(') {
                    operations.push(equation_list.get(i));
                } else {
                    while((operations.size() != 0) &&
                            (priority.get(operations.peek().toString().charAt(0)) >=
                                    priority.get(equation_list.get(i).toString().charAt(0)))){
                        compute();
                    }
                    operations.push(equation_list.get(i));
                }
            } else if ((i != (equation_list.size() - 1)) && isDouble(equation_list.get(i))) {
                double temp = Double.parseDouble(equation_list.get(i));
                numbers.push(temp);
            }
            while (i == equation_list.size() - 1 && numbers.size() > 1) compute();;
        }
        return numbers.pop().toString();
    }

    public static String getAnswer(String equation){
        String answer;
        equation = equation.substring(1)
                            .replaceAll("\s", "")
                            .replaceAll(",", "\\.");
        if(equation.startsWith("-")){
            equation = equation.replaceFirst("-","0-");
        }
        setPriority();
        try {
            answer = calculate(equation);
        } catch(Exception e) {
            answer = "Ошибка парсинга: " + e.toString();
            e.printStackTrace();
        }
        return answer;
    }

    private static List<String> parseEquation(String s){
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch(c){
                case('+'), ('-'), ('*'), ('/'), ('^'), ('('), (')'):
                    tokens.add("" + c);
                    i++;
                    continue;
                default:
                    if(Character.isDigit(c) || c == '.'){
                        StringBuilder sb = new StringBuilder();
                        while(Character.isDigit(c) || c == '.'){
                            sb.append(c);
                            i++;
                            if(i >= s.length()) break;
                            c = s.charAt(i);
                        }
                        tokens.add(sb.toString());
                    } else {
                        throw new RuntimeException();
                    }
            }
        }
        return tokens;
    }
    private static void setPriority(){
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('^', 3);
        priority.put('(', 0);
    }

    private static void compute(){
        if(numbers.size() > 1 && operations.size() > 0){
            char c = operations.pop().toString().charAt(0);
            double b = (double) numbers.pop();
            double a = (double) numbers.pop();
            double temp = 0.0;
            if (c == '*') temp = a * b;
            if (c == '/') {
                try {
                    temp = a / b;
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (c == '+') temp = a + b;
            if (c == '-') temp = a - b;
            if (c == '^') temp = pow(a, b);

            numbers.push(temp);
            }
        }

    private static double pow(double value, double powValue) {
        double result = 1.0;
        int pow = (int) powValue;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }
    private static boolean isDouble(String s){
        String pattern = "([0-9]*)(\\.([0-9]*)|)";
        return Pattern.matches(pattern, s);
    }
}

