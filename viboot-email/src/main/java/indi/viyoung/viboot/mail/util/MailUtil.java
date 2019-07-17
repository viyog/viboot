package indi.viyoung.viboot.mail.util;

import com.mysql.cj.util.StringUtils;
import indi.viyoung.viboot.mail.entity.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

public class MailUtil {

    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);


    @Autowired
    private static JavaMailSender javaMailSender;

    @Autowired
    private static TemplateEngine templateEngine;

    /**
     * 对外开放的统一发送邮件方法
     * @param mail
     */
    public static void sendEmail(Mail mail) {
        String  type = mail.getType();
        switch (type) {
            case "1":
                sendSimpleMail(mail);
            case "2":
                sendMimeMail(mail);
        }
    }

    /**
     * 发送普通邮件
     * @param email 邮件对象
     */
    private static void sendSimpleMail(Mail email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        邮件发送人
        simpleMailMessage.setFrom(email.getFrom());
//        邮件接收人
        simpleMailMessage.setTo(email.getTo());
//        邮件主题
        simpleMailMessage.setSubject(email.getSubject());
//        邮件内容
        simpleMailMessage.setText(email.getContent());
//        发送邮件
        javaMailSender.send(simpleMailMessage);
    }

    /**
     * 发送MIME类型的邮件
     * @param email 邮件对象
     */
    private static void sendMimeMail(Mail email) {
//        生成邮件字符串
        String content = email.getContent();
        if (email.getVariables() != null) {
            content = generate(email);
        }
//        基于这个对象可以发送HTML，或者携带附件的二进制邮件
        MimeMessage message= javaMailSender.createMimeMessage();
        try {
//            构建发送模板邮件的对象
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
//            设置发送邮箱
            helper.setFrom(email.getFrom());
//            设置接收邮箱
            helper.setTo(email.getTo());
//            设置邮件名(主题)
            helper.setSubject(email.getSubject());
//            设置邮件内容
            helper.setText(content,true);
//            这里可以发送带有附件的邮件，如果没有附件可以省略，就不在多做描述
            if (!StringUtils.isNullOrEmpty(email.getAttachPath())) {
                FileSystemResource file = new FileSystemResource(new File(email.getAttachPath()));
                helper.addAttachment(file.getFilename(), file);
            }
//            发送邮件
            javaMailSender.send(message);
        } catch (MessagingException e) {

        }
    }

    /**
     * 生成模板字符串
     * @param email 邮件对象
     * @return
     */
    private static String generate(Mail email) {
        Context context = new Context();
//        设置模板参数
        context.setVariables(email.getVariables());
//        加载模板后的内容字符串
        return templateEngine.process(email.getTemplateName(), context);
    }


}
