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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The number of days to retain data within a RecoveryRange.
 */
public class DeleteAfterDays extends GenericModel {

  @SerializedName("delete_after_days")
  protected Long deleteAfterDays;

  /**
   * Builder.
   */
  public static class Builder {
    private Long deleteAfterDays;

    /**
     * Instantiates a new Builder from an existing DeleteAfterDays instance.
     *
     * @param deleteAfterDays the instance to initialize the Builder with
     */
    private Builder(DeleteAfterDays deleteAfterDays) {
      this.deleteAfterDays = deleteAfterDays.deleteAfterDays;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DeleteAfterDays.
     *
     * @return the new DeleteAfterDays instance
     */
    public DeleteAfterDays build() {
      return new DeleteAfterDays(this);
    }

    /**
     * Set the deleteAfterDays.
     *
     * @param deleteAfterDays the deleteAfterDays
     * @return the DeleteAfterDays builder
     */
    public Builder deleteAfterDays(long deleteAfterDays) {
      this.deleteAfterDays = deleteAfterDays;
      return this;
    }
  }

  protected DeleteAfterDays() { }

  protected DeleteAfterDays(Builder builder) {
    deleteAfterDays = builder.deleteAfterDays;
  }

  /**
   * New builder.
   *
   * @return a DeleteAfterDays builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the deleteAfterDays.
   *
   * The number of days to retain data within a RecoveryRange.
   *
   * @return the deleteAfterDays
   */
  public Long deleteAfterDays() {
    return deleteAfterDays;
  }
}

