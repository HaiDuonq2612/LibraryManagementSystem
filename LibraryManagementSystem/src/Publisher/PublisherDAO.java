/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface PublisherDAO {
    public List<Publisher> getAllPublisher();
    public List<Publisher> getOnePublisher(String Name);
    public int CreatePublisher(Publisher pub);
    public int UpdatePublisher(Publisher pub);
    public int DeletePublisher(int id);
}
