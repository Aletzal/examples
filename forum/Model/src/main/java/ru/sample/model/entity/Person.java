package ru.sample.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "findPersonByNickAndPassword", query="select o from Person o where o.id=:u and o.password=:p ")
@Entity
//@NamedQueries({
//  @NamedQuery(name = "Person.findAll", query = "select o from Person o")
//})
@Table(name="users")
public class Person implements Serializable, Comparable<Person> {
    @Column(name="clicks")
    private Integer clicks;
    @Id
    @Column(name="id", nullable = false)
    private String id;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="sn")
    private String sn;

    public Person() {
    }

    public Person(Integer clicks, String id, String password, String sn) {
        this.clicks = clicks;
        this.id = id;
        this.password = password;
        this.sn = sn;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return (getSn() + " число авторизаций: " + getClicks());
    }
// Сравниваем Id дву хобъектов, переданного и из БД (вначале реализуем Comparable)
    public int compareTo(Person o) {
        return o.getId().compareTo(this.getId());
    }
}
