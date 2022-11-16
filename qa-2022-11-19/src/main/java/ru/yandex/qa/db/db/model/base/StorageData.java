package ru.yandex.qa.db.db.model.base;

/**
 * Объект модели - с ним происходят манипуляции в сервисе и в бд
 * @param <K> - тип ключа в объекте модели
 */
public abstract class StorageData<K> {
    protected K id;

    public StorageData() {
    }

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (!(o instanceof StorageData)) {
            return false;
        } else {
            StorageData<K> that = (StorageData) o;
            if (!that.getClass().equals(this.getClass())) {
                return false;
            } else {
                return this.id != null && this.id.equals(that.id);
            }
        }
    }

    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "{id=" + this.id + '}';
    }
}
