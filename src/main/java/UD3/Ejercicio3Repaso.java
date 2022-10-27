package UD3;

import static UD3.Ejercicio1Repaso.br;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio3Repaso {

    private static final String INDENT_NIVEL = " "; // INDENTACIÓN

    public static void mostrarNodo(Node nodo, int nivel, PrintStream ps) {
        if (nodo.getNodeType() == Node.TEXT_NODE) { // ESPACIOS BLANCOS
            String text = nodo.getNodeValue();
            if (text.trim().length() == 0) {
                return;
            }
        }

        for (int i = 0; i < nivel; i++) { // INDENTACIÓN
            ps.print(INDENT_NIVEL);
        }

        switch (nodo.getNodeType()) { // MOSTRARÁ INFORMACIÓN SEGÚN EL TIPO DE NODO
            case Node.DOCUMENT_NODE: // DOCUMENTO
                Document doc = (Document) nodo;
                ps.println("Documento DOM, versión: " + doc.getXmlVersion()
                        + ", codificación: " + doc.getXmlEncoding());
                // MOSTRARÁ INFORMACIÓN DEL FICHERO XML
                break;
            case Node.ELEMENT_NODE: // ELEMENTO
                ps.print("<" + nodo.getNodeName()); // ELEMENTO
                NamedNodeMap listaAtr = nodo.getAttributes(); // LISTA ATRIBUTOS
                for (int i = 0; i < listaAtr.getLength(); i++) {
                    Node atr = listaAtr.item(i);
                    ps.print(" @" + atr.getNodeName() + "[" + atr.getNodeValue() + "]");
                    // MUESTRA NOMBRE DE ATRIBUTO Y VALOR
                }
                ps.println(">");
                break;
            case Node.TEXT_NODE: // TEXTO
                ps.println(nodo.getNodeName() + "[" + nodo.getNodeValue() + "]");
                // MUESTRA EL VALOR DEL ELEMENTO
                break;
            default: // OTRO TIPO DE NODO
                ps.println("(Nodo de tipo: " + nodo.getNodeType() + ")");
        }

        NodeList nodosHijos = nodo.getChildNodes(); // MUESTRA NODOS HIJOS
        for (int i = 0; i < nodosHijos.getLength(); i++) {
            mostrarNodo(nodosHijos.item(i), nivel + 1, ps);
        }
    }

    public static void anadirFutbolistas(Document doc) throws TransformerException, IOException {
        doc.getDocumentElement().normalize();
        Node nodo = doc.getDocumentElement();

        int contador = 5;
        String id = String.valueOf(contador);
        for (int i = 1; i <= 5; i++) {
            Element futbolista = doc.createElement("futbolista");
            futbolista.setAttribute("id", id);

            System.out.println("Introduce el nombre del futbolista " + i + ": ");
            String nombre = br.readLine();

            Element nombreFutbolista = doc.createElement("nombre");
            nombreFutbolista.appendChild(doc.createTextNode(nombre));
            futbolista.appendChild(nombreFutbolista);

            nodo.appendChild(futbolista);

            contador++;
            id = String.valueOf(contador);
        }

        DOMSource dom = new DOMSource(doc);
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        StreamResult sr = new StreamResult(new File("futbolistas_actualizado.xml"));
        trans.transform(dom, sr);
    }

    /* public static void XPath() {
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodo = (NodeList) xpath.evaluate(XPathExpression, documento, XPathConstants.NODESET);
        System.out.print(nodo.item(i).getNodeValue());
        System.out.print(nodo.item(i).getChildNodes().item(0).getNodeValue()
        )
    } */
    /* public static void inOut() {
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino);
        while ((linea = in.read(datos)) > 0) {
            out.write(datos);
        }
    } */
}
