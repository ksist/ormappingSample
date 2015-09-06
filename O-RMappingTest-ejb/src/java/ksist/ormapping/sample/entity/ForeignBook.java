/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample.entity;

import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 洋書クラス
 * @author kasai
 */
@Entity
@DiscriminatorValue("FOREIGN")
public class ForeignBook extends Book {

    /**
     * 発送予定日を計算する
     * @return 在庫があれば３日後、なければ７日後に発送する
     */
    @Override
    public Calendar calcShippingDate() {
        Calendar today = Calendar.getInstance();
        if (this.hasStock()) {
            today.add(Calendar.DATE, 3);
            return today;
        } else {
            today.add(Calendar.DATE, 7);
            return today;
        }
    }
    
}