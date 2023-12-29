package service;

public interface IUser<E> {
    void add(E e);
    boolean checkUser(String passWord);
}
