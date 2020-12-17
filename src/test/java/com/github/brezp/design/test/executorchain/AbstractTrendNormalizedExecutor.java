package com.github.brezp.design.test.executorchain;

import com.github.brezp.design.executorchain.exec.Executor;
import com.github.brezp.design.executorchain.exec.ExecutorChain;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 归一化工具对接流程：
 * 1、校验当前月品类的趋势任务是否已经完成；
 * 2、获取当前月份趋势任务的hdfs文件；
 * 3、生成待归一化文件；
 * 4、上传文件到归一化工具以及创建归一化任务
 *
 * @author wangdahao
 */
@Slf4j
public abstract class AbstractTrendNormalizedExecutor implements Executor<TrendNormalizedExecutorContext>, Serializable {


    /**
     * 生成待归一文件
     *
     * @param context                上下文配置信息
     * @param toBeNormalizedFilePath 生成的待归一文件路径
     * @return true or false
     */
    protected abstract boolean generateTobeNormalizedFile(TrendNormalizedExecutorContext context, String toBeNormalizedFilePath) throws Exception;

    /**
     * 生成归一化码表文件
     *
     * @param context                   上下文配置信息
     * @param normalizedMappingFilePath 生成的归一化码表文件路径
     * @return true or false
     */
    protected abstract boolean generateNormalizedMappingFile(TrendNormalizedExecutorContext context, String normalizedMappingFilePath) throws Exception;

    @Override
    public void execute(TrendNormalizedExecutorContext context, ExecutorChain chain) throws Exception {
        //String tmpDir = FilePathUtil.getPathForNormalize(context.getAppCategory().getIndustry() ,context.getAppCategory().getName() ,context.getTime());
       // File dir = new File(tmpDir);
       // if (!dir.exists()) {
       //     //noinspection ResultOfMethodCallIgnored
       //     dir.mkdirs();
       // }
       //
       // // 待归一文件
       // String toBeNormalizedFilePath = FilePathUtil.getNormalizeFilePath(tmpDir ,context.getAppCategory().getName() ,context.getTime());
       // // 上传文件到hdfs缓存下来
       //// HdfsUtil.copyLocalFileToHdfs(toBeNormalizedFilePath, context.getNormalizedHdfsDir());
       //
       // // 归一化码表
       // String normalizedMappingFilePath = FilePathUtil.getNormalizeCodeTablePath(tmpDir ,context.getAppCategory().getName() ,context.getTime());
       //// HdfsUtil.copyLocalFileToHdfs(normalizedMappingFilePath, context.getNormalizedHdfsDir());
       //
       // // 生成待归一化文件
       // boolean isSuccess1 = generateTobeNormalizedFile(context, toBeNormalizedFilePath);
       // boolean isSuccess2 = generateNormalizedMappingFile(context, normalizedMappingFilePath);
       // log.info(toBeNormalizedFilePath);
       // log.info(normalizedMappingFilePath);
       // if(isSuccess1 && isSuccess2){
       //     log.info("Save normalized");
       // }
       // if (isSuccess1 && isSuccess2) {
       //     String taskId = submitRequest(toBeNormalizedFilePath, normalizedMappingFilePath, context.getNormalizedTaskName(), context.getNormalizedTaskDescription());
       //     log.info("Submit normalized task id: {}", taskId);
       // } else {
       //     log.error("Category: {} create normalized task fail.", context.getAppCategory().getName());
       // }
    }


    /**
     * 上传文件并创建归一化任务
     *
     * @param toBeNormalizedFilePath    待归一化文件的路径
     * @param normalizedMappingFilePath 归一化码表的路径
     * @param taskName                  归一化工具中的任务名
     * @param description               任务描述
     * @return 归一化任务id
     */
    public String submitRequest(String toBeNormalizedFilePath, String normalizedMappingFilePath, String taskName, String description) throws Exception {
        //// 上传待归一文件
        //Map<String, Object> toBeNormalizedFileUploadResponse = NormalizedRequestUtil.execUpload(new File(toBeNormalizedFilePath), true);
        //String toBeNormalizedFileUploadId = null;
        //if (Objects.equals(0, toBeNormalizedFileUploadResponse.get("code"))) {
        //    Map<String, String> data = (Map<String, String>) toBeNormalizedFileUploadResponse.get("data");
        //    toBeNormalizedFileUploadId = String.valueOf(data.get("id"));
        //}
        //// 上传归一化码表
        //String normalizedMappingFileUploadId = null;
        //if (!StringUtil.isNullOrEmpty(normalizedMappingFilePath)) {
        //    Map<String, Object> normalizedMappingFileResponse = NormalizedRequestUtil.execUpload(new File(normalizedMappingFilePath), false);
        //    if (Objects.equals(0, normalizedMappingFileResponse.get("code"))) {
        //        Map<String, String> data = (Map<String, String>) normalizedMappingFileResponse.get("data");
        //        normalizedMappingFileUploadId = String.valueOf(data.get("id"));
        //    }
        //}
        //
        //if (!StringUtil.isNullOrEmpty(toBeNormalizedFileUploadId)) {
        //    List<String> datasourceIds = Lists.newArrayList(toBeNormalizedFileUploadId);
        //    if (!StringUtil.isNullOrEmpty(normalizedMappingFileUploadId)) {
        //        datasourceIds.add(normalizedMappingFileUploadId);
        //    }
        //    String createTaskResponse = NormalizedRequestUtil.execCreateTask(taskName, description, datasourceIds);
        //    Map<String, Object> responseMap = FastJsonSerializer.deserialize(createTaskResponse, new TypeToken<Map<String, Object>>() {
        //    }.getType());
        //    if (Objects.equals(0, responseMap.get("code"))) {
        //        Map<String, String> data = (Map<String, String>) responseMap.get("data");
        //        return String.valueOf(data.get("id"));
        //    }
        //}
        return null;
    }

    @Override
    public void postExecute(TrendNormalizedExecutorContext context, ExecutorChain chain) throws Exception {
        chain.execute();
    }
}
