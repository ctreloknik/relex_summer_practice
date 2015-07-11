package ru.relex.summer_practice.dao;

/**
 * Created by Sasha on 12.07.2015.
 */
public interface GenericCridDao <T, PK> {
    public T Create(T t);
    public T Read (PK id);
    public T Update(T t);
    public void Delete(T t);
}
