package com.company.models;

public  class PhoneNumber {
    private PhoneNumberType phoneNumberType;
    private String phoneNumber;


    public PhoneNumber(PhoneNumberType phoneNumberType, String phoneNumber) {
        this.phoneNumberType = phoneNumberType;
        this.phoneNumber = phoneNumber;
    }
    public PhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumberType = phoneNumber.phoneNumberType;
        this.phoneNumber = phoneNumber.phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(PhoneNumberType phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    @Override
    public String toString() {
        return phoneNumberType + " " + phoneNumber;
    }
}