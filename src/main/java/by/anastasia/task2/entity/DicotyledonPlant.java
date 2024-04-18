package by.anastasia.task2.entity;

import java.time.LocalDate;

public class DicotyledonPlant extends AbstractPlant {
    private String calyxType;

    public DicotyledonPlant() {
    }

    public DicotyledonPlant(String id,
                            LocalDate plantingDate,
                            String name,
                            String soil,
                            String origin,
                            String stemColor,
                            String leafColor,
                            int size,
                            int temperature,
                            boolean isPhotophilous,
                            String multiplying,
                            String calyxType) {
        super(id, plantingDate, name, soil, origin, stemColor, leafColor, size, temperature, isPhotophilous, multiplying);
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DicotyledonPlant plant = (DicotyledonPlant) o;

        return (calyxType != null ? !calyxType.equals(plant.calyxType) : plant.calyxType != null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (calyxType != null ? calyxType.hashCode() : 0);
        return result;
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

