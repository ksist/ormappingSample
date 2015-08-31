/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * １件の注文を表すクラス
 * @author kasai
 */
@Entity
@Table(name = "BOOK_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookOrder.findAll", query = "SELECT b FROM BookOrder b"),
    @NamedQuery(name = "BookOrder.findByBookOrderId", query = "SELECT b FROM BookOrder b WHERE b.bookOrderId = :bookOrderId"),
    @NamedQuery(name = "BookOrder.findByCustomerName", query = "SELECT b FROM BookOrder b WHERE b.customerName = :customerName"),
    @NamedQuery(name = "BookOrder.findByOrderDate", query = "SELECT b FROM BookOrder b WHERE b.orderDate = :orderDate")})

@Data
public class BookOrder implements Serializable {
    // 注文ID
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOK_ORDER_ID")
    private int id;

    // 注文書
    @Size(max = 16)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    
    // 注文日
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar orderDate;
    
    // 注文明細
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ORDER_ITEM_ID")
    private List<BookOrderItem> items;
        
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookOrder)) {
            return false;
        }
        BookOrder other = (BookOrder) object;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "entity.BookOrder[ id=" + id + " ]";
    }
}
