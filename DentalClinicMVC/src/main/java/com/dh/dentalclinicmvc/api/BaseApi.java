package com.dh.dentalclinicmvc.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseApi<T, ID> {
  ResponseEntity<T> save(T entity);

  ResponseEntity<T> findById(ID id);

  void update(T entity);

  void delete(ID id);

  ResponseEntity<List<T>> findAll();
}
