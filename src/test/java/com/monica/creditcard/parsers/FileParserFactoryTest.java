package com.monica.creditcard.parsers;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class FileParserFactoryTest {

  @Test
  public void testXmlParser() throws Exception {
    Path inputPath = Paths.get("src/test/resources/Sample.xml");
    Path outputPath = Paths.get("src/test/resources/SampleOutput.xml");
    FileParser parser = FileParserFactory.getParser(inputPath, outputPath);
    assertTrue(parser instanceof XmlParser);
  }

  @Test
  public void testCsvParser() throws Exception {
    Path inputPath = Paths.get("src/test/resources/Sample.csv");
    Path outputPath = Paths.get("src/test/resources/SampleOutput.csv");
    FileParser parser = FileParserFactory.getParser(inputPath, outputPath);
    assertTrue(parser instanceof CsvParser);
  }

  @Test
  public void testJsonParser() throws Exception {
    Path inputPath = Paths.get("src/test/resources/Sample.json");
    Path outputPath = Paths.get("src/test/resources/SampleOutput.json");
    FileParser parser = FileParserFactory.getParser(inputPath, outputPath);
    assertTrue(parser instanceof JsonParser);
  }

  @Test(expected = Exception.class)
  public void testInvalidParser() throws Exception {
    Path inputPath = Paths.get("src/test/resources/Sample.text");
    Path outputPath = Paths.get("src/test/resources/SampleOutput.text");
    FileParserFactory.getParser(inputPath, outputPath);
  }

  @Test
  public void hasValidExtensions() {
    Path inputPath = Paths.get("src/test/resources/Sample.xml");
    Path outputPath = Paths.get("src/test/resources/SampleOutput.xml");
    assertTrue(FileParserFactory.hasValidExtensions(inputPath, outputPath));
  }

  @Test
  public void hasInValidExtensions() {
    Path inputPath = Paths.get("src/test/resources/Sample.xml");
    Path outputPath = Paths.get("src/test/resources/SampleOutput.json");
    assertFalse(FileParserFactory.hasValidExtensions(inputPath, outputPath));
  }
}