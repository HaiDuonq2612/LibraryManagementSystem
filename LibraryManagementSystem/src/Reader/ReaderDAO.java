/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reader;

import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface ReaderDAO {
    public List<Reader> getAllReader();
    public List<Reader> getOneReader(String Name);
    public List<Reader> getNamePhoneReader(String Name, String Phone);
    public int CreateReader(Reader rea);
    public int UpdateReader(Reader rea);
    public int DeleteReader(int id);
}
