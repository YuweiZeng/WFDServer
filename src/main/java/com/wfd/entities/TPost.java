/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "T_POST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPost.findAll", query = "SELECT t FROM TPost t"),
    @NamedQuery(name = "TPost.findByPostId", query = "SELECT t FROM TPost t WHERE t.postId = :postId"),
    @NamedQuery(name = "TPost.findByContent", query = "SELECT t FROM TPost t WHERE t.content = :content"),
    @NamedQuery(name = "TPost.findByDeleted", query = "SELECT t FROM TPost t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TPost.findByTimeT", query = "SELECT t FROM TPost t WHERE t.timeT = :timeT")})
public class TPost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "POST_ID")
    private Integer postId;
    @Size(max = 2000)
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "DELETED")
    private Boolean deleted;
    @Column(name = "TIME_T")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeT;
    @OneToMany(mappedBy = "postId")
    private Collection<TComment> tCommentCollection;
    @OneToMany(mappedBy = "postId")
    private Collection<TTopic> tTopicCollection;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private TUsers userId;

    public TPost() {
    }

    public TPost(Integer postId) {
        this.postId = postId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getTimeT() {
        return timeT;
    }

    public void setTimeT(Date timeT) {
        this.timeT = timeT;
    }

    @XmlTransient
    public Collection<TComment> getTCommentCollection() {
        return tCommentCollection;
    }

    public void setTCommentCollection(Collection<TComment> tCommentCollection) {
        this.tCommentCollection = tCommentCollection;
    }

    @XmlTransient
    public Collection<TTopic> getTTopicCollection() {
        return tTopicCollection;
    }

    public void setTTopicCollection(Collection<TTopic> tTopicCollection) {
        this.tTopicCollection = tTopicCollection;
    }

    public TUsers getUserId() {
        return userId;
    }

    public void setUserId(TUsers userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postId != null ? postId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPost)) {
            return false;
        }
        TPost other = (TPost) object;
        if ((this.postId == null && other.postId != null) || (this.postId != null && !this.postId.equals(other.postId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wfd.entities.TPost[ postId=" + postId + " ]";
    }
    
}
