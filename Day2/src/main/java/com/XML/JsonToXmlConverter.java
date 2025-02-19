import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();


            JsonNode jsonNode = objectMapper.readTree(new File("N:\\Week5\\Day2\\com\\XML\\JsonFile01.json"));


            String xml = convertJsonToXml(jsonNode, "Root");
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String convertJsonToXml(JsonNode node, String rootElement) {
        StringBuilder xml = new StringBuilder();
        xml.append("<").append(rootElement).append(">");

        node.fields().forEachRemaining(entry -> {
            xml.append("<").append(entry.getKey()).append(">")
                    .append(entry.getValue().asText())
                    .append("</").append(entry.getKey()).append(">");
        });

        xml.append("</").append(rootElement).append(">");
        return xml.toString();
    }
}