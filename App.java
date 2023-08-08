package vanar.projects.source;

import java.io.IOException;

import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import vanar.projects.source.BNMSource.BNMSource;
import vanar.projects.source.BNMSource.Valute;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ParserConfigurationException, SAXException
    {
        System.out.println( "Hello World!" );
    

        BNMSource bnms = new BNMSource();

        Map<String, Valute> currencies = bnms.getData("01.08.2023");
        currencies = bnms.getData("02.08.2023");
        currencies = bnms.getData("03.08.2023");
        currencies = bnms.getData("04.08.2023");
        
        



       for (String key : currencies.keySet()) {
        System.out.println(key + currencies.get(key));
       }

    }
}
