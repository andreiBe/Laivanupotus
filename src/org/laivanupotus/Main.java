package org.laivanupotus;

import org.laivanupotus.pelijarjestelma.PeliJarjestaja;
import org.laivanupotus.pelijarjestelma.enums.PeliTulos;

import java.util.ArrayList;

public class Main {
    private static final int MAARA = 100;

    public static void main(String[] args) {
        Botti bot1 = new OmaBot();
        Botti bot2 = new EsimerkkiBot();
        PeliJarjestaja jarjestaja = new PeliJarjestaja(bot1,bot2);
        ArrayList<PeliTulos> tulos = jarjestaja.pelaaXPelia(MAARA);
        int omanBotinVoitot = 0;
        int tokaVoitot = 0;

        for (PeliTulos t : tulos) {
            if (t == PeliTulos.EKAVOITTI) {
                omanBotinVoitot++;
            }
            else if (t == PeliTulos.TOKAVOITTI) {
                tokaVoitot++;
            }
        }
        String printattava;
        if (omanBotinVoitot == tokaVoitot) {
            printattava = "Tasapeli ";
        } else {
            printattava = omanBotinVoitot > tokaVoitot ? "Voitit " : "Hävisit ";
        }
        System.out.println(printattava + " " + omanBotinVoitot + " - " + tokaVoitot
        +" Tasapelit: " + (MAARA - omanBotinVoitot - tokaVoitot));

    }
}
