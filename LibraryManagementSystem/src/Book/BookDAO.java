/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Book;

import BookDetail.*;
import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface BookDAO {
    public List<Book> getAllBook();
    public List<Book> getOneBook(String Name);
    public int CreateBook(Book book);
    public int UpdateBook(Book book);
    public int DeleteBook(int id);
    public int UpdateQuantityRemainBook(Book book);
}
