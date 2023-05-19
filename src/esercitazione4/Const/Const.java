package esercitazione4.Const;

import java.util.Set;

public interface Const {
    public static final String INTEGER_CONST = "integerCons";
    public static final String BOOL_CONST = "boolCons";
    public static final String REAL_CONST = "realCons";
    public static final String TRUE_CONST = "trueCons";
    public static final String FALSE_CONST = "falseCons";
    public static final String STRING_CONST = "stringCons";
    public static final String CHAR_CONST = "charCons";
    public static final Set<String> basicConst = Set.of (
            INTEGER_CONST,
            BOOL_CONST,
            REAL_CONST,
            TRUE_CONST,
            FALSE_CONST,
            STRING_CONST,
            CHAR_CONST
    );
}
