/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bill;

import java.time.LocalDate;

/**
 *
 * @author Hảii Dươnq
 */
public class Bill {
    private int Id;
    private int Id_Reader;
    private LocalDate DateIssue;
    private LocalDate DateReturn;
    private boolean Status;
    
    public Bill() {
    }

    public Bill(int Id, float Deposit, LocalDate DateIssue, LocalDate DateReturn, boolean Status) {
        this.Id = Id;
        this.Id_Reader = Id_Reader;
        this.DateIssue = DateIssue;
        this.DateReturn = DateReturn;
        this.Status = Status;
    }

    public Bill(int Id_Reader, LocalDate DateIssue, LocalDate DateReturn, boolean Status) {
        this.Id_Reader = Id_Reader;
        this.DateIssue = DateIssue;
        this.DateReturn = DateReturn;
        this.Status = Status;
    }

    public Bill(int Id, boolean Status) {
        this.Id = Id;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId_Reader() {
        return Id_Reader;
    }

    public void setId_Reader(int Id_Reader) {
        this.Id_Reader = Id_Reader;
    }
    
    public LocalDate getDateIssue() {
        return DateIssue;
    }

    public void setDateIssue(LocalDate DateIssue) {
        this.DateIssue = DateIssue;
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
