package by.anastasia.task2.entity;

import java.util.Objects;

public class DicotyledonPlant extends Plant {
    private String calyxType;

    public DicotyledonPlant() {
    }

    public DicotyledonPlant(String id, String name, String soil, String origin, String stemColor, String leafColor, int size, int temperature, boolean isPhotophilous, String multiplying, String calyxType) {
        super(id, name, soil, origin, stemColor, leafColor, size, temperature, isPhotophilous, multiplying);
        this.calyxType = calyxType;
    }

    public String getCalyxType() {
        return calyxType;
    }

    public void setCalyxType(String calyxType) {
        this.calyxType = calyxType;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hashCode(calyxType);
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
                ", calyxType='" + calyxType + '\'' +
                '}';
    }
}
