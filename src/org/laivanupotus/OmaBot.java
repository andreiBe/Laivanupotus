package org.laivanupotus;

import org.laivanupotus.pelijarjestelma.Lauta;
import org.laivanupotus.pelijarjestelma.VihollisenLauta;
import org.laivanupotus.pelijarjestelma.enums.Suunta;

public class OmaBot implements Botti{
    //lauta.ammu(x,y)
    public void vuoro(VihollisenLauta lauta) {

    }
    //lauta.laitaLaiva(x,y,Suunta, koko)
    public void laitaLaivatPaikalleen(Lauta omaLauta) {
        //esim omaLauta.laitaLaiva(3,2, Suunta.OIKEA, 3);
    }
    public String getName() {
        return "laita nimi tähän";
    }
    //kutsutaan, kun uusi vuoro alkaa
    public void reset() {

    }
}