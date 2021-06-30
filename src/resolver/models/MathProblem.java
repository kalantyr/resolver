package resolver.models;

public abstract class MathProblem {
    /**
     * Ищет все неабстрактные классы-наследники {@link MathProblem}
     */
    public static Class<MathProblem>[] searchAllClasses() {
        // TODO: replace with reflection
        return new Class[]{
                Sum.class,
                Mult.class
        };
    }

    public abstract void calculate();
}
