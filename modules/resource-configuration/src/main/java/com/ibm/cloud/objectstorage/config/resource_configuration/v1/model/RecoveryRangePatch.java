/*
 * (C) Copyright IBM Corp. 2025.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.objectstorage.config.resource_configuration.v1.model;

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.GsonSingleton;

/**
 * The retention configuration for a RecoveryRange.
 */
public class RecoveryRangePatch extends GenericModel {

  protected DeleteAfterDays retention;

  /**
   * Builder.
   */
  public static class Builder {
    private DeleteAfterDays retention;

    /**
     * Instantiates a new Builder from an existing RecoveryRangePatch instance.
     *
     * @param recoveryRangePatch the instance to initialize the Builder with
     */
    private Builder(RecoveryRangePatch recoveryRangePatch) {
      this.retention = recoveryRangePatch.retention;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RecoveryRangePatch.
     *
     * @return the new RecoveryRangePatch instance
     */
    public RecoveryRangePatch build() {
      return new RecoveryRangePatch(this);
    }

    /**
     * Set the retention.
     *
     * @param retention the retention
     * @return the RecoveryRangePatch builder
     */
    public Builder retention(DeleteAfterDays retention) {
      this.retention = retention;
      return this;
    }
  }

  protected RecoveryRangePatch() { }

  protected RecoveryRangePatch(Builder builder) {
    retention = builder.retention;
  }

  /**
   * New builder.
   *
   * @return a RecoveryRangePatch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the retention.
   *
   * The number of days to retain data within a RecoveryRange.
   *
   * @return the retention
   */
  public DeleteAfterDays retention() {
    return retention;
  }

  /**
   * Construct a JSON merge-patch from the RecoveryRangePatch.
   *
   * Note that properties of the RecoveryRangePatch with null values are not represented in the constructed
   * JSON merge-patch object, but can be explicitly set afterward to signify a property delete.
   *
   * @return a JSON merge-patch for the RecoveryRangePatch
   */
  public Map<String, Object> asPatch() {
    return GsonSingleton.getGson().fromJson(this.toString(), Map.class);
  }
}

