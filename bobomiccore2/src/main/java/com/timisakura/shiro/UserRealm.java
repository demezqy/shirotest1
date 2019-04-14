package com.timisakura.shiro;

import com.timisakura.pojo.Employee;
import com.timisakura.pojo.Permission;
import com.timisakura.pojo.User;
import com.timisakura.service.IEmployeeService;
import com.timisakura.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNAME CustomRealm
 * @Description TODO
 * @Author zhengqingyou
 * @Date2019/4/10 11:27
 * @Version
 */
public class UserRealm extends AuthorizingRealm{
    @Autowired
    private IUserService iUserService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // token是用户输入的用户名和密码
        // 第一步从token中取出用户名
        String username = (String) token.getPrincipal();

        // 第二步：根据用户输入的userCode从数据库查询
        User user = null;
        try {
            user=iUserService.selectuserpermissionname(username);
            System.out.println("____________________");
            System.out.println(user);
            System.out.println("____________________");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // 如果查询不到返回null
        if(user==null){//
            return null;
        }
        // 从数据库查询到密码
        String password = user.getPassword();

       /* //盐
        String salt = Employee.getSalt();

        // 如果查询到返回认证信息AuthenticationInfo

        //activeUser就是用户身份信息
        ActiveUser activeUser = new ActiveUser();

        activeUser.setUserid(sysUser.getId());
        activeUser.setUsercode(sysUser.getUsercode());
        activeUser.setUsername(sysUser.getUsername());
        //..
*/
        /*//根据用户id取出菜单
        List<SysPermission> menus  = null;
        try {
            //通过service取出菜单
            menus = sysService.findMenuListByUserId(sysUser.getId());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //将用户菜单 设置到activeUser
        activeUser.setMenus(menus);*/

        //将activeUser设置simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user, password, this.getName());

        return simpleAuthenticationInfo;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从 principals获取主身份信息
        //将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
        User activeUser =  (User) principalCollection.getPrimaryPrincipal();

        //根据身份信息获取权限信息
        //从数据库获取到权限数据
        List<Permission> permissionList = null;
        try {
            permissionList = iUserService.selectuserpermissionname(activeUser.getName()).getPermissions();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //单独定一个集合对象
        List<String> permissions = new ArrayList<String>();
        if(permissionList!=null){
            for(Permission sysPermission:permissionList){
                //将数据库中的权限标签 符放入集合
                permissions.add(sysPermission.getResource());
            }
        }

        System.out.println("_______________________________");
        System.out.println(permissions);
        String[] tt = (String[]) permissions.toArray(new String[0]);
        System.out.println("大小="+tt.length);
        System.out.println("_______________________________");
        //查到权限数据，返回授权信息(要包括 上边的permissions)
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;


    }
    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        System.out.println("执行了缓存");
        super.clearCache(principals);
    }



}
