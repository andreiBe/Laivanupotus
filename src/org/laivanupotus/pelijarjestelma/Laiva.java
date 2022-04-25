package org.laivanupotus.pelijarjestelma;

import java.util.List;

public class Laiva {
    private final List<Ruutu> ruudut;

    public Laiva(List<Ruutu> ruudut) {
        this.ruudut = ruudut;
    }

    public boolean onUponnut() {
        for (Ruutu ruutu : ruudut) {
            if (!ruutu.onUponnut()) return false;
        }
        return true;
    }
}
