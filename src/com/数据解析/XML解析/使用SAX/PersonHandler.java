package com.数据解析.XML解析.使用SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

//1.基于事件驱动
//2.顺序读取
//3.相对于dom来说灵活不够(不能任意读取)
//4.更适用于对性能要求较高的开发
//5.占用内存小，避免内存溢出

public class PersonHandler extends DefaultHandler {

    private List<Person> person = null;
    private Person p;
    private String tag;

    public List<Person> getPerson() {
        return person;
    }

    //文档开始时回调
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        //开始打开文档时调用
        p = new Person();
        person = new ArrayList<>();
    }

    //文档结束时回调
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析文档结束");
    }

    //元素开始时回调
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("person")) {
            p.setId(attributes.getValue("personid"));
            p = new Person();//重点，list里面存的时不同的对象，一个数据new 一个person
        }
        tag = qName;
    }

    //元素结束时回调
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("person")) {
            person.add(p);
        }
        tag = null;
    }

    //文本时回调
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tag != null) {
            switch (tag) {
                case "name":
                    p.setName(new String(ch,start,length));
                    break;
                case "address":
                    p.setAddress(new String(ch,start,length));
                    break;
                case "tel":
                    p.setTel(new String(ch,start,length));
                    break;
                case "grilfriend":
                    p.setHaveGirlFriend(new String(ch,start,length));
                    break;
                case "like":
                    p.setLike(new String(ch,start,length));
                    break;
            }
        }
    }
}
