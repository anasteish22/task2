package by.anastasia.task2.builder;

public enum PlantXmlTag {
    PLANTS("plants"),
    DICOTYLEDON("dicotyledon"),
    MONOCOTYLEDON("monocotyledon"),
    PLANTID("plantId"),
    PLANTINGDATE("plantingDate"),
    NAME("name"),
    SOIL("soil"),
    ORIGIN("origin"),
    STEMCOLOR("stemColor"),
    LEAFCOLOR("leafColor"),
    SIZE("size"),
    TEMPERATURE("temperature"),
    PHOTOPHILOUS("photophilous"),
    MULTIPLYING("multiplying"),
    CALYXTYPE("calyxType"),
    ISFLOWERFORMING("isFlowerForming");

    private String value;

    PlantXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
