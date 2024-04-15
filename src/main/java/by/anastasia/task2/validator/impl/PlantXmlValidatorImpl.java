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
    private static final PlantXmlValidatorImpl instance = new PlantXmlValidatorImpl();

    private PlantXmlValidatorImpl() {
    }

    public static PlantXmlValidatorImpl getInstance() {
        return instance;
    }

    public boolean validateXml(String schemaName, String fileName) throws PlantException {
        File schemaLocation = new File(schemaName);
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
        Schema schema = null;
        Source source = new StreamSource(fileName);
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new PlantErrorHandler());
        try {
            schema = factory.newSchema(schemaLocation);
            validator.validate(source);
        } catch (SAXException e) {
            LOGGER.log(Level.WARN, "File is not valid: " + fileName);
            return false;
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "Invalid file path: " + schemaName);
            throw new PlantException("Invalid file path: " + schemaName);
        }
        LOGGER.log(Level.INFO, "File is valid: " + fileName);
        return true;
    }
}
