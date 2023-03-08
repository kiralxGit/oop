package calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calculate {
    private Stack numbers;
    private Stack operations;
    Priority priority;
    ICompute compute;

    public Calculate() {
        this.numbers = new Stack<Double>();
        this.operations = new Stack<Character>();
        this.priority = new Priority();
        compute = new AdapterCompute();
    }

    public String calculate(String equation) {
        List<String> equation_list = parseEquation(equation);

        for (int i = 0; i < equation_list.size(); i++) {

            if (i == (equation_list.size() - 1) && isDouble(equation_list.get(i))) {
                double temp = Double.parseDouble(equation_list.get(i));
                numbers.push(temp);
                while (numbers.size() > 1) compute();

            } else if (equation_list.get(i).toString().charAt(0) == '(' ||
                    equation_list.get(i).toString().charAt(0) == ')') {
                if (equation_list.get(i).toString().charAt(0) == '(') {
                    operations.push(equation_list.get(i));
                } else {
                    while (operations.peek().toString().charAt(0) != '(') compute();
                    operations.pop();
                }
            } else if (priority.containsKey(equation_list.get(i).charAt(0))) {
                if (operations.size() == 0) {
                    operations.push(equation_list.get(i));
                } else if (operations.peek().toString().charAt(0) == '(') {
                    operations.push(equation_list.get(i));
                } else {
                    while ((operations.size() != 0) &&
                            (priority.getPriority(operations.peek().toString().charAt(0)) >=
                                    priority.getPriority(equation_list.get(i).toString().charAt(0)))) {
                        compute();
                    }
                    operations.push(equation_list.get(i));
                }
            } else if ((i != (equation_list.size() - 1)) && isDouble(equation_list.get(i))) {
                double temp = Double.parseDouble(equation_list.get(i));
                numbers.push(temp);
            }
            while (i == equation_list.size() - 1 && numbers.size() > 1) compute();
            ;
        }
        return numbers.pop().toString();
    }

    private List<String> parseEquation(String s) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case ('+'), ('-'), ('*'), ('/'), ('^'), ('('), (')'):
                    tokens.add("" + c);
                    i++;
                    continue;
                default:
                    if (Character.isDigit(c) || c == '.') {
                        StringBuilder sb = new StringBuilder();
                        while (Character.isDigit(c) || c == '.') {
                            sb.append(c);
                            i++;
                            if (i >= s.length()) break;
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

    private void compute() {
        if (numbers.size() > 1 && operations.size() > 0) {
            char c = operations.pop().toString().charAt(0);
            double b = (double) numbers.pop();
            double a = (double) numbers.pop();
            double temp = 0.0;
            if (c == '*') temp = compute.mult(a, b);
            if (c == '/') temp = compute.div(a, b);
            if (c == '+') temp = compute.add(a, b);
            if (c == '-') temp = compute.sub(a, b);
            if (c == '^') temp = Math.pow(a, b);

            numbers.push(temp);
        }
    }

    private boolean isDouble(String s) {
        String pattern = "([0-9]*)(\\.([0-9]*)|)";
        return Pattern.matches(pattern, s);
    }
}
