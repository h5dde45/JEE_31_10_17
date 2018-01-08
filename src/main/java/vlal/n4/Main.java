package vlal.n4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ){
            while (true) {
                System.out.println(">>");
                String expression = reader.readLine();
                System.out.println(">>");
                double calculate = new CalcImpl().calculate(expression);
                System.out.println(calculate);
            }
//            new CalcImpl().calculate(" ekkjefv  84whsd eteoi");
//            new CalcImpl().calculate(null);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
