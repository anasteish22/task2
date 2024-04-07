package by.anastasia.task2.entity;

import java.util.Locale;
import java.util.Objects;

public class DicotyledonPlant extends Plant {
    private String calyxType;

    private DicotyledonPlant() {
    }

    public String getCalyxType() {
        return calyxType;
    }

    public static DicotyledonPlantBuilder newDicotyledonPlantBuilder() {
        return new DicotyledonPlant().new DicotyledonPlantBuilder();
    }

    public class DicotyledonPlantBuilder extends PlantBuilder {
        private DicotyledonPlantBuilder() {
        }

        public DicotyledonPlantBuilder setCalyxType(String calyxType) {
            DicotyledonPlant.this.calyxType = calyxType;
            return this;
        }

        @Override
        public DicotyledonPlant build() {
            return DicotyledonPlant.this;
        }
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

