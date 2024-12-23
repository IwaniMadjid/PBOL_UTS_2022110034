/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_2022110034;

/**
 *
 * @author Muhamad Iwani Madjid
 */
public class ModelMenu {
    private String IDMENU,IDBOOTH,NAMAMENU;
    private int HARGA; // nama field yang ada di database

    public int getHARGA() {
        return HARGA;
    }

    public void setHARGA(int HARGA) {
        this.HARGA = HARGA;
    }

   

    public String getIDMENU() {
        return IDMENU;
    }

    public void setIDMENU(String IDMENU) {
        this.IDMENU = IDMENU;
    }

    public String getIDBOOTH() {
        return IDBOOTH;
    }

    public void setIDBOOTH(String IDBOOTH) {
        this.IDBOOTH = IDBOOTH;
    }

    public String getNAMAMENU() {
        return NAMAMENU;
    }

    public void setNAMAMENU(String NAMAMENU) {
        this.NAMAMENU = NAMAMENU;
    }
}
