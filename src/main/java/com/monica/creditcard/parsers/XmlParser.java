package com.monica.creditcard.parsers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.nio.file.Path;

/**
 * @author monica dommaraju
 */
public class XmlParser extends FileParser {
    public XmlParser(Path inputPath, Path outputPath) {
        super(inputPath, outputPath, new XmlMapper());
    }
}
