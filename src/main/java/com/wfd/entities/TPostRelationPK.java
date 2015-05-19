/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author user
 */
@Embeddable
public class TPostRelationPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARENT_ID")
    private int parentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHILD_ID")
    private int childId;

    public TPostRelationPK() {
    }

    public TPostRelationPK(int parentId, int childId) {
        this.parentId = parentId;
        this.childId = childId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) parentId;
        hash += (int) childId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPostRelationPK)) {
            return false;
        }
        TPostRelationPK other = (TPostRelationPK) object;
        if (this.parentId != other.parentId) {
            return false;
        }
        if (this.childId != other.childId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wfd.entities.TPostRelationPK[ parentId=" + parentId + ", childId=" + childId + " ]";
    }
    
}
