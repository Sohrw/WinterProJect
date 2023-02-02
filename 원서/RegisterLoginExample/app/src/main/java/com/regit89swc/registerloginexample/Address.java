package com.example.moacall;

public class Address {

    private String dong;
    private String zipcode;
    private String detailAddress;

    public Address(String dong, String zipcode, String detailAddress) {
        this.dong = dong;
        this.zipcode = zipcode;
        this.detailAddress = detailAddress;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Override
    public String toString() {
        return "주소 : " + dong + " " +
                zipcode + " " +
                detailAddress;
    }
}