package de.tudarmstadt.informatik.tk.android.assistance.sdk.provider.dao;

import java.util.List;

/**
 * @author Wladimir Schmidt (wlsc.dev@gmail.com)
 * @date 22.11.2015
 */
public interface CommonDao<T> {

    List<T> getAll();

    List<T> getFirstN(int amount);

    List<T> getLastN(int amount);

    long insert(T dbItem);

    void insert(List<T> dbItems);

    void update(T dbItem);

    void update(List<T> dbItems);

    void delete(T dbItem);

    void delete(List<T> dbItems);
}