package indi.viyoung.viboot.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 邮件实体类
 * @author vi
 * @since 2019/07/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

    /**
     * 邮件发送人
     */
    private String from;
    /**
     * 邮件接收人
     */
    private String to;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 邮件主题
     */
    private String type;

    /**
     * 发送邮件模板时的模板文件名
     */
    private String templateName;

    /**
     * 模板参数
     */
    private Map<String,Object> variables;

    /**
     * 附件地址
     */
    private String attachPath;



}
