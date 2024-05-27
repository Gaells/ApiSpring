package com.example.api_Java.exception;

public class ItemNotFoundException extends RuntimeException {
  public ItemNotFoundException(Long id) {
      super("Item não encontrado com ID " + id);
  }
}

