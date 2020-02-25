package Pojo;

import java.util.List;

public class Notification {
    private String name;
    private String type;
    private String schoolId;
    private String description;
    private Boolean active;
    private Boolean sendSms;
    private Integer sendSMSDaysBefore;
    private String sms;
    private Boolean sendEmail;
    private Integer sendEmailDaysBefore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getSendSms() {
        return sendSms;
    }

    public void setSendSms(Boolean sendSms) {
        this.sendSms = sendSms;
    }

    public Integer getSendSMSDaysBefore() {
        return sendSMSDaysBefore;
    }

    public void setSendSMSDaysBefore(Integer sendSMSDaysBefore) {
        this.sendSMSDaysBefore = sendSMSDaysBefore;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public Integer getSendEmailDaysBefore() {
        return sendEmailDaysBefore;
    }

    public void setSendEmailDaysBefore(Integer sendEmailDaysBefore) {
        this.sendEmailDaysBefore = sendEmailDaysBefore;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    private List<Email> email;

}