package ru.sample.model.entity;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
@SequenceGenerator(name = "newid",sequenceName = "NEW_ID",allocationSize = 1)
@NamedQueries(value = {@NamedQuery(name = "topMessages", 
                                   query = "select o from Messages o " + 
                                    "order by o.d desc")})

public class Messages implements Serializable {
    private Timestamp d;
    @Column(name="data")
    private String data;
    @Id
    @GeneratedValue(generator = "newid",strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable = false)
    private Integer id;
    @Column(name="nick")
    private String nick;
    @Column(name="text")
    private String text;

    public Messages() {
    }

    public Messages(String data, Integer id, String nick, String text) {
        this.data = data;
        this.id = id;
        this.nick = nick;
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setD(Timestamp d) {
        this.d = d;
    }

    public Timestamp getD() {
        return d;
    }

    @Override
    public String toString() {
        return getId() + " " + getD() + " " + getNick() + " " + getText();
    }
}
