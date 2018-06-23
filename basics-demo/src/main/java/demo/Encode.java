package demo;

import java.nio.charset.Charset;

/**
 * @author 夏飞
 */
public class Encode {
    public static void main(String[] args) {
        String s = "商品导入";
        try {
            byte[] b = s.getBytes("UTF-8");

            String luanmta=new String(b,"iso8859-1");
            byte[] c=luanmta.getBytes("iso8859-1");
            System.out.println(new String(c,"utf-8"));
            String str = " ";
            for (int i = 0; i < b.length; i++) {
                System.out.println(b[i]);
                Integer I = new Integer(b[i]);
                String strTmp = I.toHexString(b[i]);
                if (strTmp.length() > 2)
                    strTmp = strTmp.substring(strTmp.length() - 2);
                str = str + strTmp;
            }
            System.out.println(str.toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
