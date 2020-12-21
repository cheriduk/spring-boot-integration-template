package com.gary.tester.mock;

public class MailSender {

    private MailWritter mailWritter;

    public boolean send() {
        String mail = mailWritter.write();
        return doSend(mail);
    }

    private boolean doSend(String mail) {
        //some code
        return true;
    }

}
