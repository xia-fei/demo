import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/***
 *  进度注册器
 */
public class ProgressRegister {



    private final Map<String, ProcessorProgress> REGISTER_MAP = new HashMap<>();

    private void register(String taskId, int totalIndex) {
        ProcessorProgress processorProgress = new ProcessorProgress();
        REGISTER_MAP.put(taskId, processorProgress);
    }

    public String generateTaskId() {
        return UUID.randomUUID().toString();
    }
}
