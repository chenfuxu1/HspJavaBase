package chapter21.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/13 23:13
 * <p>
 * InetAddress 类
 * 相关方法
 **/
public class API {
    public static void main(String[] args) throws UnknownHostException {
        // 1.getLocalHost 获取本机 InetAddress
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); // cfx/192.168.1.6

        // 2.根据指定主机名 / 域名获取 ip 地址对象 getByName
        InetAddress byName1 = InetAddress.getByName("cfx");
        System.out.println(byName1);
        InetAddress byName2 = InetAddress.getByName("www.baidu.com");
        System.out.println(byName2); // www.baidu.com/36.152.44.96

        // 3.获取 InetAddress 对象的主机名 getHostName
        String hostName = byName1.getHostName();
        System.out.println(hostName); // cfx

        // 4.获取 InetAddress 对象的ip地址 getHostAddress
        String hostAddress1 = byName1.getHostAddress();
        System.out.println(hostAddress1); // 192.168.1.6
        String hostAddress2 = byName2.getHostAddress();
        System.out.println(hostAddress2); // 36.152.44.96
    }
}
