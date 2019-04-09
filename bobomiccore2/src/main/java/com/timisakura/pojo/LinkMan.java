package com.timisakura.pojo;

public class LinkMan {
    private Long lkmId;

    private String lkmName;

    private Long lkmCustId;

    private String lkmGender;

    private String lkmPhone;

    private String lkmMobile;

    private String lkmEmail;

    private String lkmQq;

    private String lkmPosition;

    private String lkmMemo;

    public LinkMan(Long lkmId, String lkmName, Long lkmCustId, String lkmGender, String lkmPhone, String lkmMobile, String lkmEmail, String lkmQq, String lkmPosition, String lkmMemo) {
        this.lkmId = lkmId;
        this.lkmName = lkmName;
        this.lkmCustId = lkmCustId;
        this.lkmGender = lkmGender;
        this.lkmPhone = lkmPhone;
        this.lkmMobile = lkmMobile;
        this.lkmEmail = lkmEmail;
        this.lkmQq = lkmQq;
        this.lkmPosition = lkmPosition;
        this.lkmMemo = lkmMemo;
    }

    public LinkMan() {
        super();
    }

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName == null ? null : lkmName.trim();
    }

    public Long getLkmCustId() {
        return lkmCustId;
    }

    public void setLkmCustId(Long lkmCustId) {
        this.lkmCustId = lkmCustId;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender == null ? null : lkmGender.trim();
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone == null ? null : lkmPhone.trim();
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile == null ? null : lkmMobile.trim();
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail == null ? null : lkmEmail.trim();
    }

    public String getLkmQq() {
        return lkmQq;
    }

    public void setLkmQq(String lkmQq) {
        this.lkmQq = lkmQq == null ? null : lkmQq.trim();
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition == null ? null : lkmPosition.trim();
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo == null ? null : lkmMemo.trim();
    }
}