package vlal.n4;

import java.util.Objects;

public class CalcImpl implements Calc {


    /**
     *
     * @param expression
     * @return
     * @throws NullPointerException when param is null
     */
    @Override
    public double calculate(String expression) throws NewException {
        Objects.requireNonNull(expression,"expression is null");
        if(expression.contains("sd")){
            throw new  NewException("expression contains 'sd'");
        }
        foo(expression);
        return 0;
    }

    private String foo(String expression) {
        return bar(expression);
    }

    private String bar(String expression) {
        return expression.toString();
    }
}
