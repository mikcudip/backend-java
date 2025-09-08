package core;

import java.util.List;

public interface IDAO<T> {
  T save(T t);
  Boolean delete(Long id);
  T find(Long id);
  public List<T> findAll();
}
