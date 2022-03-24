/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Author;

import java.time.LocalDate;
import java.util.Date;


/**
 *
 * @author Hảii Dươnq
 */
public class Author {
    private int Id;
    private String Pseudonym;
    private String Name ;
    private LocalDate DateBirth;
    private LocalDate DateLost;
    private String Address;
    private String Description;
    private boolean Status;

    public Author() {
    } 

    public Author(int Id, String Pseudonym, String Name, LocalDate DateBirth, LocalDate DateLost, String Address, String Description, boolean Status) {
        this.Id = Id;
        this.Pseudonym = Pseudonym;
        this.Name = Name;
        this.DateBirth = DateBirth;
        this.DateLost = DateLost;
        this.Address = Address;
        this.Description = Description;
        this.Status = Status;
    }

    public Author(String Pseudonym, String Name, LocalDate DateBirth, LocalDate DateLost, String Address, String Description, boolean Status) {
        this.Pseudonym = Pseudonym;
        this.Name = Name;
        this.DateBirth = DateBirth;
        this.DateLost = DateLost;
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

    public String getPseudonym() {
        return Pseudonym;
    }

    public void setPseudonym(String Pseudonym) {
        this.Pseudonym = Pseudonym;
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

    public LocalDate getDateLost() {
        return DateLost;
    }

    public void setDateLost(LocalDate DateLost) {
        this.DateLost = DateLost;
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
