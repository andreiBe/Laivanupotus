package org.laivanupotus;

import org.laivanupotus.pelijarjestelma.Lauta;
import org.laivanupotus.pelijarjestelma.VihollisenLauta;
import org.laivanupotus.pelijarjestelma.enums.Suunta;

public class OmaBot implements Botti{
    //kutsutaan aina kun on bottisi vuoro ampua toisen botin lautaa.
    //parametrina on olio, jolla on yksi metodi: ammu
    //metodille annetaan koordinaatit mihin botti ampuu
    // (0,0) on vasen yläkulma ja (9,9) on oikea alakulma

    //metodi palauttaa AmpumisTulos enum arvon, joka voi olla yksi näistä:
    // OSUI, UPPOSI, OHI, JOAMMUTTU, EIVUORO
    //lauta.ammu(x,y)
    public void vuoro(VihollisenLauta lauta) {

    }
    //kutsutaan, kun on bottisi vuoro laittaa omat laivat paikalleen
    //parametrina saa oman laudan, joka sisältää metodin laitaLaiva
    //metodille annetaan koordinaatit mistä laiva alkaa, suunta mihin laiva leviää ja laivan koko
    //esim laitaLaiva(3,2,Suunta.OIKEA,3) luo laivan, joka peittää ruudut (3,2) (4,2) (5,2)
    //laitaLaiva palauttaa boolean arvon, joka kertoo onnistuiko laivan laittaminen
    //mahdolliset suunnat: Suunta.VASEN, Suunta.OIKEA, Suunta.YLOS ja Suunta.ALAS

    //Laivat, jotka pitää laittaa laudalle tai pelin häviää:
    // 1 viiden laiva, 1 neljän laiva, 2 kolmen laivaa ja 1 kahden laiva
    // lauta.laitaLaiva(x,y,Suunta, koko)
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