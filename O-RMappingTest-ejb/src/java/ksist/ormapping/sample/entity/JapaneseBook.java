/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample.entity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 和書クラス
 * @author kasai
 */
@Entity
@DiscriminatorValue("JAPANESE")
public class JapaneseBook extends Book {

    /**
     * 発送予定日を計算する
     * @return 在庫があれば当日、なければ５日後に発送する
     */
    @Override
    public Date calcShippingDate() {
        Calendar date = Calendar.getInstance();
        if (this.hasStock()) {
            return date.getTime();
        } else {
            date.add(Calendar.DATE, 5);
            return date.getTime();
        }
    }

    @Override
    public String getType() {
        return "和書";
    }
    
}
