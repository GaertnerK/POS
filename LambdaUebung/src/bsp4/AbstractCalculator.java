package bsp4;

public abstract class AbstractCalculator {
    protected CalculationOperation add;
    protected CalculationOperation subtract;
    protected CalculationOperation multiply;
    protected CalculationOperation divide;

    public AbstractCalculator() {}

    public AbstractCalculator(CalculationOperation add, CalculationOperation divide, CalculationOperation multiply, CalculationOperation subtract) {
        this.add = add;
        this.divide = divide;
        this.multiply = multiply;
        this.subtract = subtract;
    }
    public abstract Number add(Number a, Number b);
    public abstract Number subtract(Number a, Number b);
    public abstract Number multiply(Number a, Number b);
    public abstract Number divide(Number a, Number b);
}
