package api.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yomahub.liteflow.parser.el.ClassJsonFlowELParser;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestRuleSource extends ClassJsonFlowELParser {

    @Override
    public String parseCustom() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> nodes = new HashMap<>();
        ArrayList<Map<String, String>> nodeList = new ArrayList<>();
        HashMap<String, String> nodeMap1 = new HashMap<>();
        nodeMap1.put("id","f");
        nodeMap1.put("class","api.bean.liteFlow.FCmp");
        nodeList.add(nodeMap1);

        HashMap<String, String> nodeMap2 = new HashMap<>();
        nodeMap2.put("id","e");
        nodeMap2.put("class","api.bean.liteFlow.ECmp");
        nodeList.add(nodeMap2);

        HashMap<String, String> nodeMap3 = new HashMap<>();
        nodeMap3.put("id","b");
        nodeMap3.put("class","api.bean.liteFlow.BCmp");
        nodeList.add(nodeMap3);

        HashMap<String, String> nodeMap4 = new HashMap<>();
        nodeMap4.put("id","a");
        nodeMap4.put("class","api.bean.liteFlow.ACmp");
        nodeList.add(nodeMap4);

        nodes.put("node", nodeList);
        data.put("nodes", nodes);

        ArrayList<Map<String, String>> ruleList = new ArrayList<>();
        HashMap<String, String> ruleMap = new HashMap<>();

        ruleMap.put("name", "chain2");
        ruleMap.put("value", System.currentTimeMillis() <= 1721124420000L ? "IF(OR(f,AND(f, e)), a)" : "IF(OR(f,AND(f, e)), b)");
        ruleList.add(ruleMap);
        data.put("chain", ruleList);

        result.put("flow", data);
        ObjectMapper objectMapper = new ObjectMapper();
        String res = "";

        try {
            res = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&");
        System.out.println(res);

        return res;
    }


    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.newDocument();

            org.w3c.dom.Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);

            Element childElement = doc.createElement("child");
            rootElement.appendChild(childElement);

            String xmlString = docToString(doc);
            System.out.println(xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String docToString(Document doc) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        return writer.getBuffer().toString().replaceAll("\n|\r", "");
    }
}
