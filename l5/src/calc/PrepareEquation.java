package calc;

public class PrepareEquation {
    public static String prepare(String equation){
        equation = equation.substring(1)
                .replaceAll("\s", "")
                .replaceAll(",", "\\.");

        if(equation.startsWith("-")) equation = equation.replaceFirst("-","0-");

        return equation;
    }
}
