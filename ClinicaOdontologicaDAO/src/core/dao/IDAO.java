package core.dao;

import java.util.List;

public interface IDAO<T> {
  T save(T t);
  Boolean update(T t);
  Boolean delete(Long id);
  T findById(Long id);
  List<T> findAll();
}
