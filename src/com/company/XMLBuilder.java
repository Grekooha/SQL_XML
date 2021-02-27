package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XMLBuilder {

    private static Document getDocument () {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.newDocument();

        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void build() {

        Document document = getDocument();
        try {
            Transformer tran = TransformerFactory.newInstance().newTransformer();

            Element entries = document.createElement("entries");
            ArrayList<Integer> fieldArr = TableData.getField();
            for (int i : fieldArr) {
                Element entry = document.createElement("entry");
                Element field = document.createElement("field");
                org.w3c.dom.Text text = document.createTextNode(String.valueOf(i));
                entries.appendChild(entry);
                entry.appendChild(field);
                field.appendChild(text);
            }

            document.appendChild(entries);

            tran.setOutputProperty(OutputKeys.INDENT, "yes");
            tran.transform(new DOMSource(document), new StreamResult(new FileOutputStream("1.xml")));
        } catch (FileNotFoundException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void Xmlt() {
        try {
            TransformerFactory transformer = TransformerFactory.newInstance();
            Transformer t = transformer.newTransformer(new StreamSource(new File(".idea/2xslt.xsl")));
            Source text = new StreamSource(new File("1.xml"));
            t.transform(text, new StreamResult(new File("2.xml")));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}