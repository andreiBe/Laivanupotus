package org.laivanupotus;

import org.laivanupotus.pelijarjestelma.Lauta;
import org.laivanupotus.pelijarjestelma.Ruutu;
import org.laivanupotus.pelijarjestelma.enums.Suunta;
import org.laivanupotus.pelijarjestelma.VihollisenLauta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EsimerkkiBot implements Botti {
    private final List<Ruutu> ammutut = new ArrayList<>();

    @Override
    public void vuoro(VihollisenLauta lauta) {
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        while (ammutut.contains(new Ruutu(x, y))) {
            x = random.nextInt(10);
            y = random.nextInt(10);
        }
        lauta.ammu(x, y);
        ammutut.add(new Ruutu(x, y));
    }

    @Override
    public void laitaLaivatPaikalleen(Lauta omaLauta) {
        Random random = new Random();
        int[] laivat = new int[] {2,3,3,4,5};
        for (int laiva : laivat) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            while (!omaLauta.laitaLaiva(x,y, Suunta.OIKEA, laiva)) {
                x = random.nextInt(10);
                y = random.nextInt(10);
            }
        }
    }

    @Override
    public String getName() {
        return "EsimerkkiBot";
    }

    @Override
    public void reset() {

    }
}
