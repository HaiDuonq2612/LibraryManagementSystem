/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translator;

import java.time.LocalDate;

/**
 *
 * @author Hảii Dươnq
 */
public class Translator {
    private int Id;
    private String Name;
    private LocalDate DateBirth;
    private String Address;
    private String Description;
    private boolean Status;

    public Translator() {
    }

    public Translator(int Id, String Name, LocalDate DateBirth, String Address, String Description, boolean Status) {
        this.Id = Id;
        this.Name = Name;
        this.DateBirth = DateBirth;
        this.Address = Address;
        this.Description = Description;
        this.Status = Status;
    }

    public Translator(String Name, LocalDate DateBirth, String Address, String Description, boolean Status) {
        this.Name = Name;
        this.DateBirth = DateBirth;
        this.Address = Address;
        this.Description = Description;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public LocalDate getDateBirth() {
        return DateBirth;
    }

    public void setDateBirth(LocalDate DateBirth) {
        this.DateBirth = DateBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
    
}
