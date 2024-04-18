package by.anastasia.task2.builder;

public enum PlantXmlTag {
    PLANTS("plants"),
    DICOTYLEDON("dicotyledon"),
    MONOCOTYLEDON("monocotyledon"),
    PLANT_ID("plantId"),
    PLANTING_DATE("plantingDate"),
    NAME("name"),
    SOIL("soil"),
    ORIGIN("origin"),
    STEM_COLOR("stemColor"),
    LEAF_COLOR("leafColor"),
    SIZE("size"),
    TEMPERATURE("temperature"),
    PHOTOPHILOUS("photophilous"),
    MULTIPLYING("multiplying"),
    CALYX_TYPE("calyxType"),
    IS_FLOWER_FORMING("isFlowerForming");

    private String value;

    PlantXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
