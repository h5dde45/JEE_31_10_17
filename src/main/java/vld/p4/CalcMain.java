package vld.p4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalcMain {
    public static void main(String[] args) throws IOException, EvaluationException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("> ");
                String expr = reader.readLine();
                System.out.println(">> " + new CalculatorImpl().calculate(expr));
            }
        }
    }
}
