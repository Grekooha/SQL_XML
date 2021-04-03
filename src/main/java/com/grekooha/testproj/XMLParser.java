package com.grekooha.testproj;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParser {
    public static ArrayList<Integer> parsingXML() {
        ArrayList<Integer> arrayField = new ArrayList<>();
        SAXParserFactory spf = SAXParserFactory.newDefaultInstance();

        try {
            SAXParser saxParser = spf.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    String value = attributes.getValue("field");
                    if (value != null && !value.isEmpty()) {
                        arrayField.add(Integer.valueOf(value));
                    }
                }
            };
            saxParser.parse(new File("2.xml"), handler);
            return arrayField;
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(arrayField);
            return arrayField;
        }
    }
    public static void sumField() {
        ArrayList<Integer> sumField = parsingXML();;
        int sum = 0;
        for (Integer integer : sumField) sum += integer;
        System.out.println(sum);
    }
}
