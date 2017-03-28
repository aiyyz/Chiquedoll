package com.chquedoll.domain.entity;

import java.util.List;

/**
 * Created by super-zuo on 17-3-22.
 */

public class ProductEntity {

    /**
     * id : 71dae7cf-84ca-4292-b719-0cd52a6b5d23
     * name : NSKU003 10
     * description : Test1
     * sizingReference : null
     * parentSku : NSKU003
     * brand : null
     * pcMainImage : 71dae7cf-84ca-4292-b719-0cd52a6b5d23
     * pcMainImage2 : null
     * extraImages : ["71dae7cf-84ca-4292-b719-0cd52a6b5d23-0","71dae7cf-84ca-4292-b719-0cd52a6b5d23-1","71dae7cf-84ca-4292-b719-0cd52a6b5d23-2"]
     * mainImageWidth : 800
     * mainImageHeight : 800
     * variants : [{"id":"882718f1-81db-411b-b480-a1a4279cab9b","inventory":3,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"Gray","size":"S","sku":"NSKU003-S-Gray","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23-0","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"6e4cd592-3210-4c43-a39d-8e01d2639bf8","inventory":384,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"Gray-blue","size":"S","sku":"NSKU003-S-Gray-blue","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23-1","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"9811b1e3-3302-4734-b6e9-008dcf128dec","inventory":384,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"White","size":"S","sku":"NSKU003-S-White","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"606277eb-c080-4b35-8df9-c4af2793a1f5","inventory":281,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"Gray","size":"M","sku":"NSKU003-M-Gray","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23-0","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"0fa3e06c-1735-4fcc-ae2b-ad2b0a53a9eb","inventory":384,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"Gray-blue","size":"M","sku":"NSKU003-M-Gray-blue","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23-1","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"5a47710f-e130-41ad-a438-fad4ef83fdf8","inventory":383,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"White","size":"M","sku":"NSKU003-M-White","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"0a7a75d3-cf36-4314-96c3-d236ec2cdad5","inventory":372,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"Gray","size":"L","sku":"NSKU003-L-Gray","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23-0","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"545c5da0-76b7-4756-a521-04bc3361d673","inventory":382,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"Gray-blue","size":"L","sku":"NSKU003-L-Gray-blue","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23-1","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"e5bb2fb8-a96c-474d-a854-3ba00fb02aaf","inventory":381,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"White","size":"L","sku":"NSKU003-L-White","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"3b401a8a-43ff-4947-bb92-a7852920987b","inventory":385,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"Gray","size":"XL","sku":"NSKU003-XL-Gray","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23-0","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"34840efb-0309-48db-9532-1c5491e74c4b","inventory":385,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"Gray-blue","size":"XL","sku":"NSKU003-XL-Gray-blue","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23-1","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null},{"id":"72b22c0a-8f03-4e99-9a5a-49857c6dda7e","inventory":386,"promotionPrice":null,"price":{"amount":"11.99","unit":"$"},"shippingPrice":{"amount":"0.00","unit":"$"},"shippingTime":null,"color":"White","size":"XL","sku":"NSKU003-XL-White","msrp":{"amount":"20.99","unit":"$"},"status":"1","image":"71dae7cf-84ca-4292-b719-0cd52a6b5d23","description":null,"domesticDelivery":{"countryCode":null,"warehouseId":null,"inventory":0,"icon":null,"enabled":false,"message":"<font color='#00a0e9'>FREE SHIPPING WORLDWIDE<\/font>"},"unifiedId":null}]
     * numberSaves : 8
     * numberSold : 555
     * storeId : 1C49479a6S298u2y8Y3M0v6B0k
     * productCategoryIds : ["1m4Z3u7r0x5Y0J8t8D5o2g6r5T","1b4c3V7a0s5X1l0d3S7k7v3K2j"]
     * status : 1
     * promotion : {"startTime":1479945600000,"endTime":1480402800000,"type":"1","promotionPrice":null,"serverTime":1490088853701,"usdPromotionPrice":{"amount":"5.00","unit":"$"},"icon":"https://s3-us-west-2.amazonaws.com/image.chic-fusion.com/icon/black55555-14.jpg","enabled":false,"isAppOnly":false}
     * freeShippingPromotion : null
     * sizeChart : http://www.chicme.xyz/f/mobile/size
     * advertisementImages : null
     * description2 : Test1
     * groupId : null
     * serverTime : 1490088853701
     * shippingPrice : null
     * price : {"amount":"11.99","unit":"$"}
     * msrp : {"amount":"20.99","unit":"$"}
     * pcExtraImageUrls : ["71dae7cf-84ca-4292-b719-0cd52a6b5d23-0","71dae7cf-84ca-4292-b719-0cd52a6b5d23-1","71dae7cf-84ca-4292-b719-0cd52a6b5d23-2"]
     * usdPrice : {"amount":"11.99","unit":"$"}
     * isPC : false
     * isMsiteHidden : false
     * isAutoInventory : false
     * isSelfSupport : false
     * isPresell : false
     * isShoe : false
     * isFlashDeals : false
     */

    public String id;
    public String name;
    public String description;
    public String sizingReference;
    public String parentSku;
    public String brand;
    public String pcMainImage;
    public String pcMainImage2;
    public int mainImageWidth;
    public int mainImageHeight;
    public int numberSaves;
    public int numberSold;
    public String storeId;
    public String status;
    public PromotionEntity promotion;
    public Object freeShippingPromotion;
    public String sizeChart;
    public String  advertisementImages;
    public String description2;
    public String  groupId;
    public long serverTime;
    public PriceEntity shippingPrice;
    public PriceEntity price;
    public PriceEntity msrp;
    public PriceEntity usdPrice;
    public boolean isPC;
    public boolean isMsiteHidden;
    public boolean isAutoInventory;
    public boolean isSelfSupport;
    public boolean isPresell;
    public boolean isShoe;
    public boolean isFlashDeals;
    public List<String> extraImages;
    public List<VariantEntity> variants;
    public List<String> productCategoryIds;
    public List<String> pcExtraImageUrls;




}
