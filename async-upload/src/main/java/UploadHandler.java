import java.util.List;

/**
 * 上传handler
 */
public interface UploadHandler {

    /**
     * 对应的处理类型Type
     */
    String getProcessorType();

    /**
     * 检验是否由自己处理
     *
     * @param firstRow 第一行数据
     */
    boolean checkHandler(List<String> firstRow);


    /**
     * 业务逻辑处理
     * @param currentRow 当前这一行
     */
    boolean process(List<String> currentRow);


}
