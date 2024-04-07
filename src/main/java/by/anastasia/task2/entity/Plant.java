package by.anastasia.task2.entity;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Plant {
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

    protected Plant() {
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
            Plant.this.id = id;
            return this;
        }

        public PlantBuilder setPlantingDate(LocalDate plantingDate) {
            Plant.this.plantingDate = plantingDate;
            return this;
        }

        public PlantBuilder setName(String name) {
            Plant.this.name = name;
            return this;
        }

        public PlantBuilder setSoil(String soil) {
            Plant.this.soil = soil;
            return this;
        }

        public PlantBuilder setOrigin(String origin) {
            Plant.this.origin = origin;
            return this;
        }

        public PlantBuilder setStemColor(String stemColor) {
            Plant.this.stemColor = stemColor;
            return this;
        }

        public PlantBuilder setLeafColor(String leafColor) {
            Plant.this.leafColor = leafColor;
            return this;
        }

        public PlantBuilder setSize(int size) {
            Plant.this.size = size;
            return this;
        }

        public PlantBuilder setTemperature(int temperature) {
            Plant.this.temperature = temperature;
            return this;
        }

        public PlantBuilder setIsPhotophilous(boolean isPhotophilous) {
            Plant.this.isPhotophilous = isPhotophilous;
            return this;
        }

        public PlantBuilder setMultiplying(String multiplying) {
            Plant.this.multiplying = multiplying;
            return this;
        }

        public Plant build() {
            return Plant.this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plant plant = (Plant) o;

        if (size != plant.size) return false;
        if (temperature != plant.temperature) return false;
        if (isPhotophilous != plant.isPhotophilous) return false;
        if (id != null ? !id.equals(plant.id) : plant.id != null) return false;
        if (plantingDate != null ? !plantingDate.equals(plant.plantingDate) : plant.plantingDate != null) return false;
        if (name != null ? !name.equals(plant.name) : plant.name != null) return false;
        if (soil != null ? !soil.equals(plant.soil) : plant.soil != null) return false;
        if (origin != null ? !origin.equals(plant.origin) : plant.origin != null) return false;
        if (stemColor != null ? !stemColor.equals(plant.stemColor) : plant.stemColor != null) return false;
        if (leafColor != null ? !leafColor.equals(plant.leafColor) : plant.leafColor != null) return false;
        return (multiplying != null ? !multiplying.equals(plant.multiplying) : plant.multiplying != null);
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
