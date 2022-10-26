/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author manue
 */
//import static Ejercicios.futbolistas.modificarFutbolistas;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

public class Ejercicio1Rep {

    private static final String INDENT_NIVEL = "  ";  // Para indentación

    public static void muestraNodo(Node nodo, int nivel, PrintStream ps) {

        if (nodo.getNodeType() == Node.TEXT_NODE) {
            String text = nodo.getNodeValue();
            if (text.trim().length() == 0) {
                return;
            }
        }
        for (int i = 0; i < nivel; i++) {
            ps.print(INDENT_NIVEL);

        }
        switch (nodo.getNodeType()) {
            case Node.DOCUMENT_NODE:
                Document doc = (Document) nodo;
                ps.println("Documento DOM, versión: " + doc.getXmlVersion()
                        + ", codificación: " + doc.getXmlEncoding());
                break;
            case Node.ELEMENT_NODE:
                ps.print("<" + nodo.getNodeName());
                NamedNodeMap listaAtr = nodo.getAttributes();
                for (int i = 0; i < listaAtr.getLength(); i++) {
                    Node atr = listaAtr.item(i);
                    ps.print(" @" + atr.getNodeName() + "[" + atr.getNodeValue() + "]");
                }
                ps.println(">");
                break;
            case Node.TEXT_NODE:
                ps.println(nodo.getNodeName() + "[" + nodo.getNodeValue() + "]");
                break;
            default:
                ps.println("(nodo de tipo: " + nodo.getNodeType() + ")");
        }
        NodeList nodosHijos = nodo.getChildNodes();
        for (int i = 0; i < nodosHijos.getLength(); i++) {
            muestraNodo(nodosHijos.item(i), nivel + 1, ps);
        }
    }

    public static void main(String[] args) {

        String nomFich;
        Scanner sc = new Scanner(System.in);
        if (args.length < 1) {
            System.out.println("Indicar por favor nombre de fichero: ");
            nomFich = sc.nextLine();
        } else {
            nomFich = args[0];
        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(true);

        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document domDoc = db.parse(new File(nomFich));
            muestraNodo(domDoc, 0, System.out);
            modificarFutbolistas(domDoc);
        } catch (FileNotFoundException | ParserConfigurationException | SAXException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void modificarFutbolistas(Document documento) throws TransformerConfigurationException, TransformerException {

        documento.getDocumentElement().normalize();
        Node nodoRaiz = documento.getDocumentElement();

        Element futbolista1 = documento.createElement("futbolista");
        futbolista1.setAttribute("id", "5");

        Element nombreFutbolista = documento.createElement("nombre");
        nombreFutbolista.appendChild(documento.createTextNode("Modric"));
        futbolista1.appendChild(nombreFutbolista);

        Element equipo = documento.createElement("equipo");
        equipo.appendChild(documento.createTextNode("Real Madrid"));
        futbolista1.appendChild(equipo);

        Element goles = documento.createElement("goles");
        goles.appendChild(documento.createTextNode("18"));
        futbolista1.appendChild(goles);
        nodoRaiz.appendChild(futbolista1);
        Element futbolista2 = documento.createElement("futbolista");
        futbolista2.setAttribute("id", "6");

        nombreFutbolista = documento.createElement("nombre");
        nombreFutbolista.appendChild(documento.createTextNode("Messi"));
        futbolista2.appendChild(nombreFutbolista);

        equipo = documento.createElement("equipo");
        equipo.appendChild(documento.createTextNode("Paris Saint-Germain"));
        futbolista2.appendChild(equipo);

        goles = documento.createElement("goles");
        goles.appendChild(documento.createTextNode("5"));
        futbolista2.appendChild(goles);
        nodoRaiz.appendChild(futbolista2);
        Element futbolista3 = documento.createElement("futbolista");
        futbolista3.setAttribute("id", "7");

        nombreFutbolista = documento.createElement("nombre");
        nombreFutbolista.appendChild(documento.createTextNode("Jordi Alba"));
        futbolista3.appendChild(nombreFutbolista);

        equipo = documento.createElement("equipo");
        equipo.appendChild(documento.createTextNode("F.C Barcelona"));
        futbolista3.appendChild(equipo);

        goles = documento.createElement("goles");
        goles.appendChild(documento.createTextNode("2"));
        futbolista3.appendChild(goles);
        nodoRaiz.appendChild(futbolista3);
        Element futbolista4 = documento.createElement("futbolista");
        futbolista4.setAttribute("id", "8");

        nombreFutbolista = documento.createElement("nombre");
        nombreFutbolista.appendChild(documento.createTextNode("Erling Haaland"));
        futbolista4.appendChild(nombreFutbolista);

        equipo = documento.createElement("equipo");
        equipo.appendChild(documento.createTextNode("Manchester City F.C"));
        futbolista4.appendChild(equipo);

        goles = documento.createElement("goles");
        goles.appendChild(documento.createTextNode("32"));
        futbolista4.appendChild(goles);
        nodoRaiz.appendChild(futbolista4);
        Element futbolista5 = documento.createElement("futbolista");
        futbolista5.setAttribute("id", "9");

        nombreFutbolista = documento.createElement("nombre");
        nombreFutbolista.appendChild(documento.createTextNode("Lewandowski"));
        futbolista5.appendChild(nombreFutbolista);

        equipo = documento.createElement("equipo");
        equipo.appendChild(documento.createTextNode("F.C Barcelona"));
        futbolista5.appendChild(equipo);

        goles = documento.createElement("goles");
        goles.appendChild(documento.createTextNode("12"));
        futbolista5.appendChild(goles);
        nodoRaiz.appendChild(futbolista5);

        DOMSource domSource = new DOMSource(documento);
        Transformer transform = TransformerFactory.newInstance().newTransformer();
        StreamResult sr = new StreamResult(new File("C:\\Users\\manue\\OneDrive\\Documentos\\NetBeansProjects\\ejercicios\\src\\ejercicios\\futbolistas2.xml"));
        transform.transform(domSource, sr);
    }
}
