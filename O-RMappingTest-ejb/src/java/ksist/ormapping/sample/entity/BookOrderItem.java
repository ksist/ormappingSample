/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * 注文明細クラス
 * @author kasai
 */
@Data
@Entity
@Table(name = "BOOK_ORDER_ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookOrderItem.findAll", query = "SELECT b FROM BookOrderItem b"),
//    @NamedQuery(name = "BookOrderItem.findByBookOrderItemId", query = "SELECT b FROM BookOrderItem b WHERE b.id = :id"),
//    @NamedQuery(name = "BookOrderItem.findByBookOrderId", query = "SELECT b FROM BookOrderItem b WHERE b.bookOrderId = :bookOrderId"),
//    @NamedQuery(name = "BookOrderItem.findByItemOrder", query = "SELECT b FROM BookOrderItem b WHERE b.itemOrder = :itemOrder"),
//    @NamedQuery(name = "BookOrderItem.findByBookId", query = "SELECT b FROM BookOrderItem b WHERE b.bookId = :bookId"),
//    @NamedQuery(name = "BookOrderItem.findByShippingDate", query = "SELECT b FROM BookOrderItem b WHERE b.shippingDate = :shippingDate")
})

public class BookOrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    // 注文明細ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOK_ORDER_ITEM_ID")
    private int id;
    
    // 発送予定日
    @Column(name = "SHIPPING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippingDate;
    
    // 書籍
    @JoinColumn(name = "BOOK_ID")
    private Book book;
    
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookOrderItem)) {
            return false;
        }
        BookOrderItem other = (BookOrderItem) object;
        return this.id == other.id;
    }

}
