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
                Diff.class,
                Mult.class,
                Pow.class,
                KvUr.class,
                Perc.class,
                Hypo.class,
                Pri.class,
                Comb.class,
                Mas.class,
                Bin.class
        };
    }

    public static double getValue(Map<String,String> inputData,String keyName, double defaultValue){
        var v = inputData.get(keyName);
        if (v==null)
            return defaultValue;
        else
            return Double.parseDouble(v);
    }

    public static double getValueOrThrow(Map<String,String> inputData,String keyName, String error) {
        var v = inputData.get(keyName);
        if (v==null)
            throw new RuntimeException(error);
        else
            return Double.parseDouble(v);
    }

    public abstract Map<String,String> calculate(Map<String,String> inputData);
}
