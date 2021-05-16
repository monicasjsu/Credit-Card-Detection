package com.monica.creditcard.parsers;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.monica.creditcard.creditcard.CreditCardFactory;
import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XmlParserTest {
  private Path inputPath = Paths.get("src/test/resources/Sample.xml");
  private Path outputPath = Paths.get("src/test/resources/Output.Xml");

  private Path expectedOutputPath = Paths.get("src/test/resources/SampleOutput.xml");

  private XmlParser xmlParser = new XmlParser(inputPath, outputPath);
  private XmlMapper xmlMapper = new XmlMapper();

  @Before
  public void setUp() throws Exception {
    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  @After
  public void tearDown() {
    outputPath.toFile().deleteOnExit();
  }

  @Test
  public void testXmlIntegrationTest() throws Exception {
    List<CardInput> inputs = xmlParser.read();
    List<CardOutput> outputs = CreditCardFactory.validateCreditCards(inputs);

    xmlParser.write(outputs);

    List<CardOutput> output = read(outputPath);
    List<CardOutput> expectedOutput = read(expectedOutputPath);
    assertEquals(expectedOutput, output);
  }

  public List<CardOutput> read(Path inputPath) throws Exception {
    CardOutput[] outputs = xmlMapper.readValue(inputPath.toFile(), CardOutput[].class);
    return Arrays.asList(outputs);
  }
}