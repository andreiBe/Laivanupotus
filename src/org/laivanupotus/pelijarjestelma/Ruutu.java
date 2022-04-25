package org.laivanupotus.pelijarjestelma;

import org.laivanupotus.pelijarjestelma.enums.AmpumisTulos;

import java.util.Objects;

public class Ruutu {
    private final int x,y;
    private Laiva laiva;
    private boolean uponnut = false;

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public AmpumisTulos ammu() {
        if (this.uponnut) return AmpumisTulos.JOAMMUTTU;
        this.uponnut = true;
        if (laiva == null) return AmpumisTulos.OHI;

        if (laiva.onUponnut()) return AmpumisTulos.UPPOSI;
        return AmpumisTulos.OSUI;
    }
    public boolean onUponnut() {
        return uponnut;
    }

    public void setLaiva(Laiva laiva) {
        this.laiva = laiva;
    }

    public boolean onLaiva() {
        return laiva != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ruutu ruutu = (Ruutu) o;
        return x == ruutu.x && y == ruutu.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
