package org.laivanupotus;

import org.laivanupotus.pelijarjestelma.PeliJarjestaja;
import org.laivanupotus.pelijarjestelma.enums.PeliTulos;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Botti bot1 = new OmaBot();
        Botti bot2 = new EsimerkkiBot();
        PeliJarjestaja jarjestaja = new PeliJarjestaja(bot1,bot2);
        ArrayList<PeliTulos> tulos = jarjestaja.pelaaXPelia(100);
        System.out.println(tulos);
    }
}
