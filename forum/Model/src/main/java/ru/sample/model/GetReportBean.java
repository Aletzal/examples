package ru.sample.model;

import java.util.Date;

import javax.annotation.PostConstruct;

import javax.ejb.Local;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "GetReport", mappedName = "GetReportBean")
@Local
public class GetReportBean implements GetReportLocal {

    private Long id;

    @PersistenceContext(unitName="ForumUnit")
    private EntityManager em;

    @PostConstruct
    public void myInit () {
      id = System.currentTimeMillis();
      System.out.println("-------- GetReportBean id = " + id + "-------- created " + new Date());
    }

    public GetReportBean() {
    }
    
    public void ShowData (String s) {
      System.out.println("-------- GetReportBean id = " + id + "-------- says: " + s);
    }
}
