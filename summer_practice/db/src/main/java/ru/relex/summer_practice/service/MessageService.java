package ru.relex.summer_practice.service;

import ru.relex.summer_practice.dao.Impl.MessageDoaImpl;
import ru.relex.summer_practice.db.Lecture;
import ru.relex.summer_practice.db.Message;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Sasha on 28.07.2015.
 */

@Stateless
public class MessageService extends MessageDoaImpl {

    @Override
    protected void closeEntityManager() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @PersistenceContext(unitName = "PERSISTENCEUNIT")
    protected EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Message> ReadAllByLecture(Lecture lecture) {
        return super.ReadAllByLecture(lecture);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Message Create(Message message) {
        return super.Create(message);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Message Read(Long id) {
        return super.Read(id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Message> ReadAll() {
        return super.ReadAll();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Message Update(Message message) {
        return super.Update(message);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void Delete(Long id) {
        super.Delete(id);
    }
}
