package top.buukle.consumer.www.constants;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description :
 */
public class AsyncTaskConstants {


    /* 默认延时时间*/
    public static final Long DEFAULT_DELAY_TIME = 300000l;
    /* 默认轮询步长*/
    public static final Integer DEFAULT_DELAY_SIZE = 10;

    /*任务状态 -待处理*/
    public static final Integer STATUS_WAITING = 0;
    /*任务状态 -处理中*/
    public static final Integer STATUS_HANDLING = 1;
    /*任务状态 -处理成功*/
    public static final Integer STATUS_SUCCESS = 2;
    /*任务状态 -处理失败*/
    public static final Integer STATUS_FAILED = 3;

    /*任务类型 - 失败后重复执行*/
    public static final Integer TYPE_REPEAT = 0;
    /*任务类型 - 失败后不在执行*/
    public static final Integer TYPE_ONCE = 1;
    /*任务类型 - 实时收集*/
    public static final Integer TYPE_REAL_TIME =2;

    /*PraiseTask - 任务执行类名*/
    public static final String CLASSNAME_PRAISE_TASK = "top.buukle.consumer.www.task.PraiseTask";
    /*PraiseTask - 任务执行方法名*/
    public static final String METHOD_NAME_PRAISE_TASK = "execute";


}
