package com.monica.creditcard;

import com.monica.creditcard.creditcard.CreditCardFactory;
import com.monica.creditcard.models.CardOutput;
import com.monica.creditcard.parsers.FileParser;
import com.monica.creditcard.parsers.FileParserFactory;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

/**
 * @author monica dommaraju
 */
public class Application {

    public static void main(String[] args) throws Exception {
        if (args == null || args.length ==0) {
            System.out.println("Invalid arguments."
                + "\nFirst argument should be a valid fully qualified path of input file. "
                + "\nSecond argument should be a valid fully qualified output path. If file doesn't exist, new file will be created."
                + "\nExample Usage: \njava -jar target/CreditCard-1.0-SNAPSHOT.jar /Users/monica/Desktop/Sample.csv /Users/monica/Desktop/SampleOutput.csv");
            return;
        }

        Path inputFilePath = getPath(args[0]);
        Path outputFilePath = getPath(args[1]);

        if (!FileParserFactory.hasValidExtensions(inputFilePath, outputFilePath)) {
            System.out.println("Invalid file types."
                + "\nSupported file types are .csv .xml .json"
                + "\nInput file and output files should be of same type."
                + "\nExample Usage: \njava -jar target/CreditCard-1.0-SNAPSHOT.jar /Users/monica/Desktop/Sample.csv /Users/monica/Desktop/SampleOutput.csv");
            return;
        }

        if (!fileExists(inputFilePath)) {
            System.out.println("Input file doesn't exist. Please check if file exists at " + inputFilePath);
            return;
        }

        FileParser parser = FileParserFactory.getParser(inputFilePath, outputFilePath);
        List<CardOutput> outputs = CreditCardFactory.validateCreditCards(parser.read());
        parser.write(outputs);
    }

    protected static boolean fileExists(Path path) {
        return path.toFile().exists();
    }

    protected static Path getPath(String path) {
        try{
            return Paths.get(path);
        } catch (InvalidPathException e) {
            System.out.println("Invalid Path : " + path);
            throw e;
        }
    }
}
