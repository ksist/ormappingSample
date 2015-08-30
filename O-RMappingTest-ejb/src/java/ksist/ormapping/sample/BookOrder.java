/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import lombok.Data;

/**
 * １件の注文を表すクラス
 * @author kasai
 */
@Data
public class BookOrder implements Serializable {
    // 注文ID
    private int id;

    // 注文書
    private String customerName;
    
    // 注文日
    private Calendar orderDate;
    
    // 注文明細
    private List<BookOrderItem> items;
        
}
