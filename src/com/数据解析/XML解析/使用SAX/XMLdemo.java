package com.数据解析.XML解析.使用SAX;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class XMLdemo {

    @Test
    public void saxParseXML() throws ParserConfigurationException, SAXException, IOException {
        //创建一个解析器工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //通过工厂创建解析器
       SAXParser saxParser = factory.newSAXParser();
        //创建处理器
        PersonHandler personHandler = new PersonHandler();
        //解析数据
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/数据解析/XML解析/person.xml");
        saxParser.parse(is,personHandler);
        //print
        List<Person> ll = personHandler.getPerson();
        for(Person p : ll){
            System.out.println(p);
        }
    }

}
