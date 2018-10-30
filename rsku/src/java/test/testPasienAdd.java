/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.PasienHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Pasien;

/**
 *
 * @author danielbram
 */
public class testPasienAdd {
    public static void main(String[] args) {
        
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String noRm="354545";
            String nama="nama";
            String alamat="Disini";
            String nik="165314078";
            String kelamin="laki laki";
            Date date = format.parse("19980314");
//            Pasien test = new Pasien("925162", "Bram", "Disini", "165314078", date, "Laki-Laki");
            PasienHelper helper = new PasienHelper();
            helper.addNewPasien(noRm, nama, alamat, nik, date, kelamin);
        } catch (ParseException ex) {
            Logger.getLogger(testPasienAdd.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
}
