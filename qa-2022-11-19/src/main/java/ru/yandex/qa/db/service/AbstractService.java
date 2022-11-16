package ru.yandex.qa.db.service;

import ru.yandex.qa.db.db.dao.Storage;
import ru.yandex.qa.db.db.model.base.StorageData;

/**
 * Абстрактный сервис, который делает типичные операции
 * (получение, сохранение, обновление, удаление) с сущностью модели
 * Дженерики:
 * @param <T> - тип объекта модели
 * @param <K> - тип ключа объекта модели
 * @param <S> - хранилище, умеющее делать CRUD операции с объетом модели
 */
public class AbstractService <T extends StorageData<K>, K, S extends Storage<T, K>> {
    protected final S storage;

    public AbstractService(S storage) {
        this.storage = storage;
    }

    public T get(K id) {
        return storage.get(id);
    }

    public T save(T data) {
        K id = storage.save(data);
        data.setId(id);
        return data;
    }

    public T update(T data) {
        storage.get(data.getId());
        storage.update(data);
        return data;
    }

    public void delete(K id) {
        storage.delete(id);
    }
}
