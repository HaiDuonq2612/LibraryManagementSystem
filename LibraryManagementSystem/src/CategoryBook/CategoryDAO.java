/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CategoryBook;

import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface CategoryDAO {
    public List<Category> getAllCategory();
    public List<Category> getOneCategory(String Name);
    public int CreateCategory(Category cat);
    public int UpdateCategory(Category cat);
    public int DeleteCategory(int id);
}
