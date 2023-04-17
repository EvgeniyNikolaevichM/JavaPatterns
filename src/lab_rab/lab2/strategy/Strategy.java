package lab_rab.lab2.strategy;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

//Определяет ряд алгоритмов, которые позволяют взаимодействовать между объектами
//Есть 2 вида обработчика Dom и Sax
//Dom-строит дерево (Есть корневой объект)
//Sax-идет по событиям
//В параметрах задаются: STRATEGY.xml STRATEGYRes.xml
public interface Strategy {
    void analyze() throws ParserConfigurationException, XMLStreamException, SAXException, IOException;
}
