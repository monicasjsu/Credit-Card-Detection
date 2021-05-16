package com.monica.creditcard.parsers;

import java.nio.file.Path;

/**
 * @author monica dommaraju
 */
public class FileParserFactory {
    public static final String JSON_EXT = ".json";
    public static final String CSV_EXT = ".csv";
    public static final String XML_EXT = ".xml";

    public static FileParser getParser(Path inputPath, Path outputPath) throws Exception {
        String inputPathStr = inputPath.toString().toLowerCase();
        if (inputPathStr.endsWith(JSON_EXT)) {
            return new JsonParser(inputPath, outputPath);
        } else if (inputPathStr.endsWith(XML_EXT)) {
            return new XmlParser(inputPath, outputPath);
        } else if (inputPathStr.endsWith(CSV_EXT)) {
            return new CsvParser(inputPath, outputPath);
        }
        throw new Exception("File not supported");
    }

    public static boolean hasValidExtensions(Path inputPath, Path outputPath) {
        String inputPathStr = inputPath.toString().toLowerCase();
        String outputPathStr = outputPath.toString().toLowerCase();
        return (inputPathStr.endsWith(JSON_EXT) && outputPathStr.endsWith(JSON_EXT)) ||
            (inputPathStr.endsWith(XML_EXT) && outputPathStr.endsWith(XML_EXT)) ||
            (inputPathStr.endsWith(CSV_EXT) && outputPathStr.endsWith(CSV_EXT));
    }
}
