package com.gary.tester.mock;

import java.util.Locale;

public class HelloJMockit {

    public String sayHello() {
        Locale locale = Locale.getDefault();
        if (locale.equals(Locale.CHINA)) {
            // 在中国，就说中文
            return "你好世界";
        } else {
            // 在其它国家，就说英文
            return "Hello World";
        }
    }
}
