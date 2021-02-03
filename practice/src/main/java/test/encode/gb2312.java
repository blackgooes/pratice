package test.encode;

import java.io.UnsupportedEncodingException;

public class gb2312 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String gb = "";
        byte[] bytes = gb.getBytes("gb2312");// 先把字符串按gb2312转成byte数组
        StringBuilder gbString = new StringBuilder();
        for (byte b : bytes)// 循环数组
        {
            String temp = Integer.toHexString(b);// 再用Integer中的方法，把每个byte转换成16进制输出
            temp = temp.substring(6, 8); // 截取
            gbString.append("%" + temp);
        }
        System.out.println(gbString);
    }
}
