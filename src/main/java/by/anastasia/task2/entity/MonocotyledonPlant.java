package by.anastasia.task2.entity;

public class MonocotyledonPlant extends AbstractPlant {
    private boolean isFlowerForming;

    private MonocotyledonPlant() {
    }

    public boolean isFlowerForming() {
        return isFlowerForming;
    }

    public static MonocotyledonPlantBuilder newMonocotyledonPlantBuilder() {
        return new MonocotyledonPlant().new MonocotyledonPlantBuilder();
    }
    
    public class MonocotyledonPlantBuilder extends PlantBuilder {
        private MonocotyledonPlantBuilder() {
        }

        public MonocotyledonPlantBuilder setIsFlowerForming(boolean isFlowerForming) {
            MonocotyledonPlant.this.isFlowerForming = isFlowerForming;
            return this;
        }

        @Override
        public MonocotyledonPlant build() {
            return MonocotyledonPlant.this;
        }
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
