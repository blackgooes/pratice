package com.md5.demo;

import static com.md5.demo.PasswordUtil.generate;
import static com.md5.demo.PasswordUtil.verify;

public class Main {
    public static void main(String[] args) {
        // 加密+加盐
        String password1 = generate("admin");
        System.out.println("结果：" + password1 + "   长度："+ password1.length());
        // 解码
        System.out.println(verify("admin", password1));
        // 加密+加盐
        String password2= generate("admin");
        System.out.println("结果：" + password2 + "   长度："+ password2.length());
        // 解码
        System.out.println(verify("admin", password2));
    }
}
