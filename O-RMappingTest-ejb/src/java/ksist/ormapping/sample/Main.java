/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksist.ormapping.sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author kasai
 */
public class Main {
    public static void main(String args[]) {
        Book book = new JapaneseBook();
//        Calendar today = book.calcShippingDate();
        Calendar today = book.calcShippingDate();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int date = today.get(Calendar.DAY_OF_MONTH);
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(df.format(today.getTime()));
    }
}
