package ru.sample.model;

import java.util.List;

import javax.ejb.Local;

import ru.sample.model.entity.Messages;
import ru.sample.model.entity.Person;

@Local
public interface ForumWork {
    String info ();

    Person getPerson(String user, String password) throws Exception;

// Убираем из интерфейса, чтобы метод стал локальным в ForumFacade
//    List<Person> findPersonByNickAndPassword(String u, String p);
//});

    Messages persistMessages(Messages messages);

    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    List<Messages> getTopTen();
}
