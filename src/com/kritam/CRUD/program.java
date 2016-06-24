/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kritam.CRUD;

import com.kritam.CRUD.controller.StudentController;
import com.kritam.CRUD.dao.StudentDAO;
import com.kritam.CRUD.dao.impl.StudentDAOImpl;
import com.kritam.CRUD.entity.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAOImpl(); 
                        
        StudentController stdController =new StudentController(studentDAO,input);
        System.out.println("Welcome to Student Management System");

        while (true) {
            stdController.process();

        }

    }

}
