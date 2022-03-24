/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Book;

import java.time.LocalDate;

/**
 *
 * @author Hảii Dươnq
 */
public class Book {
    private int Id;
    private String Name;
    private LocalDate DateAdded;
    private float Price;
    private int Quantity;
    private int QuantityRemain;
    private int Category_Id;
    private String Description;
    private boolean Status;

    public Book() {
    }

    public Book(int Id, String Name, LocalDate DateAdded, float Price, int Quantity, int QuantityRemain, int Category_Id, String Description, boolean Status) {
        this.Id = Id;
        this.Name = Name;
        this.DateAdded = DateAdded;
        this.Price = Price;
        this.Quantity = Quantity;
        this.QuantityRemain = QuantityRemain;
        this.Category_Id = Category_Id;
        this.Description = Description;
        this.Status = Status;
    }

    public Book(String Name, LocalDate DateAdded, float Price, int Quantity, int QuantityRemain, int Category_Id, String Description, boolean Status) {
        this.Name = Name;
        this.DateAdded = DateAdded;
        this.Price = Price;
        this.Quantity = Quantity;
        this.QuantityRemain = QuantityRemain;
        this.Category_Id = Category_Id;
        this.Description = Description;
        this.Status = Status;
    }

    public Book(int Id, int QuantityRemain) {
        this.Id = Id;
        this.QuantityRemain = QuantityRemain;
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

    public LocalDate getDateAdded() {
        return DateAdded;
    }

    public void setDateAdded(LocalDate DateAdded) {
        this.DateAdded = DateAdded;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getQuantityRemain() {
        return QuantityRemain;
    }

    public void setQuantityRemain(int QuantityRemain) {
        this.QuantityRemain = QuantityRemain;
    }

    public int getCategory_Id() {
        return Category_Id;
    }

    public void setCategory_Id(int Category_Id) {
        this.Category_Id = Category_Id;
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
