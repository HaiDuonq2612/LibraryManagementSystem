/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TypeBook;

import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface TypeDAO {
    public List<Type> getAllType();
    public List<Type> getOneType(String Name);
    public int CreateType(Type type);
    public int UpdateType(Type type);
    public int DeleteType(int id);
}
