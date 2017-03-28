package com.chquedoll.domain.entity;

/**
 * Created by super-zuo on 17-3-22.
 */

public class PromotionEntity {

    /**
     * startTime : 1479945600000
     * endTime : 1480402800000
     * type : 1
     * promotionPrice : null
     * serverTime : 1490088853701
     * usdPromotionPrice : {"amount":"5.00","unit":"$"}
     * icon : https://s3-us-west-2.amazonaws.com/image.chic-fusion.com/icon/black55555-14.jpg
     * enabled : false
     * isAppOnly : false
     */

    private long startTime;
    private long endTime;
    private String type;
    private PriceEntity promotionPrice;
    private long serverTime;
    private PriceEntity usdPromotionPrice;
    private String icon;
    private boolean enabled;
    private boolean isAppOnly;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PriceEntity getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(PriceEntity promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public PriceEntity getUsdPromotionPrice() {
        return usdPromotionPrice;
    }

    public void setUsdPromotionPrice(PriceEntity usdPromotionPrice) {
        this.usdPromotionPrice = usdPromotionPrice;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isIsAppOnly() {
        return isAppOnly;
    }

    public void setIsAppOnly(boolean isAppOnly) {
        this.isAppOnly = isAppOnly;
    }

}
