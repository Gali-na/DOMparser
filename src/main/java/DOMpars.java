import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMpars {

    public ArrayList<Human> persDOM() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setValidating(true);
        Document document = null;
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        try {
            document = documentBuilder.parse(new File("C:\\Users\\Acer Nitro 5\\IdeaProjects\\DOMControler\\src\\main\\schema.xsd.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Human> humans = new ArrayList<Human>();
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Human human = new Human();
                Element humanElement = (Element) node;
                if (humanElement.getTagName().equals("w3s:human")) {
                    human = parsHumanElement(humanElement);
                }
                humans.add(human);
            }
        }
        return humans;
    }

    private Human parsHumanElement(Element humanElement) {
        Human human = new Human();
        try {
            human.setName(humanElement.getElementsByTagName("w3s:name").item(0).getTextContent());
        } catch (HumanException e) {
            e.printStackTrace();
        }
        try {
            human.setSurname(humanElement.getElementsByTagName("w3s:surname").item(0).getTextContent());
        } catch (HumanException e) {
            e.printStackTrace();
        }
        human.setAge(Integer.valueOf(humanElement.getElementsByTagName("w3s:age").item(0).getTextContent()));

        Element addressElement = (Element) humanElement.getElementsByTagName("w3s:adress").item(0);
        Address address = parsAddressElement(addressElement);
        try {
            human.setAddress(address);
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return human;
    }


    private Address parsAddressElement(Element addressElement) {
        Address address = new Address();
        try {
            address.setCity(addressElement.getElementsByTagName("w3s:city").item(0).getTextContent());
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            address.setStreet(addressElement.getElementsByTagName("w3s:street").item(0).getTextContent());
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            address.setHouseNumber(addressElement.getElementsByTagName("w3s:houseNumber").item(0).getTextContent());
        } catch (AddressException e) {
            e.printStackTrace();
        }
        return address;
    }

}


