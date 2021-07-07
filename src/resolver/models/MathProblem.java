package resolver.models;

import java.util.Map;

public abstract class MathProblem {
    /**
     * Ищет все неабстрактные классы-наследники {@link MathProblem}
     */
    public static Class<MathProblem>[] searchAllClasses() {
        // TODO: replace with reflection
        return new Class[]{
                Sum.class,
                Mult.class,
                KvUr.class
        };
    }

    public abstract Map<String,Object> calculate(Map<String,Object> inputData);
}
