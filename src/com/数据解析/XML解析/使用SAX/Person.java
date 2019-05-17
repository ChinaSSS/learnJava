package com.数据解析.XML解析.使用SAX;

public class Person {

    private String Id;
    private String name;
    private String address;
    private String tel;
    private String haveGirlFriend;
    private String like;

    public Person(){}

    public Person(String id, String name, String address, String tel, String haveGirlFriend, String like) {
        Id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.haveGirlFriend = haveGirlFriend;
        this.like = like;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public String getHaveGirlFriend() {
        return haveGirlFriend;
    }

    public String getLike() {
        return like;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setHaveGirlFriend(String haveGirlFriend) {
        this.haveGirlFriend = haveGirlFriend;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public String toString() {
        String str = "personid : "+name+" " +
                "address : "+address+" tel : "+tel+" " +
                " havegrilfriend : "+haveGirlFriend+" like : "+like;
        return str;
    }
}
