/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookDetail;

import java.time.LocalDate;

/**
 *
 * @author Hảii Dươnq
 */
public class BookDetail {

    private int Id;
    private int Id_Book;
    private int Id_Author;
    private int Id_Type;
    private int Id_Translator;
    private int Id_Publisher;
    

    public BookDetail() {
    }

    public BookDetail(int Id, int Id_Book, int Id_Author, int Id_Type, int Id_Translator, int Id_Publisher) {
        this.Id = Id;
        this.Id_Book = Id_Book;
        this.Id_Author = Id_Author;
        this.Id_Type = Id_Type;
        this.Id_Translator = Id_Translator;
        this.Id_Publisher = Id_Publisher;
    }

    public BookDetail(int Id_Book, int Id_Author, int Id_Type, int Id_Translator, int Id_Publisher) {
        this.Id_Book = Id_Book;
        this.Id_Author = Id_Author;
        this.Id_Type = Id_Type;
        this.Id_Translator = Id_Translator;
        this.Id_Publisher = Id_Publisher;
    }
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId_Book() {
        return Id_Book;
    }

    public void setId_Book(int Id_Book) {
        this.Id_Book = Id_Book;
    }

    public int getId_Author() {
        return Id_Author;
    }

    public void setId_Author(int Id_Author) {
        this.Id_Author = Id_Author;
    }

    public int getId_Type() {
        return Id_Type;
    }

    public void setId_Type(int Id_Type) {
        this.Id_Type = Id_Type;
    }

    public int getId_Translator() {
        return Id_Translator;
    }

    public void setId_Translator(int Id_Translator) {
        this.Id_Translator = Id_Translator;
    }

    public int getId_Publisher() {
        return Id_Publisher;
    }

    public void setId_Publisher(int Id_Publisher) {
        this.Id_Publisher = Id_Publisher;
    }


    
}
