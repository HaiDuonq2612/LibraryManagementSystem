/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillDetail;

import java.time.LocalDate;

/**
 *
 * @author Hảii Dươnq
 */
public class BillDetail {
    private int Id;
    private int Id_Bill;
    private int Id_BookDetail;
    private LocalDate DateReturn;
    private boolean Status;
    
    public BillDetail() {
    }

    public BillDetail(int Id, int Id_Bill, int Id_BookDetail, LocalDate DateReturn, boolean Status) {
        this.Id = Id;
        this.Id_Bill = Id_Bill;
        this.Id_BookDetail = Id_BookDetail;
        this.DateReturn = DateReturn;
        this.Status = Status;
    }

    public BillDetail(int Id_Bill, int Id_BookDetail, LocalDate DateReturn, boolean Status) {
        this.Id_Bill = Id_Bill;
        this.Id_BookDetail = Id_BookDetail;
        this.DateReturn = DateReturn;
        this.Status = Status;
    }

    public BillDetail(int Id, LocalDate DateReturn, boolean Status) {
        this.Id = Id;
        this.DateReturn = DateReturn;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId_Bill() {
        return Id_Bill;
    }

    public void setId_Bill(int Id_Bill) {
        this.Id_Bill = Id_Bill;
    }

    public int getId_BookDetail() {
        return Id_BookDetail;
    }

    public void setId_BookDetail(int Id_BookDetail) {
        this.Id_BookDetail = Id_BookDetail;
    }

    public LocalDate getDateReturn() {
        return DateReturn;
    }

    public void setDateReturn(LocalDate DateReturn) {
        this.DateReturn = DateReturn;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    
    
}
