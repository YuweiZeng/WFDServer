/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "t_favorite")
@XmlRootElement
public class TFavorite implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TFavoritePK tFavoritePK;

    public TFavorite() {
    }

    public TFavorite(TFavoritePK tFavoritePK) {
        this.tFavoritePK = tFavoritePK;
    }

    public TFavorite(int userId, int topicId) {
        this.tFavoritePK = new TFavoritePK(userId, topicId);
    }

    public TFavoritePK getTFavoritePK() {
        return tFavoritePK;
    }

    public void setTFavoritePK(TFavoritePK tFavoritePK) {
        this.tFavoritePK = tFavoritePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tFavoritePK != null ? tFavoritePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TFavorite)) {
            return false;
        }
        TFavorite other = (TFavorite) object;
        if ((this.tFavoritePK == null && other.tFavoritePK != null) || (this.tFavoritePK != null && !this.tFavoritePK.equals(other.tFavoritePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wfd.entities.TFavorite[ tFavoritePK=" + tFavoritePK + " ]";
    }
    
}
