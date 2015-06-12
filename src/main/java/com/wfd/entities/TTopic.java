/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "T_TOPIC")
@XmlRootElement
public class TTopic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TOPIC_ID")
    private Integer topicId;
    @Column(name = "SUPPORT_COUNT")
    private Integer supportCount = 0;
    @Column(name = "DISAGREE_COUNT")
    private Integer disagreeCount = 0;
    @Column(name = "category")
    private String category = "work";


    @JoinColumn(name = "POST_ID", referencedColumnName = "POST_ID")
    @ManyToOne
    private TPost postId;

    public TTopic() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public TTopic(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getSupportCount() {
        return supportCount;
    }

    public void setSupportCount(Integer supportCount) {
        this.supportCount = supportCount;
    }

    public Integer getDisagreeCount() {
        return disagreeCount;
    }

    public void setDisagreeCount(Integer disagreeCount) {
        this.disagreeCount = disagreeCount;
    }

    public TPost getPostId() {
        return postId;
    }

    public void setPostId(TPost postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (topicId != null ? topicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTopic)) {
            return false;
        }
        TTopic other = (TTopic) object;
        if ((this.topicId == null && other.topicId != null) || (this.topicId != null && !this.topicId.equals(other.topicId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.wfd.entities.TTopic[ topicId=" + topicId + " ]";
    }
    
}
