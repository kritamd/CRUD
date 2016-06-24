/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kritam.CRUD.controller;

import com.kritam.CRUD.dao.StudentDAO;
import com.kritam.CRUD.entity.Student;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class StudentController {

    private StudentDAO studentDAO;
    private Scanner input;

    public StudentController(StudentDAO studentDAO, Scanner input) {
        this.studentDAO = studentDAO;
        this.input = input;

    }

    public void menu() {

        System.out.println("1. Add Name");
        System.out.println("2. Delete Name");
        System.out.println("3. Search By Id");
        System.out.println("4. Show All");
        System.out.println("6. Exit");
        System.out.println("Enter Your Choice [1-6]:");

    }

    private void add() {
        while (true) {
            Student s = new Student();

            s.setId(studentDAO.count() + 1);
            System.out.println("Enter firstName:");
            s.setFirstName(input.next());
            System.out.println("Enter lastName:");
            s.setLastName(input.next());
            System.out.println("Enter Email:");
            s.setEmail(input.next());
            System.out.println("Enter Status:");
            s.setStatus(input.nextBoolean());
            studentDAO.insert(s);
            System.out.println("Do You Want to add more [y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;

            }
        }

    }

    private void delete() {

    }

    private void searchById() {
        while (true) {
            System.out.println("Enter Id to search:");
            Student student = studentDAO.getById(input.nextInt());
            if (student != null) {
                System.out.println("Id:" + student.getId());
                System.out.println("Name:" + student.getFullName());

            } else {
                System.out.println("Id not found:");

            }
            System.out.println("Do You Want to search again: [y/n]");
            if (input.next().equalsIgnoreCase("n")) {
                break;

            }
        }

    }

    private void showAll() {
        for (Student std : studentDAO.getAll()) {
            System.out.println("Id:" + std.getId());
            System.out.println("Name:" + std.getFullName());
        }
        System.out.println("Press any key to Menu:");
        input.next();

    }

    public void process() {
        menu();

        switch (input.nextInt()) {

            case 1:
                add();
                break;
            case 2:
                System.out.println("Do you want to delete:");
                if(input.next().equalsIgnoreCase("y")){
                    System.out.println("Do you really want to delete:");
                    input.next();
                }
            case 3:
                searchById();
                break;
            case 4:
                showAll();
                break;
            case 5:
                break;
            case 6:
                System.out.println("Do You Really Want to Exit");
                if (input.next().equalsIgnoreCase("y")) {
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Invaid Choice");
                break;
        }
    }
}
