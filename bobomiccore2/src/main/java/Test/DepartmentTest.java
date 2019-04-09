package Test;

import com.timisakura.dao.DepartmentMapper;
import com.timisakura.pojo.Department;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//RunWith继承了SpringJUnit4ClassRunner.class类
@RunWith(SpringJUnit4ClassRunner.class)
//给spring,@ContextConfiguration配置上下文，给spring配置文件
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class DepartmentTest {
@Autowired
    private DepartmentMapper departmentMapper;
@Test
public void allSellect(){
    Department list=departmentMapper.selectByPrimaryKey(1);
    System.out.println(list);
}
}
