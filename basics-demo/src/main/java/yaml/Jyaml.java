package yaml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ho.yaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author 夏飞
 */
public class Jyaml {
    public static void main(String[] args) throws FileNotFoundException, JsonProcessingException {
        File file = new File(Jyaml.class.getResource("template-tree.yml").getFile());
        System.out.println(file.getAbsolutePath());
        Object object = Yaml.load(file);
        ObjectMapper objectMapper=new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(object));
    }
}
