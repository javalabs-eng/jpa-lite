/*
 * Copyright 2026 schan280.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.javalabs.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author schan280
 */
@Entity
@Table(name = "fks_professionals")
@IdClass(FksProfessional.ProfessionalPK.class)
@NamedNativeQueries({
    @NamedNativeQuery(name = "Professional.selectAll", query = "SELECT * FROM fks_professionals"),
    @NamedNativeQuery(name = "Professional.selectByExtId"
            , query = """
                      SELECT a.*, b.*
                        FROM fks_professionals a
                       RIGHT OUTER JOIN fks_users b ON (a.user_id = b.user_id)
                       WHERE b.external_id = ?
                """),
    @NamedNativeQuery(name = "Professional.selectAllByExtId"
            , query = """
                      SELECT a.*, b.*, c.*
                        FROM fks_professionals a
                       RIGHT OUTER JOIN fks_users b ON (a.user_id = b.user_id)
                       RIGHT OUTER JOIN fks_professional_services c ON (a.professional_id = c.professional_id)
                       WHERE b.external_id = ?
                """)
})
public class FksProfessional implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professional_id", nullable = false, updatable = false, precision = 32)
    private Integer professionalId;

    @Column(name = "user_id", nullable = false, updatable = true, precision = 32)
    private Integer userId;

    @Column(name = "bio", nullable = true, updatable = true, length = 1000000000)
    private String bio;

    @Column(name = "experience_years", nullable = false, updatable = true, precision = 16)
    private Short experienceYears;

    @Column(name = "serving_cities", nullable = true, updatable = true, length = 256)
    private String servingCities;

    @Column(name = "rating_avg", nullable = true, updatable = true, precision = 3, scale = 2)
    private Double ratingAvg;

    @Column(name = "is_verified", nullable = false, updatable = true, precision = 16)
    private Short isVerified;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = true, updatable = true)
    private Timestamp updatedAt;

    @Transient
    private FksUser user;
    
    @Transient
    private List<FksProfessionalService> profServices;

    public FksProfessional() {}

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getProfessionalId() {
        return this.professionalId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return this.bio;
    }

    public void setExperienceYears(Short experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Short getExperienceYears() {
        return this.experienceYears;
    }

    public String getServingCities() {
        return servingCities;
    }

    public void setServingCities(String servingCities) {
        this.servingCities = servingCities;
    }

    public void setRatingAvg(Double ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public Double getRatingAvg() {
        return this.ratingAvg;
    }

    public void setIsVerified(Short isVerified) {
        this.isVerified = isVerified;
    }

    public Short getIsVerified() {
        return this.isVerified;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public FksUser getUser() {
        return user;
    }

    public void setUser(FksUser user) {
        this.user = user;
    }

    public List<FksProfessionalService> getProfServices() {
        return profServices;
    }

    public void setProfServices(List<FksProfessionalService> profServices) {
        this.profServices = profServices;
    }

    public static class ProfessionalPK {

        private Integer professionalId;

        public ProfessionalPK() {}

        public ProfessionalPK(Integer professionalId) {
            this.professionalId = professionalId;
        }

        public void setProfessionalId(Integer professionalId) {
            this.professionalId = professionalId;
        }

        public Integer getProfessionalId() {
            return this.professionalId;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 71 * hash + Objects.hashCode(this.professionalId);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ProfessionalPK other = (ProfessionalPK)obj;
            if (! Objects.equals(this.professionalId, other.professionalId)) {
                return false;
            }
            return true;
        }

    }
}