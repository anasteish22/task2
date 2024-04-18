package by.anastasia.task2.entity;

import java.time.LocalDate;
import java.util.StringJoiner;

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

    public AbstractPlant() {
    }

    public AbstractPlant(String id,
                         LocalDate plantingDate,
                         String name,
                         String soil,
                         String origin,
                         String stemColor,
                         String leafColor,
                         int size,
                         int temperature,
                         boolean isPhotophilous,
                         String multiplying) {
        this.id = id;
        this.plantingDate = plantingDate;
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.stemColor = stemColor;
        this.leafColor = leafColor;
        this.size = size;
        this.temperature = temperature;
        this.isPhotophilous = isPhotophilous;
        this.multiplying = multiplying;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(LocalDate plantingDate) {
        this.plantingDate = plantingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isPhotophilous() {
        return isPhotophilous;
    }

    public void setPhotophilous(boolean photophilous) {
        isPhotophilous = photophilous;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
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
