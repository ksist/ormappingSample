/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 注文明細クラス
 * @author kasai
 */
@Data
public class BookOrderItem implements Serializable {
    // 注文明細ID
    private int id;
    
    // 発送予定日
    private Date shippingDate;
    
    // 書籍
    private Book book;
}
