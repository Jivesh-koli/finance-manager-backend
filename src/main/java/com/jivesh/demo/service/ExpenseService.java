package com.jivesh.demo.service;

import com.jivesh.demo.dto.ExpenseRequest;

import com.jivesh.demo.dto.ExpenseUpdateRequest;
import com.jivesh.demo.entity.Expense;
import com.jivesh.demo.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.jivesh.demo.entity.User;
import com.jivesh.demo.repository.UserRepository;

import com.jivesh.demo.Expense.ExpenseNotFoundException;

import java.math.BigDecimal;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;
    private UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository,
                          UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }


    public Expense addExpenseToUser(Long userId, ExpenseRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Expense expense = new Expense();

        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());

        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, ExpenseUpdateRequest request) {
        Expense expense = getExpenseById(id);   // nahi mila to 404

        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());

        return expenseRepository.save(expense);
    }



    public void deleteExpense(Long id) {
        Expense expense = getExpenseById(id);   // yahi 404 fenkega agar nahi mila
        expenseRepository.delete(expense);

    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }


}
