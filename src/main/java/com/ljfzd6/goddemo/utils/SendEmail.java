package com.ljfzd6.goddemo.utils;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class SendEmail {
    /**
     * @param email：接收邮件的地址
     * @param emailMsg：发送邮件的内容
     * @throws AddressException
     * @throws MessagingException
     * @Title: sendMail
     * @Description: 实现发送邮件
     */
    public  void sendMail(String email, String emailMsg)
            throws AddressException, MessagingException {
        String myemail="1650548543@qq.com";
        // 1.创建一个程序与邮件服务器会话对象 Session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        //163邮箱设置     props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.host", "smtp.qq.com"); //qq邮箱设置
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true
        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //自己的邮箱账号和密码,不需要@qq.com,纯qq账号，qq邮箱开启pop3/smtp时会给你一个授权码此授权码就是你登入邮箱的密码
                return new PasswordAuthentication("1650548543", "sgenjtyqkvohdfdf");
            }
        };
        Session session = Session.getInstance(props, auth);
        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myemail)); // 设置发送者（自己的邮箱账号）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者
        //邮件标题
        message.setSubject("这里应该填写的是邮件标题");
        message.setContent(emailMsg, "text/html;charset=utf-8");
        // 3.创建 Transport用于将邮件发送
        Transport.send(message);
    }
}
