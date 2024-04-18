package by.anastasia.task2.builder;

import by.anastasia.task2.entity.AbstractPlant;
import by.anastasia.task2.exception.PlantException;
import by.anastasia.task2.handler.PlantErrorHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class PlantSaxBuilder {
    static final Logger LOGGER = LogManager.getLogger();
    private Set<AbstractPlant> plants;
    private PlantHandler handler = new PlantHandler();
    private XMLReader reader;

    public PlantSaxBuilder() throws PlantException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
            reader.setErrorHandler(new PlantErrorHandler());
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException | SAXException e) {
            LOGGER.log(Level.ERROR, "Failed configuration: PlantDomBuilder");
            throw new PlantException("Failed configuration: PlantDomBuilder");
        }
    }

    public Set<AbstractPlant> getPlants() {
        return plants;
    }

    public void buildSetPlants(String filename) throws PlantException {
        try {
            reader.parse(filename);
            plants = handler.getPlants();
        } catch (IOException | SAXException e) {
            throw new PlantException("Failed parsing: " + filename);
        }
    }
}
