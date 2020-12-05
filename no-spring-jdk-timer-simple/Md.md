###JDK中的Timer和TimerTask详解

> `Timer`是jdk中提供的一个定时器工具，使用的时候会在主线程之外起一个单独的线程执行指定的计划任务，可以指定执行一次或者反复执行多次。

> `TimerTask`是一个实现了Runnable接口的抽象类，代表一个可以被Timer执行的任务。
