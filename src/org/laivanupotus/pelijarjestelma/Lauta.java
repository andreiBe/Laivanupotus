package org.laivanupotus.pelijarjestelma;

import org.laivanupotus.pelijarjestelma.enums.AmpumisTulos;
import org.laivanupotus.pelijarjestelma.enums.Suunta;

import java.util.ArrayList;

public class Lauta {
    private final Ruutu[][] ruudut = new Ruutu[10][10];
    private final int[] laitettavatLaivat = new int[]{0, 0, 1, 2, 1, 1};
    private final ArrayList<Laiva> laivat = new ArrayList<>();

    public Lauta() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                ruudut[x][y] = new Ruutu(x, y);
            }
        }
    }

    public AmpumisTulos ammu(int x, int y) {
        if (x < 0 || y < 0 || x > 9 || y > 9) return AmpumisTulos.OHI;
        return ruudut[x][y].ammu();
    }

    public boolean kaikkiLaivatUpotettu() {
        for (Laiva laiva : this.laivat) {
            if (!laiva.onUponnut()) {
                return false;
            }
        }
        return true;
    }

    public boolean laitaLaiva(int x, int y, Suunta suunta, int koko) {
        if (x < 0 || y < 0 || x > 9 || y > 9 || suunta == null) return false;
        int xdir = Suunta.xdir(suunta);
        int ydir = Suunta.ydir(suunta);

        return laitaLaivaPaikalleenJosMahdollista(x, y, xdir, ydir, koko);
    }

    public boolean laivatPaikallaan() {
        for (int maara : this.laitettavatLaivat) {
            if (maara != 0) return false;
        }
        return true;
    }

    private boolean laitaLaivaPaikalleenJosMahdollista(int x, int y, int xdir, int ydir, int koko) {
        if (koko > 5 || koko < 0) return false;
        if (laitettavatLaivat[koko] - 1 < 0) return false;
        ArrayList<Ruutu> list = new ArrayList<>();

        for (int i = 0; i < koko; i++) {
            if (y >= 10 || x >= 10 || y < 0 || x < 0 || this.ruudut[y][x].onLaiva()) {
                return false;
            }

            list.add(ruudut[x][y]);
            x += xdir;
            y += ydir;
        }
        Laiva laiva = new Laiva(list);
        this.laivat.add(laiva);
        list.forEach(ruutu -> ruutu.setLaiva(laiva));

        laitettavatLaivat[koko]--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Ruutu[] ruutus : ruudut) {
            for (Ruutu ruutu : ruutus) {
                builder.append(ruutu.onUponnut() ? 1 : 0).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
