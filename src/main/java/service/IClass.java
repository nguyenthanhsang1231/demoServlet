package service;

import java.util.ArrayList;

public interface IClass<E> {
    void add(E e);
    void update(int id, E e);
    boolean delete (int id);
    ArrayList<E> findAll();
    E findById(int id);
}
