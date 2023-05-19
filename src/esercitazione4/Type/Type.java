package esercitazione4.Type;

import java.util.Set;

public interface Type {
    /* Basic Types */
    public static final String INT = "integer";
    public static final String BOOL = "bool";
    public static final String REAL = "real";
    public static final String STRING = "string";
    public static final String CHAR = "char";
    public static final Set<String> basicTypes = Set.of (
            INT,
            BOOL,
            REAL,
            STRING,
            CHAR
    );

    /* Altri Types */
    public static final String VAR = "var";
    public static final String VOID = "void";
    public static final String ERROR = "error";
    public static final String NOTYPE = "notype";
    public static final String OUT = "out";

}
