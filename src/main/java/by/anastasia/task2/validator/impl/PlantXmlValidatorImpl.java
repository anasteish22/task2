package by.anastasia.task2.validator.impl;

import by.anastasia.task2.exception.PlantException;
import by.anastasia.task2.handler.PlantErrorHandler;
import by.anastasia.task2.validator.PlantXmlValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class PlantXmlValidatorImpl implements PlantXmlValidator {
    static final Logger LOGGER = LogManager.getLogger();
    private static String SCHEMA_NAME = "plants.xsd";
    private static String FILE_NAME = "plants.xml";
    private static String language = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;

    private static PlantXmlValidatorImpl instance = new PlantXmlValidatorImpl();

    private PlantXmlValidatorImpl() {
    }

    public static PlantXmlValidatorImpl getInstance() {
        return instance;
    }

    public boolean validateXml() throws PlantException {
        File schemaLocation = new File(SCHEMA_NAME);
        SchemaFactory factory = SchemaFactory.newInstance(language);
        Schema schema = null;
        Source source = new StreamSource(FILE_NAME);
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new PlantErrorHandler());
        try {
            schema = factory.newSchema(schemaLocation);
            validator.validate(source);
        } catch (SAXException e) {
            LOGGER.log(Level.WARN, "File is not valid: " + FILE_NAME);
            return false;
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Invalid file path: " + SCHEMA_NAME);
            throw new PlantException("Invalid file path: " + SCHEMA_NAME);
        }
        LOGGER.log(Level.INFO, "File is valid: " + FILE_NAME);
        return true;
    }
}
