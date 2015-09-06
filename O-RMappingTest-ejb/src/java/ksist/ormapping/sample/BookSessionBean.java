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

    public List<Book> findAll() {
        Query query = em.createNamedQuery("Book.findAll");
        return query.getResultList();
    }
    
    public void add(Book book) {
        em.persist(book);
    }
    
    public void delete(int id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
    }
}
