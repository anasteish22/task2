package by.anastasia.task2.builder;

import by.anastasia.task2.entity.AbstractPlant;
import by.anastasia.task2.entity.DicotyledonPlant;
import by.anastasia.task2.entity.MonocotyledonPlant;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class PlantHandler extends DefaultHandler {
    private Set<AbstractPlant> plants;
    private AbstractPlant currentPlant;
    private PlantXmlTag currentXmlTag;
    private EnumSet<PlantXmlTag> withText;

    public PlantHandler() {
        plants = new HashSet<>();
        withText = EnumSet.range(PlantXmlTag.SOIL, PlantXmlTag.ISFLOWERFORMING);
    }

    public Set<AbstractPlant> getPlants() {
        return plants;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String monocotyledonTag = PlantXmlTag.MONOCOTYLEDON.getValue();
        String dicotyledonTag = PlantXmlTag.DICOTYLEDON.getValue();

        if (monocotyledonTag.equals(qName) || dicotyledonTag.equals(qName)) {
            if (monocotyledonTag.equals(qName)) {
                currentPlant = new MonocotyledonPlant();
            } else if (dicotyledonTag.equals(qName)) {
                currentPlant = new DicotyledonPlant();
            }
            currentPlant.setId(attributes.getValue(PlantXmlTag.PLANTID.getValue()));
            currentPlant.setName(attributes.getValue(PlantXmlTag.NAME.getValue()));
            currentPlant.setPlantingDate(LocalDate.parse(attributes.getValue(PlantXmlTag.PLANTINGDATE.getValue())));
        } else {
            PlantXmlTag temp = PlantXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String monocotyledonTag = PlantXmlTag.MONOCOTYLEDON.getValue();
        String dicotyledonTag = PlantXmlTag.DICOTYLEDON.getValue();

        if (monocotyledonTag.equals(qName) || dicotyledonTag.equals(qName)) {
            plants.add(currentPlant);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();

        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case SOIL -> currentPlant.setSoil(data);
                case ORIGIN -> currentPlant.setOrigin(data);
                case STEMCOLOR -> currentPlant.setStemColor(data);
                case LEAFCOLOR -> currentPlant.setLeafColor(data);
                case SIZE -> currentPlant.setSize(Integer.parseInt(data));
                case TEMPERATURE -> currentPlant.setTemperature(Integer.parseInt(data));
                case PHOTOPHILOUS -> currentPlant.setPhotophilous(Boolean.parseBoolean(data));
                case MULTIPLYING -> currentPlant.setMultiplying(data);
                case CALYXTYPE -> {
                    DicotyledonPlant plant = (DicotyledonPlant) currentPlant;
                    plant.setCalyxType(data);
                }
                case ISFLOWERFORMING -> {
                    MonocotyledonPlant plant = (MonocotyledonPlant) currentPlant;
                    plant.setFlowerForming(Boolean.parseBoolean(data));
                }
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}
