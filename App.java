package vanar.projects;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import vanar.projects.BNMSource.BNMSource;

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
        bnms.getData();

    }
}
