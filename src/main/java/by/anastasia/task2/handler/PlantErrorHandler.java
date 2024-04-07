package by.anastasia.task2.handler;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class PlantErrorHandler implements ErrorHandler {
    final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        LOGGER.log(Level.WARN, getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        LOGGER.log(Level.ERROR, getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        LOGGER.log(Level.FATAL, getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    private String getLineColumnNumber(SAXParseException exception) {
        return exception.getLineNumber() + " : " + exception.getColumnNumber();
    }
}
