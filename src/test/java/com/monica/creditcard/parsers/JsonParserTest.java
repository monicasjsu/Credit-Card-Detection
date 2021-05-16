package com.monica.creditcard.parsers;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
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

public class JsonParserTest {
  private Path inputPath = Paths.get("src/test/resources/Sample.json");
  private Path outputPath = Paths.get("src/test/resources/Output.json");

  private Path expectedOutputPath = Paths.get("src/test/resources/SampleOutput.json");

  private JsonParser jsonParser = new JsonParser(inputPath, outputPath);
  private JsonMapper jsonMapper = new JsonMapper();

  @Before
  public void setUp() throws Exception {
    jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  @After
  public void tearDown() {
    outputPath.toFile().deleteOnExit();
  }

  @Test
  public void testJsonIntegrationTest() throws Exception {
    List<CardInput> inputs = jsonParser.read();
    List<CardOutput> outputs = CreditCardFactory.validateCreditCards(inputs);

    jsonParser.write(outputs);

    List<CardOutput> output = read(outputPath);
    List<CardOutput> expectedOutput = read(expectedOutputPath);
    assertEquals(expectedOutput, output);
  }

  public List<CardOutput> read(Path inputPath) throws Exception {
    CardOutput[] outputs = jsonMapper.readValue(inputPath.toFile(), CardOutput[].class);
    return Arrays.asList(outputs);
  }
}