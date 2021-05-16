package com.monica.creditcard.parsers;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;
import java.nio.file.Path;
import java.util.List;

public class CsvParser extends FileParser {

  private CsvSchema inputCsvSchema;
  private CsvSchema outputCsvSchema;

  public CsvParser(Path inputPath, Path outputPath) {
    super(inputPath, outputPath, new CsvMapper());
    this.inputCsvSchema = ((CsvMapper) mapper).typedSchemaFor(CardInput.class).withHeader();
    this.outputCsvSchema = ((CsvMapper) mapper).typedSchemaFor(CardOutput.class).withHeader().withoutQuoteChar();
  }

  @Override
  public List<CardInput> read() throws Exception {
    MappingIterator<CardInput> iterator = mapper.readerFor(CardInput.class)
        .with(inputCsvSchema)
        .readValues(inputPath.toFile());
    return iterator.readAll();
  }

  @Override
  public void write(List<CardOutput> output) throws Exception {
    SequenceWriter sw = mapper.writerFor(CardOutput.class)
        .with(outputCsvSchema)
        .writeValues(getOrCreateOutputFile());
    sw.writeAll(output);
  }
}
