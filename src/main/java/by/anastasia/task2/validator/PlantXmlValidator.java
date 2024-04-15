package by.anastasia.task2.validator;

import by.anastasia.task2.exception.PlantException;

public interface PlantXmlValidator {
    boolean validateXml(String schemaName, String fileName) throws PlantException;
}
