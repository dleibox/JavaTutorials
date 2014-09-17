package com.firststep.hibernate.model;

import javax.persistence.*;

/**
 * Created by daniel on 9/17/2014.
 */
@Entity
@Table(name = "country", schema = "dbo", catalog = "javadb")
public class CountryEntity {
    private int id;
    private String iso;
    private String name;
    private String nicename;
    private String iso3;
    private Short numcode;
    private Integer phonecode;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "iso")
    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "nicename")
    public String getNicename() {
        return nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename;
    }

    @Basic
    @Column(name = "iso3")
    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    @Basic
    @Column(name = "numcode")
    public Short getNumcode() {
        return numcode;
    }

    public void setNumcode(Short numcode) {
        this.numcode = numcode;
    }

    @Basic
    @Column(name = "phonecode")
    public Integer getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(Integer phonecode) {
        this.phonecode = phonecode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (id != that.id) return false;
        if (iso != null ? !iso.equals(that.iso) : that.iso != null) return false;
        if (iso3 != null ? !iso3.equals(that.iso3) : that.iso3 != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nicename != null ? !nicename.equals(that.nicename) : that.nicename != null) return false;
        if (numcode != null ? !numcode.equals(that.numcode) : that.numcode != null) return false;
        if (phonecode != null ? !phonecode.equals(that.phonecode) : that.phonecode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (iso != null ? iso.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nicename != null ? nicename.hashCode() : 0);
        result = 31 * result + (iso3 != null ? iso3.hashCode() : 0);
        result = 31 * result + (numcode != null ? numcode.hashCode() : 0);
        result = 31 * result + (phonecode != null ? phonecode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return super.toString() + " (" + this.iso + ") " + this.name;
    }
}
