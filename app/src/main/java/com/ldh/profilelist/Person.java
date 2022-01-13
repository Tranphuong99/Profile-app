package com.ldh.profilelist;

public class Person {
    private int id,avatar;
    private String name,username,email;
    private String address_street, address_suite,address_city,address_zipcode,
    address_geo_lat,address_geo_lng,
    phone,
    website,
    company_name,company_catchPhrase,company_bs;

    public Person(int id, int avatar, String name, String username, String email, String address_street, String address_suite, String address_city, String address_zipcode, String address_geo_lat, String address_geo_lng, String phone, String website, String company_name, String company_catchPhrase, String company_bs) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address_street = address_street;
        this.address_suite = address_suite;
        this.address_city = address_city;
        this.address_zipcode = address_zipcode;
        this.address_geo_lat = address_geo_lat;
        this.address_geo_lng = address_geo_lng;
        this.phone = phone;
        this.website = website;
        this.company_name = company_name;
        this.company_catchPhrase = company_catchPhrase;
        this.company_bs = company_bs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress_street() {
        return address_street;
    }

    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }

    public String getAddress_suite() {
        return address_suite;
    }

    public void setAddress_suite(String address_suite) {
        this.address_suite = address_suite;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_zipcode() {
        return address_zipcode;
    }

    public void setAddress_zipcode(String address_zipcode) {
        this.address_zipcode = address_zipcode;
    }

    public String getAddress_geo_lat() {
        return address_geo_lat;
    }

    public void setAddress_geo_lat(String address_geo_lat) {
        this.address_geo_lat = address_geo_lat;
    }

    public String getAddress_geo_lng() {
        return address_geo_lng;
    }

    public void setAddress_geo_lng(String address_geo_lng) {
        this.address_geo_lng = address_geo_lng;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_catchPhrase() {
        return company_catchPhrase;
    }

    public void setCompany_catchPhrase(String company_catchPhrase) {
        this.company_catchPhrase = company_catchPhrase;
    }

    public String getCompany_bs() {
        return company_bs;
    }

    public void setCompany_bs(String company_bs) {
        this.company_bs = company_bs;
    }
}
