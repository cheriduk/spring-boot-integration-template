package com.gary.tester.mock;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class HelloJMockitTest {
    @Test
    public void sayHelloCH() {
        new Expectations(Locale.class) {
            {
                Locale.getDefault();
                result = Locale.CHINA;
            }
        };
        // 断言说中文
        Assert.assertTrue("你好世界".equals((new HelloJMockit()).sayHello()));
    }

    @Test
    public void sayHelloUS() {
        new Expectations(Locale.class) {
            {
                Locale.getDefault();
                result = Locale.US;
            }
        };
        // 断言说英文
        Assert.assertTrue("Hello World".equals((new HelloJMockit()).sayHello()));
    }

    @Mocked
    HelloJMockit helloJMockit;

    @Test
    public void sayHello1() {
        // 录制(Record)
        new Expectations() {
            {
                helloJMockit.sayHello();
                // 期待上述调用的返回是"hello,david"，而不是返回实际返回值
                result = "hello david";
            }
        };
        // 重放(Replay)
        String msg = helloJMockit.sayHello();
        Assert.assertTrue(msg.equals("hello david"));
        // 验证(Verification)
        new Verifications() {
            {
                helloJMockit.sayHello();
                // 验证helloJMockit.sayHello()这个方法调用了1次
                times = 1;
            }
        };
    }
}
