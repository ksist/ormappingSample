/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ksist.ormapping.sample.entity.Book;
import ksist.ormapping.sample.entity.BookOrder;
import ksist.ormapping.sample.entity.BookOrderItem;

/**
 *
 * @author kasai
 */
@Stateless
@LocalBean
public class BookOrderSessoinBean {

    @PersistenceContext
    EntityManager em;
    
    public BookOrder createBookOrder(String customerName, List<Integer> bookIDs) {
        BookOrder bookOrder = null;
                        
            // 注文の作成
            bookOrder = new BookOrder();
            bookOrder.setCustomerName(customerName);
            bookOrder.setOrderDate(Calendar.getInstance());

            // 注文明細リストの作成
            List<BookOrderItem> bookOrderItems = new ArrayList<>();
            for (int bookID : bookIDs) {
                // 注文する書籍を取得する
                Book book = em.find(Book.class, bookID);

                // 発送予定日を取得し、書籍の在庫を減らす
                // 注) トランザクションが終了すると書籍の在庫の減少も自動的に保存される
                Calendar shippingDate = book.reserveShipping();

                // 注文明細を作成する
                BookOrderItem bookOrderItem = new BookOrderItem();
                bookOrderItem.setBook(book);
                bookOrderItem.setShippingDate(shippingDate);
                bookOrderItems.add(bookOrderItem);
            }

            // 注文に注文明細リストをセットする
            bookOrder.setItems(bookOrderItems);

            // 注文を保存する(注文明細も同時に保存される)
            em.persist(bookOrder);
            return bookOrder;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
