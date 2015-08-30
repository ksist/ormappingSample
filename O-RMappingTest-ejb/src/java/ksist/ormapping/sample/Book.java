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
 * 書籍クラス
 * @author kasai
 */
@Data
public abstract class Book implements Serializable {
    // 書籍ID
    private int id;
    
    // 書籍名
    private String bookName;
    
    // 在庫数
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
        
}
