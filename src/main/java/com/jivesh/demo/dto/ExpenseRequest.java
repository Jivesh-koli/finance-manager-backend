package com.jivesh.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class ExpenseRequest {

    @NotBlank(message = "add some Title to it")
    private String title;

    @NotNull(message = "add some amount")
    @Positive(message = "keep the Amount positive")
    private BigDecimal amount;



    @NotBlank
    private String category;

    private String description;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private Long userId;

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}


}



