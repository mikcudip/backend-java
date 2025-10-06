package com.dh.dentalclinicmvc.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BaseApi<T, ID> {
  ResponseEntity<T> save(T entity);

  ResponseEntity<T> findById(ID id);

  ResponseEntity<String> update(T entity);

  ResponseEntity<String> deleteById(ID id);

  ResponseEntity<List<T>> findAll();
}
