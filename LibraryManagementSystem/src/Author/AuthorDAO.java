/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Author;

import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface AuthorDAO {
    public List<Author> getAllAuthor();
    public List<Author> getOneAuthor(String Name);
    public int CreateAuthor(Author author);
    public int UpdateAuthor(Author author);
    public int DeleteAuthor(int id);
}
