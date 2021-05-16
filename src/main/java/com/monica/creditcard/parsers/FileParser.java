package com.monica.creditcard.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;
import java.nio.file.Path;
import java.text.SimpleDateFormat;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author monica dommaraju
 */
public abstract class FileParser {
    public static final SimpleDateFormat DATE_FORMATTER =new SimpleDateFormat("MM/dd/yyyy");

    protected Path inputPath;
    protected Path outputPath;
    protected ObjectMapper mapper;

    public FileParser(Path inputPath, Path outputPath, ObjectMapper mapper) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.mapper = mapper;
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setDateFormat(DATE_FORMATTER);
    }

    public List<CardInput> read() throws Exception {
        File inputFile = inputPath.toFile();
        CardInput[] input = mapper.readValue(inputFile, CardInput[].class);
        return Arrays.asList(input);
    }

    public void write(List<CardOutput> output) throws Exception {
        mapper.writeValue(getOrCreateOutputFile(), output);
    }

    protected File getOrCreateOutputFile() throws Exception {
        File outputFile = outputPath.toFile();
        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }
        return outputFile;
    }
}
