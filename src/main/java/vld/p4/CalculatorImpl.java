package vld.p4;

import java.util.Objects;

public class CalculatorImpl implements Calculator {
    @Override
    public double calculate(String expression) throws EvaluationException {
        Objects.requireNonNull(expression,"expression is null");
        if(expression.contains("!")){
            throw new EvaluationException("Unsupported operator found");
        }
        return 0;
    }

}
