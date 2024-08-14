/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.dao;

/**
 *
 * @author MSI
 */
public interface CrudOrderDao<T>extends SuperDao{
    boolean update(T t)throws Exception;
    boolean updateFine(Double fine,String borrowingId,String memberId)throws Exception;
}
