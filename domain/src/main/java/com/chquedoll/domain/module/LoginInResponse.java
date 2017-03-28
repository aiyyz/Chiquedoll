package com.chquedoll.domain.module;

import java.util.List;

/**
 * Class that represents a LoginInResponse in the domain layer.
 */

public class LoginInResponse {


    private String accessToken;
    private CustomerBean customer;
    private boolean needShowPickUp;
    private String inviteFriendUrl;
    private List<WannaListsBean> wannaLists;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public CustomerBean getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBean customer) {
        this.customer = customer;
    }

    public boolean isNeedShowPickUp() {
        return needShowPickUp;
    }

    public void setNeedShowPickUp(boolean needShowPickUp) {
        this.needShowPickUp = needShowPickUp;
    }

    public String getInviteFriendUrl() {
        return inviteFriendUrl;
    }

    public void setInviteFriendUrl(String inviteFriendUrl) {
        this.inviteFriendUrl = inviteFriendUrl;
    }

    public List<WannaListsBean> getWannaLists() {
        return wannaLists;
    }

    public void setWannaLists(List<WannaListsBean> wannaLists) {
        this.wannaLists = wannaLists;
    }

    public static class CustomerBean {


        private String id;
        private NameBean name;
        private String email;
        private String birthday;
        private int gender;
        private Object fbId;
        private Object googleId;
        private int points;
        private String invitationCode;
        private CurrencyBean currency;
        private int useCouponCount;
        private String oceamQuickpayId;
        private String communicationEmail;
        private Object deepLink;
        private Object networkStarStatus;
        private Object networkStarInfo;
        private boolean isNotRemindComment;
        private boolean isExistOceamQuickpayId;
        private List<String> favouriteCategoryIds;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public NameBean getName() {
            return name;
        }

        public void setName(NameBean name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public Object getFbId() {
            return fbId;
        }

        public void setFbId(Object fbId) {
            this.fbId = fbId;
        }

        public Object getGoogleId() {
            return googleId;
        }

        public void setGoogleId(Object googleId) {
            this.googleId = googleId;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public CurrencyBean getCurrency() {
            return currency;
        }

        public void setCurrency(CurrencyBean currency) {
            this.currency = currency;
        }

        public int getUseCouponCount() {
            return useCouponCount;
        }

        public void setUseCouponCount(int useCouponCount) {
            this.useCouponCount = useCouponCount;
        }

        public String getOceamQuickpayId() {
            return oceamQuickpayId;
        }

        public void setOceamQuickpayId(String oceamQuickpayId) {
            this.oceamQuickpayId = oceamQuickpayId;
        }

        public String getCommunicationEmail() {
            return communicationEmail;
        }

        public void setCommunicationEmail(String communicationEmail) {
            this.communicationEmail = communicationEmail;
        }

        public Object getDeepLink() {
            return deepLink;
        }

        public void setDeepLink(Object deepLink) {
            this.deepLink = deepLink;
        }

        public Object getNetworkStarStatus() {
            return networkStarStatus;
        }

        public void setNetworkStarStatus(Object networkStarStatus) {
            this.networkStarStatus = networkStarStatus;
        }

        public Object getNetworkStarInfo() {
            return networkStarInfo;
        }

        public void setNetworkStarInfo(Object networkStarInfo) {
            this.networkStarInfo = networkStarInfo;
        }

        public boolean isIsNotRemindComment() {
            return isNotRemindComment;
        }

        public void setIsNotRemindComment(boolean isNotRemindComment) {
            this.isNotRemindComment = isNotRemindComment;
        }

        public boolean isIsExistOceamQuickpayId() {
            return isExistOceamQuickpayId;
        }

        public void setIsExistOceamQuickpayId(boolean isExistOceamQuickpayId) {
            this.isExistOceamQuickpayId = isExistOceamQuickpayId;
        }

        public List<String> getFavouriteCategoryIds() {
            return favouriteCategoryIds;
        }

        public void setFavouriteCategoryIds(List<String> favouriteCategoryIds) {
            this.favouriteCategoryIds = favouriteCategoryIds;
        }

        public static class NameBean {
            /**
             * firstName : kite
             * lastName : q
             */

            private String firstName;
            private String lastName;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
        }

        public static class CurrencyBean {
            /**
             * label : 美元
             * value : USD
             */

            private String label;
            private String value;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }

    public static class WannaListsBean {

        private String id;
        private String name;
        private List<String> productIds;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getProductIds() {
            return productIds;
        }

        public void setProductIds(List<String> productIds) {
            this.productIds = productIds;
        }
    }
}
