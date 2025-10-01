package com.dh.dentalclinicmvc.service;

import java.util.List;

public interface BaseService<T, ID> {
  public T save(T entity);

  public T findById(ID id);

  public void update(T dentist);

  public void delete(ID id);

  public List<T> findAll();
}
