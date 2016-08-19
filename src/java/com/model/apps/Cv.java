/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.apps;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joynal Abedin
 */
@Entity
@Table(name = "cv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cv.findAll", query = "SELECT c FROM Cv c"),
    @NamedQuery(name = "Cv.findByCvId", query = "SELECT c FROM Cv c WHERE c.cvId = :cvId"),
    @NamedQuery(name = "Cv.findByDocType", query = "SELECT c FROM Cv c WHERE c.docType = :docType"),
    @NamedQuery(name = "Cv.findByApplicantId", query = "SELECT c FROM Cv c WHERE c.applicantId = :applicantId")})
public class Cv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CvId")
    private Integer cvId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DocType")
    private String docType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ApplicantId")
    private int applicantId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "CvDocs")
    private String cvDocs;

    public Cv() {
    }

    public Cv(Integer cvId) {
        this.cvId = cvId;
    }

    public Cv(Integer cvId, String docType, int applicantId, String cvDocs) {
        this.cvId = cvId;
        this.docType = docType;
        this.applicantId = applicantId;
        this.cvDocs = cvDocs;
    }

    public Integer getCvId() {
        return cvId;
    }

    public void setCvId(Integer cvId) {
        this.cvId = cvId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public String getCvDocs() {
        return cvDocs;
    }

    public void setCvDocs(String cvDocs) {
        this.cvDocs = cvDocs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cvId != null ? cvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cv)) {
            return false;
        }
        Cv other = (Cv) object;
        if ((this.cvId == null && other.cvId != null) || (this.cvId != null && !this.cvId.equals(other.cvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cv[ cvId=" + cvId + " ]";
    }
    
}
