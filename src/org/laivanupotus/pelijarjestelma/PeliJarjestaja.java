package org.laivanupotus.pelijarjestelma;

import org.laivanupotus.Botti;
import org.laivanupotus.pelijarjestelma.enums.PeliTulos;

import java.util.ArrayList;

public class PeliJarjestaja {
    private final Botti bot1;
    private final Botti bot2;

    public PeliJarjestaja(Botti botti1, Botti botti2) {
        this.bot1 = botti1;
        this.bot2 = botti2;
    }
    public ArrayList<PeliTulos> pelaaXPelia(int maara) {
        ArrayList<PeliTulos> tulokset = new ArrayList<>();
        for (int i = 0; i < maara; i++) {
            bot1.reset(); bot2.reset();
            PeliTulos tulos = pelaa();
            tulokset.add(tulos);
        }
        return tulokset;
    }
    private PeliTulos pelaa() {
        Lauta lauta1 = new Lauta();
        Lauta lauta2 = new Lauta();
        bot1.reset();
        bot2.reset();
        bot1.laitaLaivatPaikalleen(lauta1);
        bot2.laitaLaivatPaikalleen(lauta2);
        boolean laivatLaitettu1 = lauta1.laivatPaikallaan();
        boolean laivatLaitettu2 = lauta2.laivatPaikallaan();

        PeliTulos laivatLaitettu = getPeliTulos(laivatLaitettu1,laivatLaitettu2);
        if (laivatLaitettu != PeliTulos.PELIKESKEN) return laivatLaitettu;

        for (int vuoroja = 0; vuoroja < 100; vuoroja++) {
            bot1.vuoro(new VihollisenLauta(lauta2));
            bot2.vuoro(new VihollisenLauta(lauta1));

            boolean tuhottu1 = lauta1.kaikkiLaivatUpotettu();
            boolean tuhottu2 = lauta2.kaikkiLaivatUpotettu();

            PeliTulos laivatTuhottu = getPeliTulos(!tuhottu1,!tuhottu2);
            if (laivatTuhottu != PeliTulos.PELIKESKEN) return laivatTuhottu;
        }
        return PeliTulos.TASAPELI;
    }
    private PeliTulos getPeliTulos(boolean eka, boolean toka) {
        if (!eka && !toka) return PeliTulos.TASAPELI;
        if (!eka) return PeliTulos.TOKAVOITTI;
        if (!toka) return PeliTulos.EKAVOITTI;
        return PeliTulos.PELIKESKEN;
    }
}
