package com.dh.dentalclinicmvc.service;

import java.util.List;

public interface IBaseService<T, ID> {
  T save(T entity);

  boolean update(T dentist);

  T deleteById(ID id);

  boolean existsById(ID id);

  T findById(ID id);

  List<T> findAll();
}
