# Gehtsoft Entrance Test - Java Console Application

Project Description

This is a Java console application created as part of the Gehtsoft Entrance Test. It implements two main functionalities:

1. **Caesar Cipher Encryption/Decryption**
2. **Arithmetic Expression Evaluator**

The application supports English and Russian text input, handles different shift values, and evaluates mathematical expressions with standard operator precedence.

Requirements

- Java 8 or higher
- Terminal / Command Prompt


My Approach and Assumptions
Caesar Cipher

Supports Cyrillic (А–Я, а–я) and Latin (A–Z, a–z) alphabets

Preserves uppercase/lowercase

Wraps around alphabet correctly

Keeps non-letter characters unchanged

Works with positive and negative shift values

Arithmetic Evaluator

Supports basic operations: +, -, *, /

Handles nested parentheses

Supports decimal and negative numbers

Follows operator precedence (PEMDAS/BODMAS)

Detects division by zero and returns an error message

Examples
Encryption 

Input: Hello World
Shift: 3
Output: Khoor Zruog
Encryption (Russian)

Input: Привет Мир
Shift: 5
Output: Хумёзй Рну

Input: Khoor Zruog
Shift: 3
Output: Hello World
Arithmetic Evaluator

Input: 2 + 3 * 4
Output: 14

Input: (10 + 5) / 3
Output: 5

Input: 2 * (3 + 4) - 1
Output: 13

Input: -5 + 3
Output: -2
Menu Structure

Welcome to Gehtsoft Technical Assessment
Please choose an option:
1. Caesar Cipher Encryption
2. Caesar Cipher Decryption  
3. Arithmetic Expression Evaluation
4. Exit
Author Information
Full Name: Almas Zhaksykeldi
Email: almasikou@gmail.com
