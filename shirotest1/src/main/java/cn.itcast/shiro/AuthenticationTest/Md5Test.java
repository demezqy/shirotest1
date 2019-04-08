package cn.itcast.shiro.AuthenticationTest;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @ClassNAME Md5Test
 * @Description TODO
 * @Author zhengqingyou
 * @Date2019/4/8 18:18
 * @Version
 */
public class Md5Test {
    public static void main(String[] args) {
        //原始密码
        String source="111111";
        //盐
        String salt="qwerty";
        //散列次数
        int hash=2;
//Md5Hash是shiro提供的
        Md5Hash md5Hash=new Md5Hash(source,salt,hash);
        String passs_word=md5Hash.toString();
        System.out.println(passs_word);
        //36f2dfa24d0a9fa97276abbe13e596fc
    }
}
