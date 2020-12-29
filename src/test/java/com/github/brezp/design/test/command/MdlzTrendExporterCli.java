package com.github.brezp.design.test.command;


import com.github.brezp.design.command.CmdRunner;
import com.github.brezp.design.command.ICmdLine;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;


import java.util.*;
import java.util.concurrent.*;

/**
 * 亿滋结果榜单、关联,输出
 *
 */
@Slf4j
public class MdlzTrendExporterCli implements ICmdLine {

    private static final String ALGO_FINISHED = "ALGO_FINISHED";
    private static final String ALGO_FINISHED_OUT_PUT_FINISHED = "ALGO_FINISHED / OUT_PUT_FINISHED";
    /**
     * t_trend_algo_log算法任务ID
     */
    private List<String> algoLogJobIds;

    /**
     * 起始时间, 结束时间
     */
    private Long startTime, endTime;

    private static final String TREND_LIST_FINISHED = "TREND_LIST_FINISHED";
    private static final String ERROR = "ERROR";
    private static final String ALGO_ERROR = "ALGO_ERROR";

    /**
     * 使用guava提供的ThreadFactoryBuilder创建线程池
     */
    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("trend-writing-pool-%d").build();


    /**
     * 趋势黑名单列表
     */
    private static Map<String, String> blackList = new HashMap<>(26);

    static {
        System.setProperty("HADOOP_USER_NAME", "dota");
    }

    public MdlzTrendExporterCli(List<String> algoLogIds, Long endTime) {
        this.algoLogJobIds = algoLogIds;
        this.endTime = endTime;
    }

    public MdlzTrendExporterCli() {
        super();
    }

    public static void main(String[] args) {
        CmdRunner.initRunner(args, MdlzTrendExporterCli.class.getCanonicalName(), new MdlzTrendExporterCli());
        System.exit(0);
    }

    @Override
    public Options initOptions() {
        Options options = new Options();
        //榜单月份参数
        options.addOption("month", true, "榜单月份");
        options.addOption("algoJobIds", true, "算法任务ID");
        return options;
    }

    @Override
    public boolean validateOptions(CommandLine commandLine) {
        return true;
    }

    @SneakyThrows
    @Override
    public void start(CommandLine commandLine) {
        //算法日志ID
        String[] cmdIds = commandLine.getOptionValue("algoJobIds").split(",");
        List<String> algoLogIds = Lists.newArrayList(cmdIds);
        this.algoLogJobIds = algoLogIds;
        //this.exec();
    }

    //public void exec() throws InterruptedException {
    //
    //    //查询算法结果导入亿滋业务nova库
    //    this.loadBlackList();
    //    ThreadPoolExecutor daoExecutor = new ThreadPoolExecutor(5, 13, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    //    CountDownLatch latch = new CountDownLatch(algoLogJobIds.size());
    //    algoLogJobIds.forEach(id -> {
    //        daoExecutor.execute(() -> {
    //            log.info("线程开始执行！！！！！AlgoLogId:{} 线程ID:{}", id, Thread.currentThread().getId());
    //            //查询算法任务状态
    //            try {
    //                TrendAlgoLog algoLog = TrendAlgoLogMapper.getTrendAlgoLog(id);
    //                while (!ALGO_FINISHED.equals(algoLog.getStatus())) {
    //                    if (ERROR.equals(algoLog.getStatus()) || ALGO_ERROR.equals(algoLog.getStatus())) {
    //                        log.info("算法执行返回错误！！！！！AlgoLogJobId:{} 本线程结束,线程ID:{}", id, Thread.currentThread().getId());
    //                        return;
    //                    }
    //                    log.info("算法执行等待中...,AlgoLogJobId:{},线程ID:{}", id, Thread.currentThread().getId());
    //                    Thread.sleep(120000);
    //                }
    //                //算法任务执行完成,入库
    //                log.info("算法执行完成...,AlgoLogJobId:{},线程ID:{}", id, Thread.currentThread().getId());
    //                Path[] allFilePath = HdfsUtil.getAllFilePath(algoLog.getOutputHdfsPath());
    //                for (Path path : allFilePath) {
    //                    if (!HdfsUtil.isExistFiles(path.toString())) {
    //                        log.info("算法输出文件不存在...,AlgoLogJobId:{},文件:{}线程ID:{}", id, path.toString(), Thread.currentThread().getId());
    //                        continue;
    //                    }
    //                    //写结果至Nova数据库
    //                    this.writeResultToMysql(path);
    //                    //写结果日志
    //                    this.writeResultLog(id);
    //                }
    //                latch.countDown();
    //            } catch (Exception e) {
    //                log.error("导出返回错误！！！！！AlgoLogJobId:{} 本线程结束,线程ID:{},\n:{}", id, Thread.currentThread().getId(), e.getMessage());
    //                e.printStackTrace();
    //
    //            }
    //        });
    //    });
    //    log.info("工作任务执行中..");
    //    latch.await();
    //    log.info("工作任务执行完毕!!!");
    //
    //}

    //
    //private void writeResultLog(String id) throws Exception {
    //    TrendAlgoLog trendAlgoLog = TrendAlgoLogMapper.getTrendAlgoLog(id);
    //    trendAlgoLog.setStatus(ALGO_FINISHED_OUT_PUT_FINISHED);
    //    TrendAlgoLogMapper.getMapper().insertOnDuplicate(trendAlgoLog);
    //}
    //
    //private void writeResultToMysql(Path path) throws Exception {
    //    //趋势榜单
    //    if (path.toString().contains("trend_new")) {
    //        this.writeTrendList(path);
    //    } else if (path.toString().contains("relation_new")) {
    //        //趋势关联
    //        this.writeTrendRelation(path);
    //    }
    //}
    //
    //private void writeTrendRelation(Path path) throws Exception {
    //    CsvUtil<MdlzTrendRelation> csvUtil = new CsvUtil();
    //    List<MdlzTrendRelation> mdlzTrendRelations = csvUtil.readByCsvCol(HdfsUtil.getInputStream(path), MdlzTrendRelation.class);
    //    if (CollectionUtil.isEmpty(mdlzTrendRelations)) {
    //        log.info("开始插入趋势关联...,文件:{} , 数量为0!!! ,  线程ID:{}", path.toString(), Thread.currentThread().getId());
    //        return;
    //    }
    //    mdlzTrendRelations.stream().forEach(t -> {
    //        t.setTime(DateUtil.getMonthDay1ByTimeStamp(endTime));
    //    });
    //    log.info("开始 插入趋势关联...,文件:{} , 数量:{} ,  线程ID:{}", path.toString(), mdlzTrendRelations.size(), Thread.currentThread().getId());
    //    MdlzTrendRelationMapper.getMapper().insertWithKey(mdlzTrendRelations);
    //    log.info("插入趋势关联 完成...,文件:{} , 数量:{} ,  线程ID:{}", path.toString(), mdlzTrendRelations.size(), Thread.currentThread().getId());
    //}
    //
    //private void writeTrendList(Path path) throws Exception {
    //    CsvUtil<MdlzTrendList> csvUtil = new CsvUtil();
    //    List<MdlzTrendList> mdlzTrendLists = csvUtil.readByCsvCol(HdfsUtil.getInputStream(path), MdlzTrendList.class);
    //    if (CollectionUtil.isEmpty(mdlzTrendLists)) {
    //        log.info("开始插入趋势榜单...,文件:{} , 数量为0!!! ,  线程ID:{}", path.toString(), Thread.currentThread().getId());
    //        return;
    //    }
    //    //过滤趋势黑名单
    //    List<MdlzTrendList> filterList = mdlzTrendLists.stream().filter(t -> !this.isBlackList(t)).collect(Collectors.toList());
    //    //添加字段
    //    filterList.stream().forEach(t -> {
    //        t.setTime(DateUtil.getMonthDay1ByTimeStamp(endTime));
    //        t.setCreate_time(com.xiaoleilu.hutool.date.DateUtil.formatDateTime(new Date()));
    //        //是否为推荐趋势
    //        if (MdlzConstant.recommendCategory.contains(t.getCategory()) && MdlzConstant.recommendTrendType.contains(t.getType())) {
    //            t.setIs_recommend(DefaultConstant.YES);
    //        } else {
    //            t.setIs_recommend(DefaultConstant.NO);
    //        }
    //        //社媒P1Y趋势图
    //        t.setSocial_vol_drift(this.generateSocialDrift(t));
    //        //t.setAd_vol_p3m(Math.ceil(t.getAd_vol_p3m() / 3D));
    //        //t.setBigv_vol_p3m(Math.ceil(t.getBigv_vol_p3m() / 3D));
    //        //t.setConsumer_vol_p3m(Math.ceil(t.getConsumer_vol_p3m() / 3D));
    //        //t.setEcom_vol_p3m(Math.ceil(t.getEcom_vol_p3m() / 3D));
    //    });
    //    //写库
    //    log.info("开始插入趋势榜单...,文件:{} ,  数量:{} , 线程ID:{}", path.toString(), mdlzTrendLists.size(), Thread.currentThread().getId());
    //    MdlzTrendListMapper.getMapper().insertWithKey(filterList);
    //    log.info("插入趋势榜单 完成...,文件:{} , 数量:{} ,  线程ID:{}", path.toString(), mdlzTrendLists.size(), Thread.currentThread().getId());
    //}
    //
    ///**
    // * 社媒过去一年趋势
    // *
    // * @param t
    // * @return
    // */
    //private String generateSocialDrift(MdlzTrendList t) {
    //    //= 消费者+广告+大V
    //    List<Integer> consumers = JSON.parseArray(t.getConsumer_vol_drift(), Integer.class);
    //    List<Integer> ads = JSON.parseArray(t.getAd_vol_drift(), Integer.class);
    //    List<Integer> bigVs = JSON.parseArray(t.getBigv_vol_drift(), Integer.class);
    //    List<Integer> result = new ArrayList<>(12);
    //    for (int i = 0; i < 12; i++) {
    //        result.add(consumers.get(i) + ads.get(i) + bigVs.get(i));
    //    }
    //    return JSON.toJSONString(result);
    //}
    //
    //private void setTimeCondition(Date date) {
    //    Pair<Long, Long> pair = DateUtil.parseMonth(date.getTime());
    //    startTime = DateUtil.getTimeBeforeMonths(pair.first, 11);
    //    endTime = pair.second;
    //}
    //
    //private void loadBlackList() {
    //    try {
    //        MdlzTrendBlackListMapper.getMapper().getBlackList().stream().forEach(t -> {
    //            blackList.put(t.getCategory(), t.getTrends());
    //        });
    //        //log.info(" black list :{}", blackList.toString());
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //    }
    //}
    //
    //private boolean isBlackList(MdlzTrendList trend) {
    //    return (blackList.get("COMMON").contains(trend.getName()) || blackList.get(trend.getCategory()).contains(trend.getName()));
    //}

}
