package me.codebase.es.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_risk_slot_city_statis
 */
public class RiskSlotCityStatisDto implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 日期
     */
    private Date curDate;

    /**
     * 广告位ID
     */
    private Long slotId;

    /**
     * 媒体ID
     */
    private Long appId;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 访问占比 该city广告位访问PV/当天广告位访问总PV
     */
    private Double visitRate;

    /**
     * 该city广告位访问uv
     */
    private Long sdkUv;

    /**
     * 该city活动参与pv
     */
    private Long participatePv;

    /**
     * 该city活动参与uv
     */
    private Long participateUv;

    /**
     * 该city发劵量
     */
    private Long launchCount;

    /**
     * 该city劵曝光量
     */
    private Long exposureCount;

    /**
     * 该city点击pv
     */
    private Long clickCount;

    /**
     * ctr=该city点击pv/该city劵曝光量
     */
    private Double ctr;

    /**
     * 该city落地页访问pv
     */
    private Long promoteVisitPv;

    /**
     * 该city落地页访问uv
     */
    private Long promoteVisitUv;

    /**
     * 该city落地页转化pv
     */
    private Long effectPv;

    /**
     * cvr=该city落地页转化PV/该city落地页访问PV
     */
    private Double cvr;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * tb_risk_slot_city_statis
     */
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCurDate() {
        return curDate;
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Double getVisitRate() {
        return visitRate;
    }

    public void setVisitRate(Double visitRate) {
        this.visitRate = visitRate;
    }

    public Long getSdkUv() {
        return sdkUv;
    }

    public void setSdkUv(Long sdkUv) {
        this.sdkUv = sdkUv;
    }

    public Long getParticipatePv() {
        return participatePv;
    }

    public void setParticipatePv(Long participatePv) {
        this.participatePv = participatePv;
    }

    public Long getParticipateUv() {
        return participateUv;
    }

    public void setParticipateUv(Long participateUv) {
        this.participateUv = participateUv;
    }

    public Long getLaunchCount() {
        return launchCount;
    }

    public void setLaunchCount(Long launchCount) {
        this.launchCount = launchCount;
    }

    public Long getExposureCount() {
        return exposureCount;
    }

    public void setExposureCount(Long exposureCount) {
        this.exposureCount = exposureCount;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Double getCtr() {
        return ctr;
    }

    public void setCtr(Double ctr) {
        this.ctr = ctr;
    }

    public Long getPromoteVisitPv() {
        return promoteVisitPv;
    }

    public void setPromoteVisitPv(Long promoteVisitPv) {
        this.promoteVisitPv = promoteVisitPv;
    }

    public Long getPromoteVisitUv() {
        return promoteVisitUv;
    }

    public void setPromoteVisitUv(Long promoteVisitUv) {
        this.promoteVisitUv = promoteVisitUv;
    }

    public Long getEffectPv() {
        return effectPv;
    }

    public void setEffectPv(Long effectPv) {
        this.effectPv = effectPv;
    }

    public Double getCvr() {
        return cvr;
    }

    public void setCvr(Double cvr) {
        this.cvr = cvr;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", curDate=").append(curDate);
        sb.append(", slotId=").append(slotId);
        sb.append(", appId=").append(appId);
        sb.append(", city=").append(city);
        sb.append(", visitRate=").append(visitRate);
        sb.append(", sdkUv=").append(sdkUv);
        sb.append(", participatePv=").append(participatePv);
        sb.append(", participateUv=").append(participateUv);
        sb.append(", launchCount=").append(launchCount);
        sb.append(", exposureCount=").append(exposureCount);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", ctr=").append(ctr);
        sb.append(", promoteVisitPv=").append(promoteVisitPv);
        sb.append(", promoteVisitUv=").append(promoteVisitUv);
        sb.append(", effectPv=").append(effectPv);
        sb.append(", cvr=").append(cvr);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append("]");
        return sb.toString();
    }
}