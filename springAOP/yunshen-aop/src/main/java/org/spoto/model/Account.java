package org.spoto.model;

public class Account {

    private  Integer id;
    private String name;
    private String passwd;
    private Integer sex;
    private  Integer age;
    private String juese;

    public Account() {

    }

    public Account(Integer id, String name, String passwd, Integer sex, Integer age, String juese) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.sex = sex;
        this.age = age;
        this.juese = juese;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJuese() {
        return juese;
    }

    public void setJuese(String juese) {
        this.juese = juese;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", juese='" + juese + '\'' +
                '}';
    }
}

