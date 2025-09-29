package com.dh.dentalclinicmvc.dao;

import java.util.List;

public interface IDAO<T> {
  T save(T entity);

  T findById(Long id);

  void update(T entity);

  void delete(Long id);

  List<T> findAll();

  T findByString(String value);
}
