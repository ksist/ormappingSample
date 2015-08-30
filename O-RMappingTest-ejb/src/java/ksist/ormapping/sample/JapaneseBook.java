/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample;

import java.util.Calendar;

/**
 * 和書クラス
 * @author kasai
 */
public class JapaneseBook extends Book {

    /**
     * 発送予定日を計算する
     * @return 在庫があれば当日、なければ５日後に発送する
     */
    @Override
    public Calendar calcShippingDate() {
        Calendar date = Calendar.getInstance();
        if (this.hasStock()) {
            return date;
        } else {
            date.add(Calendar.DATE, 5);
            return date;
        }
    }
    
}
