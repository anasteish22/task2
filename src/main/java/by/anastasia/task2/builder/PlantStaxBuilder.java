package by.anastasia.task2.builder;

import by.anastasia.task2.entity.AbstractPlant;
import by.anastasia.task2.entity.DicotyledonPlant;
import by.anastasia.task2.entity.MonocotyledonPlant;
import by.anastasia.task2.exception.PlantException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PlantStaxBuilder {
    private Set<AbstractPlant> plants;
    private XMLInputFactory inputFactory;

    public PlantStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        plants = new HashSet<>();
    }

    public Set<AbstractPlant> getSetPlants() {
        return plants;
    }

    public void buildSetPlants(String filename) throws PlantException {
        XMLStreamReader reader;
        String name;

        try (FileInputStream inputStream = new FileInputStream(filename)) {
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasName()) {
                int type = reader.next();

                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();

                    if (name.equals(PlantXmlTag.MONOCOTYLEDON.getValue())) {
                        MonocotyledonPlant plant = new MonocotyledonPlant();
                        buildPlant(plant, reader);
                        plants.add(plant);
                    }

                    if (name.equals(PlantXmlTag.DICOTYLEDON.getValue())) {
                        DicotyledonPlant plant = new DicotyledonPlant();
                        buildPlant(plant, reader);
                        plants.add(plant);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            throw new PlantException("Failed reading file: " + filename);
        }
    }

    private AbstractPlant buildPlant(AbstractPlant plant, XMLStreamReader reader) throws PlantException, XMLStreamException {
        plant.setId(reader.getAttributeValue(null, PlantXmlTag.PLANTID.getValue()));
        plant.setName(reader.getAttributeValue(null, PlantXmlTag.NAME.getValue()));
        plant.setPlantingDate(LocalDate.parse(reader.getAttributeValue(null, PlantXmlTag.PLANTINGDATE.getValue())));

        String name;
        while (reader.hasNext()) {
            try {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT -> {
                        name = reader.getLocalName();
                        String data = getXMLText(reader);
                        switch (PlantXmlTag.valueOf(name.toUpperCase())) {
                            case SOIL -> plant.setSoil(data);
                            case ORIGIN -> plant.setOrigin(data);
                            case STEMCOLOR -> plant.setStemColor(data);
                            case LEAFCOLOR -> plant.setLeafColor(data);
                            case SIZE -> plant.setSize(Integer.parseInt(data));
                            case TEMPERATURE -> plant.setTemperature(Integer.parseInt(data));
                            case PHOTOPHILOUS -> plant.setPhotophilous(Boolean.parseBoolean(data));
                            case MULTIPLYING -> plant.setMultiplying(data);
                            case CALYXTYPE -> {
                                DicotyledonPlant dicotyledon = (DicotyledonPlant) plant;
                                dicotyledon.setCalyxType(data);
                            }
                            case ISFLOWERFORMING -> {
                                MonocotyledonPlant monocotyledon = (MonocotyledonPlant) plant;
                                monocotyledon.setFlowerForming(Boolean.parseBoolean(data));
                            }
                        }
                    }
                    case XMLStreamConstants.END_ELEMENT -> {
                        name = reader.getLocalName();
                        if (name.equals(PlantXmlTag.DICOTYLEDON.getValue()) || name.equals(PlantXmlTag.MONOCOTYLEDON.getValue())) {
                            return plant;
                        }
                    }
                }
            } catch (XMLStreamException e) {
                throw new PlantException("Error building Plant object");
            }
        }
        return plant;
    }
    private String getXMLText(XMLStreamReader reader) throws PlantException {
        String text = null;
        try {
            if (reader.hasNext()) {
                reader.next();
                text = reader.getText();
            }
        } catch (XMLStreamException e) {
            throw new PlantException("Unable to read xml");
        }
        return text;
    }
}
