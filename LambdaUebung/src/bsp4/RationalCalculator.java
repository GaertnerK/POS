package bsp4;

public class RationalCalculator extends AbstractCalculator{

    public RationalCalculator() {
        super((a, b) -> a.getA() + b.getA(),
                (a, b) -> new Number(a.getA() - b.getA(), 0),
                (a, b) -> new Number(a.getA() * b.getA(), 0),
                (a, b) -> new Number(a.getA() / b.getA(), 0));
    }

    @Override
    public Number add(Number a, Number b) {
        return add.calc(a, b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return null;
    }

    @Override
    public Number multiply(Number a, Number b) {
        return null;
    }

    @Override
    public Number divide(Number a, Number b) {
        return null;
    }
}
