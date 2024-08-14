/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.entity;

/**
 *
 * @author MSI
 */
public class ReturnEntity {
    private String borrowingId;
    private String memberId;
    private Double fine;

    public ReturnEntity() {
    }

    public ReturnEntity(String borrowingId, String memberId, Double fine) {
        this.borrowingId = borrowingId;
        this.memberId = memberId;
        this.fine = fine;
    }

    /**
     * @return the borrowingId
     */
    public String getBorrowingId() {
        return borrowingId;
    }

    /**
     * @param borrowingId the borrowingId to set
     */
    public void setBorrowingId(String borrowingId) {
        this.borrowingId = borrowingId;
    }

    /**
     * @return the memberId
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the fine
     */
    public Double getFine() {
        return fine;
    }

    /**
     * @param fine the fine to set
     */
    public void setFine(Double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "ReturnEntity{" + "borrowingId=" + borrowingId + ", memberId=" + memberId + ", fine=" + fine + '}';
    }
    
    
}
