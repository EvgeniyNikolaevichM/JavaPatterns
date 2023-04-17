package lab_rab.lab2.strategy;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//DOM загружает всю стр xml(нагрузка на ЭВМ)

public class Dom implements Strategy{
    private String inputXml = "";
    private String resultXml = "";

    public Dom (String arg0, String arg1) {
        inputXml = arg0;
        resultXml = arg1;
    }

    private void getDomAverage() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputXml);//Создаем парс
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("student");//Получаем список элементов документа xml
            Node node = nodeList.item(0);
            NodeList children = node.getChildNodes();

            double sum = 0, count = 0, real, defaultAverage = 0.0;
            NamedNodeMap namedNodeMap;
            Node cur;

            for (int i = 0; i < children.getLength(); i++) {
                cur = children.item(i);
                namedNodeMap = cur.getAttributes();
                if (namedNodeMap != null && cur.getNodeName().equals("subject")) {
                    sum += Integer.parseInt(namedNodeMap.getNamedItem("mark").getNodeValue());// Здесь получаем оценку и прибавляем ее к сумме
                    System.out.println(namedNodeMap.getNamedItem("mark").getNodeValue() + " << Отметки | " +//которая раньше была равна 0 и увеличиваем дальше
                            namedNodeMap.getNamedItem("title").getNodeValue() + " << Предмет |");
                    count++;//количество для среднего арифметического
                }
                if (cur.getNodeName().equals("average")) {//Здесь считываем оценку по имени
                    Node n = cur.getFirstChild();
                    defaultAverage = Double.parseDouble(n.getNodeValue());//Не правильная оценка, которую считали
                }
            }
            System.out.println("Doc: " + defaultAverage);
            real = sum / count;
            System.out.println("Real: " + real);


            DOMSource source = new DOMSource((Node) document);
            if (real != defaultAverage) {//Если реальная оценка не совпадает с той, которая было задана в файле мы ее-сравнение
                nodeList = document.getElementsByTagName("average");
                Node average = nodeList.item(0).getFirstChild();
                average.setNodeValue(String.valueOf(real));//Изменяем оуенку
                System.out.println("result изменен");
            } else
                System.out.println("Значение верное");

            StreamResult result = new StreamResult(resultXml);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(source, result);//Здесь идет перезапись

            System.out.println("XML готов");
        } catch (SAXException | TransformerException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void analyze() throws IOException, SAXException {
        getDomAverage();
    }
}
    