package Test;
import com.timisakura.VO.EmployeeVO;
import com.timisakura.common.ServerResponse;
import com.timisakura.common.ServerResponse1;
import com.timisakura.dao.EmployeeMapper;

import com.timisakura.dao.UserMapper;
import com.timisakura.pojo.Employee;
import com.timisakura.pojo.Permission;
import com.timisakura.pojo.User;
import com.timisakura.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//RunWith继承了SpringJUnit4ClassRunner.class类
@RunWith(SpringJUnit4ClassRunner.class)
//给spring,@ContextConfiguration配置上下文，给spring配置文件
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class EmployeeTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IEmployeeService employeeService;
    @Test
    public void selectuserpermissionname(){
        String name="aaa";
        User user1=userMapper.selectuserpermissionname(name);
        List<Permission> list=user1.getPermissions();

        for (Permission AA:list){

            System.out.println("_______________________________");
            System.out.println(AA);
            System.out.println("_______________________________");

        }


        System.out.println("_______________________________");
        System.out.println(list.toArray().length);
        System.out.println();
        System.out.println("_______________________________");
        /*System.out.println("_______________________________");

        System.out.println(list.toArray());
        System.out.println("_______________________________");*/
    }
    @Test
    public void selectuserpermission(){
        int id=1;
        User user1=userMapper.selectuserpermission(id);
        List<Permission> list=user1.getPermissions();
        System.out.println(user1);
        System.out.println(list);

for (Permission AA:list){

    System.out.println("_______________________________");
    System.out.println(AA);
    System.out.println("_______________________________");

}

        System.out.println(list.toString());
System.out.println("_______________________________");
        System.out.println(list.toArray().length);
        System.out.println();
        System.out.println("_______________________________");
        /*System.out.println("_______________________________");

        System.out.println(list.toArray());
        System.out.println("_______________________________");*/
    }
    @Test
    public void register(){
        EmployeeVO employeeVO=new EmployeeVO();
        employeeVO.setEmail("zaazh@qq.com");
        employeeVO.setRealname("sbsdf");
        ServerResponse1 result=employeeService.register(employeeVO,"email");
        System.out.println(result);
    }
    @Test
    public void sellectqueryKey(){
        Employee ee=employeeMapper.selectByPrimaryKey(1);
        System.out.println(ee);
    }
    @Test
    public void selectName(){
        int ee=employeeMapper.checkEmployeename("xxxxxx");
        System.out.println(ee);
    }
    @Test
    public void selectEmain(){
        int ee=employeeMapper.checkEmail("eee");
        System.out.println(ee);
    }
    @Test
    public void findUseername(){
        String username="bbbb";
        Employee employee=employeeService.findUserName(username);
        System.out.println("_____________");
        System.out.println(employee);
    }
}
