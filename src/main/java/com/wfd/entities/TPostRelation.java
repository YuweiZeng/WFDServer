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
@Table(name = "T_POST_RELATION")
@XmlRootElement
public class TPostRelation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TPostRelationPK tPostRelationPK;

    public TPostRelation() {
    }

    public TPostRelation(TPostRelationPK tPostRelationPK) {
        this.tPostRelationPK = tPostRelationPK;
    }

    public TPostRelation(int parentId, int childId) {
        this.tPostRelationPK = new TPostRelationPK(parentId, childId);
    }

    public TPostRelationPK getTPostRelationPK() {
        return tPostRelationPK;
    }

    public void setTPostRelationPK(TPostRelationPK tPostRelationPK) {
        this.tPostRelationPK = tPostRelationPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tPostRelationPK != null ? tPostRelationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPostRelation)) {
            return false;
        }
        TPostRelation other = (TPostRelation) object;
        if ((this.tPostRelationPK == null && other.tPostRelationPK != null) || (this.tPostRelationPK != null && !this.tPostRelationPK.equals(other.tPostRelationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wfd.entities.TPostRelation[ tPostRelationPK=" + tPostRelationPK + " ]";
    }
    
}
