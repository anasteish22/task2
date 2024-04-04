package by.anastasia.task2.entity;

import java.util.Objects;

public class MonocotyledonPlant extends Plant {
    private boolean isFlowerForming;

    public MonocotyledonPlant() {
    }

    public MonocotyledonPlant(String id, String name, String soil, String origin, String stemColor, String leafColor, int size, int temperature, boolean isPhotophilous, String multiplying, boolean isFlowerForming) {
        super(id, name, soil, origin, stemColor, leafColor, size, temperature, isPhotophilous, multiplying);
        this.isFlowerForming = isFlowerForming;
    }

    public boolean isFlowerForming() {
        return isFlowerForming;
    }

    public void setFlowerForming(boolean flowerForming) {
        isFlowerForming = flowerForming;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hashCode(isFlowerForming);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", soil='" + getSoil() + '\'' +
                ", origin='" + getOrigin() + '\'' +
                ", stemColor='" + getStemColor() + '\'' +
                ", leafColor='" + getLeafColor() + '\'' +
                ", size=" + getSize() +
                ", temperature=" + getTemperature() +
                ", isPhotophilous=" + isPhotophilous() +
                ", multiplying='" + getMultiplying() + '\'' +
                ", isFlowerForming='" + isFlowerForming + '\'' +
                '}';
    }
}
