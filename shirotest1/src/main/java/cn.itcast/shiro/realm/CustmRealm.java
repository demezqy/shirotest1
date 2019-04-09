package cn.itcast.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassNAME CustmRealm
 * @Description TODO
 * @Author zhengqingyou
 * @Date2019/4/9 9:53
 * @Version
 */
public class CustmRealm extends AuthorizingRealm{

    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // token是用户输入的
        // 第一步从token中取出身份信息
        String userCode = (String) authenticationToken.getPrincipal();

        // 第二步：根据用户输入的userCode从数据库查询
        // ....


        // 如果查询不到返回null
        //数据库中用户账号是zhangsansan
		/*if(!userCode.equals("zhangsansan")){//
			return null;
		}*/


        // 模拟从数据库查询到密码
        String password = "111112";

        // 如果查询到返回认证信息AuthenticationInfo

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userCode, password, this.getName());
        System.out.println(simpleAuthenticationInfo);
        return simpleAuthenticationInfo;
    }
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
//这方法无法执行，realm需要的参数要用户传过来，并设置到里面，然后和数据库查的数据进行匹配
    public static void main(String[] args) {
        CustmRealm cus=new CustmRealm();
        //内部类的使用，使用接口来实现的
       AuthenticationToken  authenticationToken=new AuthenticationToken() {
            public Object getPrincipal() {
                return "zhangsa";
            }

            public Object getCredentials() {
                return "111111";
            }
        };

        cus.doGetAuthenticationInfo(authenticationToken);


    }
}
