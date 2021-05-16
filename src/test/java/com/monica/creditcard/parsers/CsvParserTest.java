package com.monica.creditcard.parsers;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.monica.creditcard.creditcard.CreditCardFactory;
import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.After;
import org.junit.Test;

public class CsvParserTest {
  private Path inputPath = Paths.get("src/test/resources/Sample.csv");
  private Path outputPath = Paths.get("src/test/resources/Output.csv");

  private Path expectedOutputPath = Paths.get("src/test/resources/SampleOutput.csv");

  private CsvParser csvParser = new CsvParser(inputPath, outputPath);
  private CsvMapper csvMapper = new CsvMapper();


  @After
  public void tearDown() {
    outputPath.toFile().deleteOnExit();
  }

  @Test
  public void testCsvIntegrationTest() throws Exception {
    List<CardInput> inputs = csvParser.read();
    List<CardOutput> outputs = CreditCardFactory.validateCreditCards(inputs);

    csvParser.write(outputs);

    List<CardOutput> output = read(outputPath);
    List<CardOutput> expectedOutput = read(expectedOutputPath);
    assertEquals(expectedOutput, output);
  }

  public List<CardOutput> read(Path inputPath) throws Exception {
    CsvSchema csvSchema = csvMapper.typedSchemaFor(CardOutput.class).withHeader();
    MappingIterator<CardOutput> iterator = csvMapper.readerFor(CardOutput.class)
        .with(csvSchema)
        .readValues(inputPath.toFile());
    return iterator.readAll();
  }
}