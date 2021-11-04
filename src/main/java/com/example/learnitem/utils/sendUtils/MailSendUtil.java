package com.example.learnitem.utils.sendUtils;

import com.example.learnitem.config.SystemObject;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.URLDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.utils.sendUtils
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-04 09:58.
 * @Description: 邮件管理
 */

@Component
public class MailSendUtil {


    private final JavaMailSender mailSender;

    private final ResourceLoader resourceLoader;

    @Autowired(required = false)
    public MailSendUtil(JavaMailSender mailSender, ResourceLoader resourceLoader) {
        this.mailSender = mailSender;
        this.resourceLoader = resourceLoader;
    }

    /**
     * 发送单一用户
     *
     * @param toMail  收件人地址
     * @param subject 标题
     * @param content 内存
     */
    public void simpleSend(String toMail, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toMail);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(SystemObject.mailConfig.getUserName());
        this.mailSender.send(message);
    }

    /**
     * 发送 多个地址，并抄送多人，同时隐身抄送多人
     *
     * @param toMail   收件人地址
     * @param ccMails  抄送人地址
     * @param bccMails 隐形抄送地址 不会出现在地址栏
     * @param subject  标题
     * @param content  内容
     */
    public void simpleSend(String[] toMail, String[] ccMails, String[] bccMails, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toMail);
        message.setCc(ccMails);
        message.setBcc(bccMails);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(SystemObject.mailConfig.getUserName());
        this.mailSender.send(message);
    }

    /**
     * 使用 MimeMessagePreparator  回掉接口來发送html 同时 也可以使用 MimeMessageHelper
     *
     * @param toMail  收件人地址
     * @param subject 标题
     * @param content html内容
     */
    public void sendWithHtml(String toMail, String subject, String content) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
                mimeMessage.setSubject(subject);
                mimeMessage.setFrom(new InternetAddress(SystemObject.mailConfig.getUserName()));
                mimeMessage.setText(content, StandardCharsets.UTF_8.name(), "html");
            }
        };
        this.mailSender.send(preparator);
    }

    /**
     * 发送带有附件的邮件
     *
     * @param toMail  收件人地址
     * @param subject 主题（标题）
     * @param content 内容
     * @param files   附件
     */
    public void sendWithAttachemnt(String toMail, String subject, String content, List<Map<String, String>> files) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(toMail);
            helper.setSubject(subject);
            //支持发送html setText(String text, boolean html)
            helper.setText(content);
            helper.setFrom(SystemObject.mailConfig.getUserName());
            for (Map<String, String> file : files) {
                Resource resource = resourceLoader.getResource(file.get("url"));
                helper.addAttachment(file.get("fileName"), resource);
            }
            this.mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
