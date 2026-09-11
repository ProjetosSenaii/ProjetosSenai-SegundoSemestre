package com.senai.infob.rental.models;

public record AuthRequest(
    String username, 
    String email, 
    String password) {}
