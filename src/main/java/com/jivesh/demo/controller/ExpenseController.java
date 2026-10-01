package com.jivesh.demo.controller;


import com.jivesh.demo.dto.ExpenseRequest;
import com.jivesh.demo.dto.ExpenseResponse;
import com.jivesh.demo.dto.ExpenseUpdateRequest;
import com.jivesh.demo.entity.Expense;
import com.jivesh.demo.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

// here i did import com.jivesh.demo.Expense.ExpenseNotFoundException; it was ment to be done in service file so rembmber to fix it

import java.util.ArrayList;
import java.util.List;


@RestController
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public List<ExpenseResponse> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        List<ExpenseResponse> responses = new ArrayList<>();

        for (Expense expense : expenses) {
            responses.add(toResponse(expense));
        }

        return responses;
    }

    @PostMapping("/expenses")
    public ExpenseResponse createExpense(@Valid @RequestBody ExpenseRequest request) {
        
        Expense expense = new Expense();
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());

        Expense saved = expenseService.addExpenseToUser(request.getUserId(), expense);
        return toResponse(saved);


    }
    @GetMapping("/expenses/{id}")
    public ExpenseResponse getExpenseById(@PathVariable Long id) {
        Expense expense = expenseService.getExpenseById(id);
        return toResponse(expense);
    }

    @PutMapping("/expenses/{id}")
    public ExpenseResponse updateExpense(@PathVariable Long id,
                                         @RequestBody @Valid  ExpenseUpdateRequest request) {
        return toResponse(expenseService.updateExpense(id, request));
    }

    @DeleteMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("/users/{userId}/expenses")
    public List<ExpenseResponse> getExpensesByUserId(@PathVariable Long userId) {

        List<Expense> expenses = expenseService.getExpensesByUserId(userId);
        List<ExpenseResponse> responses = new ArrayList<>();

        for (Expense expense : expenses) {
            responses.add(toResponse(expense));
        }

        return responses;
    }

    @GetMapping("/expenses/category/{category}")
    public List<Expense> getExpensesByCategory(@PathVariable String category) {
        return expenseService.getExpensesByCategory(category);
    }

    private ExpenseResponse toResponse(Expense e) {

        ExpenseResponse response = new ExpenseResponse();   // naya dabba

        response.setId(e.getId());
        response.setAmount(e.getAmount());
        response.setCategory(e.getCategory());
        response.setUserId(e.getUser().getId());
        response.setDescription(e.getDescription());
        response.setDate(e.getDate());

        return response;
    }


}




