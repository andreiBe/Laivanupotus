package org.laivanupotus.pelijarjestelma.enums;

public enum Suunta {
    VASEN,OIKEA,ALAS,YLOS;

    public static int xdir(Suunta suunta) {
        if (suunta == VASEN) return -1;
        if (suunta == OIKEA) return 1;
        return 0;
    }

    public static int ydir(Suunta suunta) {
        if (suunta == YLOS) return -1;
        if (suunta == ALAS) return 1;
        return 0;
    }
}
