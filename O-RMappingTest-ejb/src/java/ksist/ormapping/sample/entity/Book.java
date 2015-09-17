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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * 書籍クラス
 * @author kasai
 */
@Entity
@Table(name = "BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
})

@DiscriminatorColumn(name = "BOOK_TYPE")
@Data
public abstract class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // 書籍ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOK_ID")
    private int id;
    
    // 書籍名
    @Size(max = 50)
    @Column(name = "BOOK_NAME")
    private String bookName;
    
    // 在庫数
    @Column(name = "STOCK_COUNT")
    private int stockCount;
    
    /**
     * 在庫の有無
     * @return 在庫がある場合はtrue
     */
    public boolean hasStock() {
        return this.stockCount > 0;
    }
    
    /**
     * 発送を予約する
     * @return 発送予定日
     */
    public Date reserveShipping() {
        Date shippingDate = this.calcShippingDate();
        if (this.hasStock()) {
            this.stockCount--;
        }
        return shippingDate;
    }
    
    /**
     * 発送予定日を計算する（計算ロジックはサブクラス側で実装）
     * @return 発送予定日
     */
    public abstract Date calcShippingDate();
    
    /**
     * 書籍の種類を返す（サブクラス側で実装）
     * @return 書籍の種類
     */
    public abstract String getType();
    
}
