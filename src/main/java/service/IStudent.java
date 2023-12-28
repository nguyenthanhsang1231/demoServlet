package service;

import java.util.ArrayList;
import java.util.Comparator;

public interface IStudent<E> extends Comparator<E> {
    void add(E e);
    void update(int id, E e);
    boolean delete (int id);
    ArrayList<E> findAll();
    E findById(int id);

    ArrayList<E> findByName(String name);
}
