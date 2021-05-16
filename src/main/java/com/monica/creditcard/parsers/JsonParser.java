package com.monica.creditcard.parsers;

import com.fasterxml.jackson.databind.json.JsonMapper;
import java.nio.file.Path;

/**
 * @author monica dommaraju
 */
public class JsonParser extends FileParser {
    public JsonParser(Path inputPath, Path outputPath) {
        super(inputPath, outputPath, new JsonMapper());
    }
}
