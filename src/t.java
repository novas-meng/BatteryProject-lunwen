import java.net.*;
import java.io.*;

public class t {
    public t() {
    }

    public static void main(String[] args) {

        try {
            String key = "牙齿疼痛"; //查询关键字
            key = URLEncoder.encode(key, "gb2312");
            URL u = new URL("http://www.baidu.com.cn/s?wd=" + key + "&cl=3");
            URLConnection conn = u.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf8"));
            String str = reader.readLine();
            while (str != null) {
                System.out.println(str);
                str = reader.readLine();
            }

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}  