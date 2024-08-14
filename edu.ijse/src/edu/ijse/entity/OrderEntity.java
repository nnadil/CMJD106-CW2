/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.entity;

/**
 *
 * @author MSI
 */
public class OrderEntity {
    private String borrowindId;
    private String memberId;
    private String bookId;
    private String borrowDate;
    private String dueDate;

    public OrderEntity() {
    }

    public OrderEntity(String borrowindId, String memberId, String bookId, String borrowDate, String dueDate) {
        this.borrowindId = borrowindId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    /**
     * @return the borrowindId
     */
    public String getBorrowindId() {
        return borrowindId;
    }

    /**
     * @param borrowindId the borrowindId to set
     */
    public void setBorrowindId(String borrowindId) {
        this.borrowindId = borrowindId;
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
     * @return the bookId
     */
    public String getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the borrowDate
     */
    public String getBorrowDate() {
        return borrowDate;
    }

    /**
     * @param borrowDate the borrowDate to set
     */
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     * @return the dueDate
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "LibraryEntity{" + "borrowindId=" + borrowindId + ", memberId=" + memberId + ", bookId=" + bookId + ", borrowDate=" + borrowDate + ", dueDate=" + dueDate + '}';
    }
    
}
