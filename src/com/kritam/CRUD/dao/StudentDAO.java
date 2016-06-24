/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kritam.CRUD.dao;

import com.kritam.CRUD.entity.Student;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public interface StudentDAO {
    
    boolean insert (Student s);
    boolean delete (int id);
    Student getById (int id);
    ArrayList<Student> getAll();
    int count();
}
