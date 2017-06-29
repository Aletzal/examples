package ru.sample.model;

import java.util.Date;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.annotation.PreDestroy;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import ru.sample.model.entity.Messages;
import ru.sample.model.entity.Person;

@Stateless (mappedName = "ForumWorkBean")
public class ForumFacade implements ForumWork, ForumWorkRemote{
    private long id;
    @PersistenceContext(unitName = "ForumUnit")
    private EntityManager em;
    public ForumFacade() {
        super();
    }
    public String info (){
      return "" + new Date();
    }
    @PostConstruct
    public void myInit () {
      id = System.currentTimeMillis();
      System.out.println("-------- Bean id = " + id + "-------- created " + new Date());
    }
    @PreDestroy
    public void myDestroy () {
      id = System.currentTimeMillis();
      System.out.println("-------- Bean id = " + id + "-------- destroyed " + new Date());
  }

    public Person getPerson(String user, String password) throws Exception {
//        System.out.println("***********************************************");
//        System.out.println(em);
//        System.out.println("***********************************************");
        List<Person> a = findPersonByNickAndPassword(user, password);
        if (a.size() != 1) {
            throw new Exception("No access");
        }
        Person p = a.get(0);
        p.setClicks(p.getClicks() + 1);
        em.merge(p);
        return p;
    }

    /** <code>select o from Person o where o.id=:u and o.password=:p </code> */
    public List<Person> findPersonByNickAndPassword(String u, String p) {
        return em.createNamedQuery("findPersonByNickAndPassword").setParameter("u", u).setParameter("p", p).getResultList();
    }

    public Messages persistMessages(Messages messages) {
        em.persist(messages);
        return messages;
    }

    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }
// Получает список List типа Messages
    public List<Messages> getTopTen() {
        return (List<Messages>)queryByRange("select o from Messages o order by o.d desc", 0, 20);
    }
}
