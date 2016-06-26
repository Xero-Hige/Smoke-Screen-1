package fi.uba.ar.fallas.inferencia;

import java.util.Locale;

/**
 * Copyright 2016
 * Gaston Martinez gaston.martinez.90@gmail.com
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses
 */
public class Mole {

    String molename;
    String shape;
    String border;
    boolean diameter;
    boolean itch;
    boolean relieve; //FIXME
    boolean solarExposure;
    String color;
    boolean changes;
    Mole(String name) {
        molename = name;
    }

    public void setMolename(String molename) {
        this.molename = molename;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public boolean isDiameter() {
        return diameter;
    }

    public void setDiameter(boolean diameter) {
        this.diameter = diameter;
    }

    public boolean isItch() {
        return itch;
    }

    public void setItch(boolean itch) {
        this.itch = itch;
    }

    public boolean isRelieve() {
        return relieve;
    }

    public void setRelieve(boolean relieve) {
        this.relieve = relieve;
    }

    public boolean isSolarExposure() {
        return solarExposure;
    }

    public void setSolarExposure(boolean solarExposure) {
        this.solarExposure = solarExposure;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isChanges() {
        return changes;
    }

    public void setChanges(boolean changes) {
        this.changes = changes;
    }

    public void showDiagnoses(String diagnose) {
        System.out.println(String.format(Locale.ENGLISH, "El lunar %s se diagnostica como un %s",
                molename, diagnose));
    }
}
