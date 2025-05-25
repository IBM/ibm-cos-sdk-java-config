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
 * The getBackupPolicy options.
 */
public class GetBackupPolicyOptions extends GenericModel {

  protected String bucket;
  protected String policyId;

  /**
   * Builder.
   */
  public static class Builder {
    private String bucket;
    private String policyId;

    /**
     * Instantiates a new Builder from an existing GetBackupPolicyOptions instance.
     *
     * @param getBackupPolicyOptions the instance to initialize the Builder with
     */
    private Builder(GetBackupPolicyOptions getBackupPolicyOptions) {
      this.bucket = getBackupPolicyOptions.bucket;
      this.policyId = getBackupPolicyOptions.policyId;
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
     * @param policyId the policyId
     */
    public Builder(String bucket, String policyId) {
      this.bucket = bucket;
      this.policyId = policyId;
    }

    /**
     * Builds a GetBackupPolicyOptions.
     *
     * @return the new GetBackupPolicyOptions instance
     */
    public GetBackupPolicyOptions build() {
      return new GetBackupPolicyOptions(this);
    }

    /**
     * Set the bucket.
     *
     * @param bucket the bucket
     * @return the GetBackupPolicyOptions builder
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Set the policyId.
     *
     * @param policyId the policyId
     * @return the GetBackupPolicyOptions builder
     */
    public Builder policyId(String policyId) {
      this.policyId = policyId;
      return this;
    }
  }

  protected GetBackupPolicyOptions() { }

  protected GetBackupPolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.bucket,
      "bucket cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyId,
      "policyId cannot be empty");
    bucket = builder.bucket;
    policyId = builder.policyId;
  }

  /**
   * New builder.
   *
   * @return a GetBackupPolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the bucket.
   *
   * name of the bucket affected.
   *
   * @return the bucket
   */
  public String bucket() {
    return bucket;
  }

  /**
   * Gets the policyId.
   *
   * uuid of the BackupPolicy.
   *
   * @return the policyId
   */
  public String policyId() {
    return policyId;
  }
}

