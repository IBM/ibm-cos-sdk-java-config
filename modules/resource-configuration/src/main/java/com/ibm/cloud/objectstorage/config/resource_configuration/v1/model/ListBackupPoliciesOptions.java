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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listBackupPolicies options.
 */
public class ListBackupPoliciesOptions extends GenericModel {

  protected String bucket;

  /**
   * Builder.
   */
  public static class Builder {
    private String bucket;

    /**
     * Instantiates a new Builder from an existing ListBackupPoliciesOptions instance.
     *
     * @param listBackupPoliciesOptions the instance to initialize the Builder with
     */
    private Builder(ListBackupPoliciesOptions listBackupPoliciesOptions) {
      this.bucket = listBackupPoliciesOptions.bucket;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param bucket the bucket
     */
    public Builder(String bucket) {
      this.bucket = bucket;
    }

    /**
     * Builds a ListBackupPoliciesOptions.
     *
     * @return the new ListBackupPoliciesOptions instance
     */
    public ListBackupPoliciesOptions build() {
      return new ListBackupPoliciesOptions(this);
    }

    /**
     * Set the bucket.
     *
     * @param bucket the bucket
     * @return the ListBackupPoliciesOptions builder
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }
  }

  protected ListBackupPoliciesOptions() { }

  protected ListBackupPoliciesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.bucket,
      "bucket cannot be empty");
    bucket = builder.bucket;
  }

  /**
   * New builder.
   *
   * @return a ListBackupPoliciesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the bucket.
   *
   * Name of the COS Bucket name.
   *
   * @return the bucket
   */
  public String bucket() {
    return bucket;
  }
}

