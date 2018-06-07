/**
 * 处理任务
 * 主要两个参数
 * fileData文件
 * processorType处理类型
 */
public class ProcessorTask implements Runnable{


    UploadContext uploadContext;

    /**
     * 1.根据processorType找到对应的handler
     * 2.poi解析 fileData 将row转成ArrayList<String>
     * 3.调用抽象handler进行处理
     *      通过taskId去ProgressRegister 更新成功次数，失败次数
     */
    @Override
    public void run() {


    }
}
