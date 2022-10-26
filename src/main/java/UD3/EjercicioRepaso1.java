package UD3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EjercicioRepaso1 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) {
        try {
            File archivo = new File("futbolistas.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document documento = db.parse(archivo);
            documento.getDocumentElement().normalize();
            
            System.out.println("****************************");
            System.out.println("Elemento Raíz: " + documento.getDocumentElement().getNodeName());
            NodeList lista = documento.getElementsByTagName("futbolista");
            System.out.println("****************************");
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("ID Futbolista: " + element.getAttribute("id"));
                    System.out.println("Nombre del Futbolista: " + element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Equipo del Futbolista: " + element.getElementsByTagName("equipo").item(0).getTextContent());
                    System.out.println("Goles del Futbolista: " + element.getElementsByTagName("goles").item(0).getTextContent());
                    System.out.println("****************************");
                }
            }
            añadirFutbolistas(documento);
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("ID Futbolista: " + element.getAttribute("id"));
                    System.out.println("Nombre del Futbolista: " + element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Equipo del Futbolista: " + element.getElementsByTagName("equipo").item(0).getTextContent());
                    System.out.println("Goles del Futbolista: " + element.getElementsByTagName("goles").item(0).getTextContent());
                    System.out.println("****************************");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void añadirFutbolistas(Document doc) throws TransformerException, IOException {
        doc.getDocumentElement().normalize();
        Node nodo = doc.getDocumentElement();
                
        int contador = 5;
        String id = String.valueOf(contador);
        for (int i = 1; i <= 5; i++) {
            Element futbolista = doc.createElement("futbolista");
            futbolista.setAttribute("id", id);
            
            
            System.out.println("Introduce el nombre del futbolista " + i + ": ");
            String nombre = br.readLine();
            
            System.out.println("Introduce el equipo del futbolista " + i + ": ");
            String equipo = br.readLine();
            
            System.out.println("Introduce los goles del futbolista " + i + ": ");
            String goles = br.readLine();
            
            Element nombreFutbolista = doc.createElement("nombre");
            nombreFutbolista.appendChild(doc.createTextNode(nombre));
            futbolista.appendChild(nombreFutbolista);
            
            Element equipoFutbolista = doc.createElement("equipo");
            equipoFutbolista.appendChild(doc.createTextNode(equipo));
            futbolista.appendChild(equipoFutbolista);
            
            Element golesFutbolista = doc.createElement("goles");
            golesFutbolista.appendChild(doc.createTextNode(goles));
            futbolista.appendChild(golesFutbolista);
            
            nodo.appendChild(futbolista);
            contador++;
            id = String.valueOf(contador);
        }
        
        DOMSource dom = new DOMSource(doc);
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        StreamResult sr = new StreamResult(new File("futbolistas_actualizado.xml"));
        trans.transform(dom, sr);
    }
}
