/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeBook;

/**
 *
 * @author Hảii Dươnq
 */
public class Type {
    private int Id;
    private String Name;
    private String Description;
    private boolean Status;

    public Type() {
    }

    public Type(int Id, String Name, String Description, boolean Status) {
        this.Id = Id;
        this.Name = Name;
        this.Description = Description;
        this.Status = Status;
    }

    public Type(String Name, String Description, boolean Status) {
        this.Name = Name;
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
