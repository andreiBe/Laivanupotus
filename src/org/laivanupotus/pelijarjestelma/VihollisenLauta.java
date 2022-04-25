package org.laivanupotus.pelijarjestelma;

import org.laivanupotus.pelijarjestelma.enums.AmpumisTulos;

public class VihollisenLauta {
    private final Lauta lauta;
    private boolean onAmmuttu = false;

    public VihollisenLauta(Lauta lauta) {
        this.lauta = lauta;
    }

    public AmpumisTulos ammu(int x, int y) {
        if (onAmmuttu) return AmpumisTulos.EIVUORO;
        onAmmuttu = true;
        return lauta.ammu(x,y);
    }

    @Override
    public String toString() {
        return lauta.toString();
    }
}
