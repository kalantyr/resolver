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

    public static double getValue(Map<String,String> inputData,String keyName, double defaultValue){
        var v = inputData.get(keyName);
        if (v==null)
            return defaultValue;
        else
            return Double.parseDouble(v);
    }

    public abstract Map<String,String> calculate(Map<String,String> inputData);
}
