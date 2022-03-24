/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

import java.time.LocalDate;

/**
 *
 * @author Hảii Dươnq
 */
public class Publisher {
    private int Id;
    private String Name;
    private LocalDate DateEstablished;
    private String Address;
    private String Description;
    private boolean Status;

    public Publisher() {
    }

    public Publisher(int Id, String Name, LocalDate DateEstablished, String Address, String Description, boolean Status) {
        this.Id = Id;
        this.Name = Name;
        this.DateEstablished = DateEstablished;
        this.Address = Address;
        this.Description = Description;
        this.Status = Status;
    }

    public Publisher(String Name, LocalDate DateEstablished, String Address, String Description, boolean Status) {
        this.Name = Name;
        this.DateEstablished = DateEstablished;
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

    public LocalDate getDateEstablished() {
        return DateEstablished;
    }

    public void setDateEstablished(LocalDate DateEstablished) {
        this.DateEstablished = DateEstablished;
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
