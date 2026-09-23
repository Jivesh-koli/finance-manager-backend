package com.jivesh.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Expense> expenses;

    // getter
    public Long getId(){
        return id;
    }

    public String getName (){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    // setter
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public void setPassword (String password){
        this.password = password;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}