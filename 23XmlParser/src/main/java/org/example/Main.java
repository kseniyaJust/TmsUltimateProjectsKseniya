package org.example;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        parseSonnetFromFile("fileToParse.xml");
    }
    public static void parseSonnetFromFile(String xmlFilePath) {
        try {
            // xml parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parsing from file
            Document document = builder.parse(new File(xmlFilePath));
            document.getDocumentElement().normalize();

            // data for name of file from tags
            String firstName = getTagValue("firstName", document);
            String lastName = getTagValue("lastName", document);
            String title = getTagValue("title", document);

            // get all lines
            NodeList lineNodes = document.getElementsByTagName("line");
            StringBuilder linesContent = new StringBuilder();

            //append all lines, where every line starts from new str
            for (int i = 0; i < lineNodes.getLength(); i++) {
                String line = lineNodes.item(i).getTextContent();
                linesContent.append(line).append("\n");
            }

            // name of file
            String filename = firstName + "_" + lastName + "_" + title + ".txt";

            // write in file
            Files.write(Paths.get(filename), linesContent.toString().getBytes());

            System.out.println("Create file: " + filename);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getTagValue(String tagName, Document document) throws ParseException{
        NodeList nodeList = document.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        else{
            throw new ParseException("No tags found",0);
        }
    }
}