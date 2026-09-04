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
import java.util.Objects;

/**
 *
 * @author schan280
 */
@Entity
@Table(name = "fks_professional_services")
@IdClass(FksProfessionalService.FksProfessionalServicePK.class)
@NamedNativeQueries({
    @NamedNativeQuery(name = "ProfessionalService.selectAll", query = "SELECT * FROM fks_professional_services")
})
public class FksProfessionalService implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, precision = 32)
    private Integer id;

    @Column(name = "professional_id", nullable = false, updatable = true, precision = 32)
    private Integer professionalId;

    @Column(name = "service_id", nullable = false, updatable = true, precision = 32)
    private Integer serviceId;

    @Column(name = "price", nullable = false, updatable = true, precision = 7, scale = 2)
    private Double price;

    @Column(name = "is_active", nullable = false, updatable = true, precision = 16)
    private Short isActive;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = true, updatable = true)
    private Timestamp updatedAt;
    
    @Transient
    private String serviceName;

    public FksProfessionalService() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getProfessionalId() {
        return this.professionalId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getServiceId() {
        return this.serviceId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public Short getIsActive() {
        return this.isActive;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public static class FksProfessionalServicePK {

        private Integer id;

        public FksProfessionalServicePK() {}

        public FksProfessionalServicePK(Integer id) {
            this.id = id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return this.id;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 71 * hash + Objects.hashCode(this.id);
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
            final FksProfessionalServicePK other = (FksProfessionalServicePK)obj;
            if (! Objects.equals(this.id, other.id)) {
                return false;
            }
            return true;
        }

    }
}