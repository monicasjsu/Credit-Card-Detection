package com.monica.creditcard.parsers;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class FileParserTest {

  private Path inputPath = Paths.get("src/test/resources/Sample.xml");
  private Path outputPath = Paths.get("src/test/resources/SampleOutput.xml");

  private FileParser jsonParser = new JsonParser(inputPath, outputPath);

  @Test
  public void testGetOutputFile() throws Exception {
    File outFile = jsonParser.getOrCreateOutputFile();
    assertTrue(outFile.exists());
  }

  @Test
  public void tesCreateOutputFile() throws Exception {
    Path outputPath = Paths.get("src/test/resources/SampleOutput1.xml");
    FileParser jsonParser = new JsonParser(inputPath, outputPath);

    File outFile = jsonParser.getOrCreateOutputFile();
    assertTrue(outFile.exists());
    outFile.deleteOnExit();
  }
}