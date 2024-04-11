package by.anastasia.task2.entity;

import java.time.LocalDate;

public abstract class AbstractPlant {
    private String id;
    private LocalDate plantingDate;
    private String name;
    private String soil;

    private String origin;
    private String stemColor;
    private String leafColor;
    private int size;
    private int temperature;
    private boolean isPhotophilous;
    private String multiplying;

    protected AbstractPlant() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPlantingDate() {
        return plantingDate;
    }

    public String getSoil() {
        return soil;
    }

    public String getOrigin() {
        return origin;
    }

    public String getStemColor() {
        return stemColor;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public int getSize() {
        return size;
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean isPhotophilous() {
        return isPhotophilous;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public abstract class PlantBuilder {
        protected PlantBuilder() {
        }

        public PlantBuilder setId(String id) {
            AbstractPlant.this.id = id;
            return this;
        }

        public PlantBuilder setPlantingDate(LocalDate plantingDate) {
            AbstractPlant.this.plantingDate = plantingDate;
            return this;
        }

        public PlantBuilder setName(String name) {
            AbstractPlant.this.name = name;
            return this;
        }

        public PlantBuilder setSoil(String soil) {
            AbstractPlant.this.soil = soil;
            return this;
        }

        public PlantBuilder setOrigin(String origin) {
            AbstractPlant.this.origin = origin;
            return this;
        }

        public PlantBuilder setStemColor(String stemColor) {
            AbstractPlant.this.stemColor = stemColor;
            return this;
        }

        public PlantBuilder setLeafColor(String leafColor) {
            AbstractPlant.this.leafColor = leafColor;
            return this;
        }

        public PlantBuilder setSize(int size) {
            AbstractPlant.this.size = size;
            return this;
        }

        public PlantBuilder setTemperature(int temperature) {
            AbstractPlant.this.temperature = temperature;
            return this;
        }

        public PlantBuilder setIsPhotophilous(boolean isPhotophilous) {
            AbstractPlant.this.isPhotophilous = isPhotophilous;
            return this;
        }

        public PlantBuilder setMultiplying(String multiplying) {
            AbstractPlant.this.multiplying = multiplying;
            return this;
        }

        public AbstractPlant build() {
            return AbstractPlant.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPlant abstractPlant = (AbstractPlant) o;

        if (size != abstractPlant.size) return false;
        if (temperature != abstractPlant.temperature) return false;
        if (isPhotophilous != abstractPlant.isPhotophilous) return false;
        if (id != null ? !id.equals(abstractPlant.id) : abstractPlant.id != null) return false;
        if (plantingDate != null ? !plantingDate.equals(abstractPlant.plantingDate) : abstractPlant.plantingDate != null) return false;
        if (name != null ? !name.equals(abstractPlant.name) : abstractPlant.name != null) return false;
        if (soil != null ? !soil.equals(abstractPlant.soil) : abstractPlant.soil != null) return false;
        if (origin != null ? !origin.equals(abstractPlant.origin) : abstractPlant.origin != null) return false;
        if (stemColor != null ? !stemColor.equals(abstractPlant.stemColor) : abstractPlant.stemColor != null) return false;
        if (leafColor != null ? !leafColor.equals(abstractPlant.leafColor) : abstractPlant.leafColor != null) return false;
        return (multiplying != null ? !multiplying.equals(abstractPlant.multiplying) : abstractPlant.multiplying != null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (plantingDate != null ? plantingDate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (soil != null ? soil.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (stemColor != null ? stemColor.hashCode() : 0);
        result = 31 * result + (leafColor != null ? leafColor.hashCode() : 0);
        result = 31 * result + size;
        result = 31 * result + temperature;
        result = 31 * result + (isPhotophilous ? 1 : 0);
        result = 31 * result + (multiplying != null ? multiplying.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", soil='" + soil + '\'' +
                ", plantingDate='" +  plantingDate + '\'' +
                ", origin='" + origin + '\'' +
                ", stemColor='" + stemColor + '\'' +
                ", leafColor='" + leafColor + '\'' +
                ", size=" + size +
                ", temperature=" + temperature +
                ", isPhotophilous=" + isPhotophilous +
                ", multiplying='" + multiplying + '\'' +
                '}';
    }
}
