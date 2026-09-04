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
package org.javalabs.jpa.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.javalabs.jpa.JdbcException;
import org.javalabs.jpa.descriptor.QueryCache;
import org.javalabs.jpa.model.FksProfessional;
import org.javalabs.jpa.util.QueryHints;
import org.junit.jupiter.api.Test;

/**
 *
 * @author schan280
 */
public class NativeQueryTest {
    
    // @Test
    public void testQuery() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try {
            Map<String, Object> dbConfig = new HashMap<>();
            emf = Persistence.createEntityManagerFactory("jpa-pu", dbConfig);
            em = emf.createEntityManager();
            
            // binders.add(new OneToOneBinder(RelAttribute.RelType.OneToOne));
            
            List<FksProfessional> list = em.createNamedQuery("Professional.selectByExtId", FksProfessional.class)
                    .setParameter(1, "dfa9b88-ccf0-1086-ca4f-faed29bdded8")
                    .setHint(QueryHints.ALLOW_NATIVE_QUERY, Boolean.TRUE)
                    .setHint(QueryHints.QUERY_TYPE, QueryCache.QueryType.SELECT_REL)
                    .setHint(QueryHints.FETCH_DEF, "OneToOne")
                    .setHint(QueryHints.FETCH_FIELD, "user")
                    .getResultList();
            
            System.out.println(list);
        }
        catch (JdbcException e) {
            e.printStackTrace();
        }
        finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
