package com.johnverz.webdev1_g1.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " with ID " + id + " not found.");
    }
    
    public ResourceNotFoundException(String resource, int id) {
        super(resource + " with ID " + id + " not found.");
    }
}
