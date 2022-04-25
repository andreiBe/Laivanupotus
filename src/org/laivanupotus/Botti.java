package org.laivanupotus;

import org.laivanupotus.pelijarjestelma.Lauta;
import org.laivanupotus.pelijarjestelma.VihollisenLauta;

public interface Botti {
    void vuoro(VihollisenLauta lauta);
    void laitaLaivatPaikalleen(Lauta omaLauta);
    String getName();
    void reset();
}
