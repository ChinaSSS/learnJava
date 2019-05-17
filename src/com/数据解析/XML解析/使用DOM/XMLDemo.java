package com.数据解析.XML解析.使用DOM;

//特点:
//1.基于树形结构
//2.一次性加载文本到内存中，可以随机访问，(同时耗内存) , 更适合web开发，灵活性强

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class XMLDemo {

    @Test
    public void parseXML_() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/数据解析/XML解析/person2.xml");
        Document doc = documentBuilder.parse(is);
        NodeList adress_list = doc.getElementsByTagName("linkman");
        System.out.println("一共有地址信息 "+adress_list.getLength()+" 个");
        Node node = null;
        NodeList chridList = null;
        for(int i=0;i<adress_list.getLength();i++){
            node = adress_list.item(i);
            //此方法获取的子节点 ，不仅包含子孙节点，还包含空格(text)
            chridList = node.getChildNodes();
            for(int j=0;j<chridList.getLength();j++){
                //此处要判断节点的名字以区分空格换行和孙子节点
                if(chridList.item(j).getNodeName().equals("name")){
                    System.out.println(chridList.item(j).getFirstChild().getNodeValue());
                }else if(chridList.item(j).getNodeName().equals("email")){
                    System.out.println(chridList.item(j).getFirstChild().getNodeValue());
                }
                }
            }
        }
    }