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
package org.javalabs.jpa.annotation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * Represents an INNER join type.
 * 
 * <p>
 * Used in query construction to return only matching records
 * between joined entities or tables.
 *
 * @author Sudiptasish Chanda
 */
@Documented
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface ResultColumn {
    
    /**
     * The name of the column. Defaults to the property or field name.
     * @return String
     */
    String name() default "";
}