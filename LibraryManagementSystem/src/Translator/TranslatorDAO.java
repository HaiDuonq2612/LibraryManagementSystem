/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translator;

import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface TranslatorDAO {
    public List<Translator> getAllTranslator();
    public List<Translator> getOneTranslator(String Name);
    public int CreateTranslator(Translator trans);
    public int UpdateTranslator(Translator trans);
    public int DeleteTranslator(int id);
}
