package com.chquedoll.domain.entity;

/**
 * Created by super-zuo on 17-3-22.
 */

public class VariantEntity  {


    /**
     * id : 882718f1-81db-411b-b480-a1a4279cab9b
     * inventory : 3
     * promotionPrice : null
     * price : {"amount":"11.99","unit":"$"}
     * shippingPrice : {"amount":"0.00","unit":"$"}
     * shippingTime : null
     * color : Gray
     * size : S
     * sku : NSKU003-S-Gray
     * msrp : {"amount":"20.99","unit":"$"}
     * status : 1
     * image : 71dae7cf-84ca-4292-b719-0cd52a6b5d23-0
     * description : null
     * domesticDelivery : {"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"}
     * unifiedId : null
     */

    public String id;
    public int inventory;
    public PriceEntity promotionPrice;
    public PriceEntity price;
    public PriceEntity shippingPrice;
    public Object shippingTime;
    public String color;
    public String size;
    public String sku;
    public PriceEntity msrp;
    public String status;
    public String image;
    public Object description;
    public DomesticDeliveryEntity domesticDelivery;
    public String unifiedId;

}
