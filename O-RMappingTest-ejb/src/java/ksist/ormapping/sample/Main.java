/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample;

import ksist.ormapping.sample.entity.BookOrderItem;
import ksist.ormapping.sample.entity.Book;
import ksist.ormapping.sample.entity.ForeignBook;
import ksist.ormapping.sample.entity.BookOrder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author kasai
 */
public class Main {
    public static void main(String args[]) {
        EntityManager em = Persistence.createEntityManagerFactory("O-RMappingTest-ejbPU").createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
//        Book book = new JapaneseBook();
//        book.setId(1);
//        book.setBookName("和書１");
//        book.setStockCount(0);
//        em.persist(book);
        Book foreignBook = new ForeignBook();
        foreignBook.setId(2);
        foreignBook.setBookName("洋書２");
        foreignBook.setStockCount(10);
        em.persist(foreignBook);
        Book book = em.find(Book.class, 1);
        BookOrderItem item1 = new BookOrderItem();
        item1.setId(1);
        item1.setBook(book);
        item1.setShippingDate(Calendar.getInstance());
        em.persist(item1);
        BookOrderItem item2 = new BookOrderItem();
        item2.setId(2);
        item2.setBook(foreignBook);
        item2.setShippingDate(Calendar.getInstance());
        em.persist(item2);
        BookOrder order = new BookOrder();
        order.setId(1);
        List<BookOrderItem> list = new ArrayList();
        list.add(item1);
        list.add(item2);
        order.setOrderDate(Calendar.getInstance());
        order.setItems(list);
        em.persist(order);
        tx.commit();
    }
}
