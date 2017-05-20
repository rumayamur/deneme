package com.yagmur.paw.Model;

import android.graphics.Bitmap;

/**
 * Created by Yagmur on 5.2.2017. ''
 */

public class Dog {
    private String kupe_no, cinsi, alindigi_yer, saglik_durumu, yapilan_mudahale;
    private int yas, capturedDate;
    private boolean cinsiyet, asi_durumu;
    private Bitmap kopek_foto;

    public Dog(String kupe_no, int yas) {
        this.kupe_no = kupe_no;
        this.yas = yas;
    }

    public Dog(String kupe_no, int yas, Bitmap kopek_foto) {
        this.kupe_no = kupe_no;
        this.yas = yas;
        this.kopek_foto = kopek_foto;
    }

    public Dog(String kupe_no, String cinsi, String alindigi_yer, String saglik_durumu, String yapilan_mudahale, int yas, int capturedDate, boolean cinsiyet, boolean asi_durumu) {
        this.kupe_no = kupe_no;
        this.cinsi = cinsi;
        this.alindigi_yer = alindigi_yer;
        this.saglik_durumu = saglik_durumu;
        this.yapilan_mudahale = yapilan_mudahale;
        this.yas = yas;
        this.capturedDate = capturedDate;
        this.cinsiyet = cinsiyet;
        this.asi_durumu = asi_durumu;
    }

    public void setKupe_no(String kupe_no) {
        this.kupe_no = kupe_no;
    }

    public String getCinsi() {
        return cinsi;
    }

    public void setCinsi(String cinsi) {
        this.cinsi = cinsi;
    }

    public String getAlindigi_yer() {
        return alindigi_yer;
    }

    public void setAlindigi_yer(String alindigi_yer) {
        this.alindigi_yer = alindigi_yer;
    }

    public String getSaglik_durumu() {
        return saglik_durumu;
    }

    public void setSaglik_durumu(String saglik_durumu) {
        this.saglik_durumu = saglik_durumu;
    }

    public String getYapilan_mudahale() {
        return yapilan_mudahale;
    }

    public void setYapilan_mudahale(String yapilan_mudahale) {
        this.yapilan_mudahale = yapilan_mudahale;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public int getCapturedDate() {
        return capturedDate;
    }

    public void setCapturedDate(int capturedDate) {
        this.capturedDate = capturedDate;
    }

    public boolean isCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(boolean cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public boolean isAsi_durumu() {
        return asi_durumu;
    }

    public void setAsi_durumu(boolean asi_durumu) {
        this.asi_durumu = asi_durumu;
    }

    public void setKopek_foto(Bitmap kopek_foto) {
        this.kopek_foto = kopek_foto;
    }

    public String getKupe_no() {
        return kupe_no;
    }

    public Bitmap getKopek_foto() {
        return kopek_foto;
    }
}
