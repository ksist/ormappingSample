/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ksist.ormapping.sample.entity.Book;

/**
 *
 * @author kasai
 */
@Stateless
@LocalBean
public class BookSessionBean {
    
    @PersistenceContext
    EntityManager em;

    /**
     * 書籍を全件取得する
     * @return 書籍リスト
     */
    public List<Book> findAll() {
        Query query = em.createNamedQuery("Book.findAll");
        return query.getResultList();
    }
    
    /**
     * 書籍を追加する
     * @param book 
     */
    public void add(Book book) {
        em.persist(book);
    }
    
    /**
     * 書籍を削除する
     * @param id 書籍ID
     */
    public void delete(int id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
    }
}
