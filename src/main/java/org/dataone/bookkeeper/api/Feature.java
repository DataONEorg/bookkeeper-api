/*
 * This work was created by participants in the DataONE project, and is
 * jointly copyrighted by participating institutions in DataONE. For
 * more information on DataONE, see our web site at http://dataone.org.
 *
 *   Copyright 2019. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.dataone.bookkeeper.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Objects;

/**
 * A Feature describes an aspect of a Product, with optional limits.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feature {

    /* The feature name */
    @NotNull
    @NotEmpty
    private String name;

    /* The feature label */
    @NotNull
    @NotEmpty
    private String label;

    /* The feature description */
    @NotNull
    @NotEmpty
    private String description;

    /* The optional feature quota */
    private Quota quota;

    /**
     * Construct an empty Feature
     */
    public Feature() {
        super();
    }

    /**
     * Create a Feature from a JSON string
     * @param json the feature as a JSON string
     */
    public Feature(String json) throws IOException {
        super();

        // Return an empty Feature instance when the JSON object is empty
        if ( ! json.equals("{}") ) {

            // Otherwise try to build the Feature
            Feature feature = new ObjectMapper().readValue(json, Feature.class);
            this.name = feature.name;
            this.label = feature.label;
            this.description = feature.description;
            this.quota = feature.quota;
        }
    }

    /**
     * Construct a Feature
     * @param name the feature name
     * @param label the feature label
     * @param description the feature description
     * @param quota the feature quota
     */
    public Feature(@NotNull @NotEmpty String name,
                   @NotNull @NotEmpty String label,
                   @NotNull @NotEmpty String description,
                   @NotEmpty Quota quota) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.quota = quota;
    }

    /**
     * Get the feature name
     * @return name the feature name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the feature name
     * @param name the feature name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the feature label
     * @return label the feature label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set the feature label
     * @param label the feature label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Get the feature description
     * @return description the feature description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the feature description
     * @param description the feature description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the feature quota
     * @return quota the feature quota
     */
    public Quota getQuota() {
        return quota;
    }

    /**
     * Set the feature quota
     * @param quota the feature quota
     */
    public void setQuota(Quota quota) {
        this.quota = quota;
    }

    /**
     * Determine object equality based on the equality of all fields
     * @param o the object to be compared
     * @return true if the object is equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(getName(), feature.getName()) &&
            Objects.equals(getLabel(), feature.getLabel()) &&
            Objects.equals(getDescription(), feature.getDescription()) &&
            Objects.equals(getQuota(), feature.getQuota());
    }

    /**
     * Calculate a hash based on all fields
     * @return hashcode a hashcode for the object
     */
    @Override
    public int hashCode() {

        return Objects.hash(getName(), getLabel(), getDescription(), getQuota());
    }
}
