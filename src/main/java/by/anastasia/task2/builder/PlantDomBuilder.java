package by.anastasia.task2.builder;

import by.anastasia.task2.entity.AbstractPlant;
import by.anastasia.task2.entity.DicotyledonPlant;
import by.anastasia.task2.entity.MonocotyledonPlant;
import by.anastasia.task2.exception.PlantException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PlantDomBuilder {
    static final Logger LOGGER = LogManager.getLogger();
    private Set<AbstractPlant> plants;
    private DocumentBuilder documentBuilder;

    public PlantDomBuilder() throws PlantException {
        plants = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.log(Level.ERROR,"Failed configuration: PlantDomBuilder");
            throw new PlantException("Failed configuration: PlantDomBuilder");
        }
        LOGGER.log(Level.INFO, "Successful configuration: PlantDomBuilder");
    }

    public Set<AbstractPlant> getPlants() {
        return plants;
    }

    public void buildSetPlants(String filename) throws PlantException {
        Document document;
        try {
            document = documentBuilder.parse(filename);
            Element root = document.getDocumentElement();
            buildMonocotyledonPlants(root);
            buildDicotyledonPlants(root);
        } catch (SAXException | IOException e) {
            LOGGER.log(Level.ERROR, "Failed parsing: " + filename);
            throw new PlantException("Failed parsing: " + filename);
        }
    }

    public void buildMonocotyledonPlants(Element root) {
        NodeList monocotyledonList = root.getElementsByTagName("monocotyledon");

        for (int i = 0; i < monocotyledonList.getLength(); i++) {
            Element plantElement = (Element) monocotyledonList.item(i);
            MonocotyledonPlant plant = buildMonocotyledonPlant(plantElement);
            plants.add(plant);
        }
    }

    public void buildDicotyledonPlants(Element root) {
        NodeList dicotyledonList = root.getElementsByTagName("dicotyledon");

        for (int i = 0; i < dicotyledonList.getLength(); i++) {
            Element plantElement = (Element) dicotyledonList.item(i);
            DicotyledonPlant plant = buildDicotyledonPlant(plantElement);
            plants.add(plant);
        }
    }

    private MonocotyledonPlant buildMonocotyledonPlant(Element plantElement) {
        MonocotyledonPlant plant = (MonocotyledonPlant) MonocotyledonPlant.newMonocotyledonPlantBuilder()
                .setIsFlowerForming(Boolean.parseBoolean(getElementTextContent(plantElement, "isFlowerForming")))
                .setId(plantElement.getAttribute("plantId"))
                .setName(plantElement.getAttribute("name"))
                .setPlantingDate(LocalDate.parse(plantElement.getAttribute("plantingDate")))
                .setSoil(getElementTextContent(plantElement, "soil"))
                .setOrigin(getElementTextContent(plantElement, "origin"))
                .setStemColor(getElementTextContent(plantElement, "stemColor"))
                .setLeafColor(getElementTextContent(plantElement, "leafColor"))
                .setSize(Integer.parseInt(getElementTextContent(plantElement, "size")))
                .setTemperature(Integer.parseInt(getElementTextContent(plantElement, "temperature")))
                .setIsPhotophilous(Boolean.parseBoolean(getElementTextContent(plantElement, "photophilous")))
                .setMultiplying(getElementTextContent(plantElement, "multiplying"))
                .build();
        return plant;
    }

    private DicotyledonPlant buildDicotyledonPlant(Element plantElement) {
        DicotyledonPlant plant = (DicotyledonPlant) DicotyledonPlant.newDicotyledonPlantBuilder()
                .setCalyxType(getElementTextContent(plantElement, "calyxType"))
                .setId(plantElement.getAttribute("plantId"))
                .setName(plantElement.getAttribute("name"))
                .setPlantingDate(LocalDate.parse(plantElement.getAttribute("plantingDate")))
                .setSoil(getElementTextContent(plantElement, "soil"))
                .setOrigin(getElementTextContent(plantElement, "origin"))
                .setStemColor(getElementTextContent(plantElement, "stemColor"))
                .setLeafColor(getElementTextContent(plantElement, "leafColor"))
                .setSize(Integer.parseInt(getElementTextContent(plantElement, "size")))
                .setTemperature(Integer.parseInt(getElementTextContent(plantElement, "temperature")))
                .setIsPhotophilous(Boolean.parseBoolean(getElementTextContent(plantElement, "photophilous")))
                .setMultiplying(getElementTextContent(plantElement, "multiplying"))
                .build();
        return plant;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
