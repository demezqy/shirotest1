package cn.itcast.shiro.realm;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
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

    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    // 用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        // token是用户输入的
        // 第一步从token中取出身份信息
        String userCode = (String) token.getPrincipal();

        // 第二步：根据用户输入的userCode从数据库查询
        // ....


        // 如果查询不到返回null
        //数据库中用户账号是zhangsansan
		/*if(!userCode.equals("zhangsansan")){//
			return null;
		}*/


        // 模拟从数据库查询到密码
        String password = "111111";

        // 如果查询到返回认证信息AuthenticationInfo

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userCode, password, this.getName());

        return simpleAuthenticationInfo;
    }

    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {

        //从 principals获取主身份信息
        //将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
        String userCode =  (String) principals.getPrimaryPrincipal();

        //根据身份信息获取权限信息
        //连接数据库...
        //模拟从数据库获取到数据
        List<String> permissions = new ArrayList<String>();
        permissions.add("user:create");//用户的创建
        permissions.add("items:add");//商品添加权限
        //....

        //查到权限数据，返回授权信息(要包括 上边的permissions)
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

/*//这方法无法执行，realm需要的参数要用户传过来，并设置到里面，然后和数据库查的数据进行匹配
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


    }*/
}
