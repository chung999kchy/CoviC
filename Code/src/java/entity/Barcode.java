/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CHUNG
 */
public class Barcode {
    private NguoiCachLy ngCachLy;
    private String ma;
    @Column(name = "time_begin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeBegin;
    @Column(name = "time_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeEnd;

    public Barcode(NguoiCachLy ngCachLy, String ma, Date timeBegin, Date timeEnd) {
        this.ngCachLy = ngCachLy;
        this.ma = ma;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
    }

    public Barcode(){
    }

    public NguoiCachLy getNgCachLy() {
        return ngCachLy;
    }

    public void setNgCachLy(NguoiCachLy ngCachLy) {
        this.ngCachLy = ngCachLy;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }
    
    
}
