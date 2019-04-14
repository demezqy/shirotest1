package Job;
import org.quartz.*;
public class HellowJob implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获取JobDetail中的信息
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        System.out.println(key.getName() + " " + key.getGroup() + " " + key.getClass());

        // 获取Trigger的信息
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println(triggerKey.getName() + " " + triggerKey.getGroup() + " " + triggerKey.getClass());

        // 获取Trigger中的参数
        JobDataMap jobDataMap2 = jobExecutionContext.getTrigger().getJobDataMap();
        System.out.println(jobDataMap2.getString("message"));

        // 获取JobDetail中的参数
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap(); // 实现了MAP接口的数据结构
        String usetId = jobDataMap.getString("userId");
        int status = jobDataMap.getInt("status");

        System.out.println("update userlogin set userstatus = " + status + " where id = " + usetId);

    }
}
