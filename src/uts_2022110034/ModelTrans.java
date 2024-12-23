/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_2022110034;

import java.sql.Date;

/**
 *
 * @author Muhamad Iwani Madjid
 */
public class ModelTrans {
    String IDTRANSAKSI,IDKARYAWAN;
    private Date TGLTRANSAKSI,WKTTRANSAKSI;

    public String getIDTRANSAKSI() {
        return IDTRANSAKSI;
    }

    public void setIDTRANSAKSI(String IDTRANSAKSI) {
        this.IDTRANSAKSI = IDTRANSAKSI;
    }

    public String getIDKARYAWAN() {
        return IDKARYAWAN;
    }

    public void setIDKARYAWAN(String IDKARYAWAN) {
        this.IDKARYAWAN = IDKARYAWAN;
    }

    public Date getTGLTRANSAKSI() {
        return TGLTRANSAKSI;
    }

    public void setTGLTRANSAKSI(Date TGLTRANSAKSI) {
        this.TGLTRANSAKSI = TGLTRANSAKSI;
    }

    public Date getWKTTRANSAKSI() {
        return WKTTRANSAKSI;
    }

    public void setWKTTRANSAKSI(Date WKTTRANSAKSI) {
        this.WKTTRANSAKSI = WKTTRANSAKSI;
    }

  
    
}
