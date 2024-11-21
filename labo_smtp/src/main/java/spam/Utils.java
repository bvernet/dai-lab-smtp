package spam;

import java.io.File;
import java.io.FileReader;

import javax.management.ObjectName;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
    final String CONFIG_PATH = "../../../../config-files/";
    final String VICTIMS_CONFIG_FILE_PATH = CONFIG_PATH + "victims.json";
    final String MESSAGES_CONFIG_FILE_PATH = CONFIG_PATH + "messages.json";

    public static String getVictims () {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(VICTIMS_CONFIG_FILE_PATH));
            String text = jsonNode.asText();
            return text;

        } catch (Exception e) {

        }
        return "";
    }
    
}
//lire les fichiers -> get_emails et get_messages