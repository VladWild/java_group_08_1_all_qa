package ru.yandex.qa.db.db.dao;

import ru.yandex.qa.db.db.model.base.StorageData;

import java.util.List;

/**
 * Хранилище, которое умеет делать типичнве CRUD операции с сущностью в бд
 * Дженерики:
 * @param <T> - объект модели, с помощью которого происходят манипуляции в сервисе и в бд
 * @param <K> - тип ключа у объекта модели для соответствующего id'шника в бд
 */
public interface Storage<T extends StorageData<K>, K> {

    void save(T data);

    void update(T data);

    T get(K id);

    void delete(K id);

    List<T> getAll();
}
