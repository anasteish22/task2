package by.anastasia.task2.entity;

import java.time.LocalDate;

public class MonocotyledonPlant extends AbstractPlant {
    private boolean isFlowerForming;

    public MonocotyledonPlant() {
    }

    public MonocotyledonPlant(String id,
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
                              boolean isFlowerForming) {
        super(id, plantingDate, name, soil, origin, stemColor, leafColor, size, temperature, isPhotophilous, multiplying);
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MonocotyledonPlant that = (MonocotyledonPlant) o;

        return isFlowerForming == that.isFlowerForming;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isFlowerForming ? 1 : 0);
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
                ", isFlowerForming='" + isFlowerForming + '\'' +
                '}';
    }
}
