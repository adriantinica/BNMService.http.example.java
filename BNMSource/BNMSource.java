package vanar.projects.BNMSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DateFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class BNMSource {
    

    public final String endpoint = "https://bnm.md/ro/official_exchange_rates";
   
    
    public void getData() throws IOException, ParserConfigurationException, SAXException{

       // using HTTP request in JAVA
       // hw1: using JAVA classes, generate current data in this formay DD.MM.YYYY;

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String currentDate = localDate.format(dataFormat);
        //String currentDate = "06.08.2023";
        System.out.println(currentDate);

        String endpointWithParams = endpoint +  "?"+"get_xml=1"+ "&" + "date="+ currentDate;

        // ..link object
        URL url = new URL(endpointWithParams);

        
        //open the connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //open an input stream on this connection
        InputStream is = connection.getInputStream();

        byte[] data = is.readAllBytes();
        
        //for (byte b : data) {
        //    System.out.println(b);
        //};

        // get data as String....

        String xmlData = new String(data,"utf-8");
        //System.out.println(xmlData);
        
        //6.PARSE using a for loop just for EUR, USD and MDL;

        File file = new File(endpointWithParams);
        System.out.println(file.getAbsolutePath());
        List <Valute> valuteList = new ArrayList<Valute>();

        // DOM Parser/ + Factory & Builder & Singleton patterns

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(new InputSource(new StringReader(xmlData)));

        //###########   trabversing the DOM and extracting DATA    ######################################################

        System.out.println(document.getDoctype());
        System.out.println();

        Element root = document.getDocumentElement();

        NodeList valuteNodes = root.getElementsByTagName("Valute");

        for (int i = 0; i < valuteNodes.getLength(); i++) {
            
            Element valuteElement = (Element) valuteNodes.item(i);
            Integer id = Integer.parseInt(valuteElement.getAttribute("ID"));
            Integer numCode = Integer.parseInt(valuteElement.getElementsByTagName("NumCode").item(0).getTextContent());
            String charCode = valuteElement.getElementsByTagName("CharCode").item(0).getTextContent();
            Byte nominal = Byte.parseByte(valuteElement.getElementsByTagName("Nominal").item(0).getTextContent());
            String name = valuteElement.getElementsByTagName("Name").item(0).getTextContent();
            float value = Float.parseFloat(valuteElement.getElementsByTagName("Value").item(0).getTextContent());
            if( numCode == 978 || numCode == 840  || numCode == 946){
                valuteList.add(new Valute(id, numCode, charCode,nominal, new Currency(name, value)));
            }

            
            
        }

        System.out.println(valuteList);
            
        




    }

    
    
}
