/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookDetail;

import java.util.List;

/**
 *
 * @author Hảii Dươnq
 */
public interface BookDetailDAO {
    public List<BookDetail> getAllBookDetail();
    public List<BookDetail> getOneBookDetail(String Name);
    public int CreateBookDetail(BookDetail bd);
    public int UpdateBookDetail(BookDetail bd);
    public int DeleteBookDetail(int id);
    public List<BookDetail> getListAuthorDetail(int id);
    public List<BookDetail> getListTypeDetail(int id);
}
