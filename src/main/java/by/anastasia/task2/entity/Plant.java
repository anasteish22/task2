package by.anastasia.task2.entity;

import java.util.Objects;

public abstract class Plant {
    private String id;
    private String name;
    private String soil;

    private String origin;
    private String stemColor;
    private String leafColor;
    private int size;
    private int temperature;
    private boolean isPhotophilous;
    private String multiplying;

    public Plant() {
    }

    public Plant(String id, String name, String soil, String origin, String stemColor, String leafColor, int size, int temperature, boolean isPhotophilous, String multiplying) {
        this.id = id;
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
        Plant plant = (Plant) o;
        return size == plant.size && temperature == plant.temperature && isPhotophilous == plant.isPhotophilous && Objects.equals(id, plant.id) && Objects.equals(name, plant.name) && Objects.equals(soil, plant.soil) && Objects.equals(origin, plant.origin) && Objects.equals(stemColor, plant.stemColor) && Objects.equals(leafColor, plant.leafColor) && Objects.equals(multiplying, plant.multiplying);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, soil, origin, stemColor, leafColor, size, temperature, isPhotophilous, multiplying);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", soil='" + soil + '\'' +
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
