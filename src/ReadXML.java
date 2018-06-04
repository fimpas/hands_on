//import java.io.File;
//
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.DocumentBuilder;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.NodeList;
//import org.w3c.dom.Node;
//import org.w3c.dom.Element;
//
//public class ReadXML {
//
//	public static void main(String[] args) {
//
//		try {
//			File XmlFile = new File("opencim3sub.xml");
//			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			Document doc = dBuilder.parse(XmlFile);
//
//			// normalize CIM XML file
//			doc.getDocumentElement().normalize();
//
//			NodeList subList = doc.getElementsByTagName("cim:Substation");
//			// ... read other required CIM objects
//
//			NodeList voltList = doc.getElementsByTagName("cim:VoltageLevel");
//			NodeList syncList = doc.getElementsByTagName("cim:SynchronousMachine");
//
//			// ... cycle through each list to extract required data
//			// System.out.println("\n Substations");
//			
//			for (int i = 0; i < subList.getLength(); i++) {
//				// ... use extractNode method
//				System.out.println("\n\n Substation");
//				Node snode = subList.item(i);
//				extractNode(snode);
//
//				System.out.println("\n Voltage Levels");
//				if (i == 0) {
//					for (int ii = 0; ii < 2; ii = ii + 1) {
//						Node vnode = voltList.item(ii);
//						extractNode(vnode);
//					}
//					System.out.println("\n Synchronus Machine");
//					Node mnode = syncList.item(i);
//					extractNode(mnode);
//				}
//				if (i == 1) {
//					Node vnode = voltList.item(i + 1);
//					extractNode(vnode);
//					Node mnode = syncList.item(i);
//					System.out.println("\n Synchronus Machine");
//					extractNode(mnode);
//				}
//				if (i == 2) {
//					for (int ii = 3; ii < 5; ii = ii + 1) {
//						Node vnode = voltList.item(ii);
//						extractNode(vnode);
//					}
//				}
//			}
//
//			// System.out.println("\n\n Voltage Levels");
//			// for (int i = 0; i < voltList.getLength(); i++) {
//			// Node vnode = voltList.item(i);
//			// extractNode(vnode);
//			// }
////			System.out.println("\n\n Synchronus Machines");
////			for (int i = 0; i < syncList.getLength(); i++) {
////				Node mnode = syncList.item(i);
////				extractNode(mnode);
////			}
//
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		//
//
//	}
//
//	public static void extractNode(Node node) {
//		// ... remember to convert node to element in order to search for the data
//		// inside it.
//		// element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent
//		// can be used to read specific attribute of XML node.
//
//		if (node.getNodeType() == Node.ELEMENT_NODE) {
//			Element aElement = (Element) node;
//			System.out.println(
//					"\n Name: " + aElement.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent()
//							+ "\twith rdf:ID : " + aElement.getAttribute("rdf:ID"));
//
//		}
//
//		//
//	}
//	// public static void extractNode(Node anode, Node bnode, Node cnode) {
//	// // ... remember to convert node to element in order to search for the data
//	// // inside it.
//	// //
//	// element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent
//	// // can be used to read specific attribute of XML node.
//	//
//	// if (bnode.getNodeType() == Node.ELEMENT_NODE) {
//	// Element aElement = (Element) anode;
//	// Element bElement = (Element) bnode;
//	// Element cElement = (Element) cnode;
//	// System.out.println("\nSubstation name: " +
//	// aElement.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent()
//	// + "\t\t with ID : " + aElement.getAttribute("rdf:ID"));
//	//
//	// System.out.println("Voltage Level : " +
//	// bElement.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent()
//	// + "\t with ID : " + bElement.getAttribute("rdf:ID"));
//	//
//	// System.out.println("Substation : " +
//	// cElement.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent()
//	// + "\t\t with ID : " + cElement.getAttribute("rdf:ID"));
//	//
//	// }
//	//
//	// //
//	// }
//}

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {
	public static void main(String[] args) {

		try {

			File XmlFile = new File("opencim3sub.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(XmlFile);
			doc.getDocumentElement().normalize();

			NodeList subList = doc.getElementsByTagName("cim:Substation");
//			NodeList voltList = doc.getElementsByTagName("cim:VoltageLevel");
//			NodeList genList = doc.getElementsByTagName("cim:SynchronousMachine");
//
			for (int i = 0; i < subList.getLength(); i++) {
				extractNode(subList.item(i));
			}
//
//			for (int i = 0; i < voltList.getLength(); i++) {
//				extractNode(voltList.item(i));
//			}
//
//			for (int i = 0; i < genList.getLength(); i++) {
//				extractNode(genList.item(i));
//			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void extractNode(Node node) {
		Element element = (Element) node;
		String rdfID = element.getAttribute("rdf:ID");
		String name = element.getElementsByTagName("cim:IdentifiedObject.name").item(0).getTextContent();
		Element subb = (Element) element.getElementsByTagName("cim:Substation.Region").item(0);
//		NodeList subbb = (NodeList) element.getElementsByTagName("cim:Substation.Region");
		String sub = subb.getAttribute("rdf:resource");
//		String sub = ((Element) element.getElementsByTagName("Substation.Region").item(0)).getAttribute("rdf:resource");
		System.out.println("rdfID: " + rdfID + "\n" + "objectName: " + name + "\n" + "Region: " + sub + "\n");
	}
}
