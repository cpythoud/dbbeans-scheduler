package org.dbbeans.scheduler;

public class Version {

    private static final String  PREFIX  = "";
    private static final int     MAJOR   = 0;
    private static final int     MINOR   = 1;
    private static final int     PATCH   = 0;
    private static final String  POSTFIX = "-alpha";

    private static final String VERSION = PREFIX + MAJOR + "." + MINOR + "." + PATCH + POSTFIX;

    /**
     * @return the version number of this library
     */
    public static String get() {
        return VERSION;
    }

    /**
     * To be used in build scripts.
     */
    public static void main (String[] args) {
        System.out.println(get());
    }
}
