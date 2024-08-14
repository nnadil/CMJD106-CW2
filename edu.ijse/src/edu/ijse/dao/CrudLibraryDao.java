/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.dao;

import java.util.ArrayList;

/**
 *
 * @author MSI
 */


public interface CrudLibraryDao<T,ID>extends SuperDao{
    T get(ID id,ID bd)throws Exception;
    boolean update(T t)throws Exception;
}
