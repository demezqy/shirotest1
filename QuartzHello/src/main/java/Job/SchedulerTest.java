package Job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @ClassNAME SchedulerTest
 * @Description TODO
 * @Author zhengqingyou
 * @Date2019/4/14 15:57
 * @Version
 */
public class SchedulerTest {

    public void run() throws Exception {

        System.out.println("------- 初始化 --------------------");

        SchedulerFactory sf = new StdSchedulerFactory();

        Scheduler sched = sf.getScheduler();

        System.out.println("------- 初始化完成 -------------------");

        System.out.println("------- 执行任务 ---------------------");

        /**
         * 任务的执行策略
         */
        JobDetail job =  newJob(HellowJob.class).withIdentity("job8", "group1").build();
        /**
         * 任务执行的时间 在6月19日的 11点18分执行任务
         */
        CronTrigger trigger = newTrigger().withIdentity("trigger8", "group1").withSchedule(cronSchedule("0 18 11 19 6 ?"))
                .build();

        Date ft = sched.scheduleJob(job, trigger);

        sched.start();
    }

    public static void main(String[] args) throws Exception {

        new SchedulerTest().run();

    }

}
