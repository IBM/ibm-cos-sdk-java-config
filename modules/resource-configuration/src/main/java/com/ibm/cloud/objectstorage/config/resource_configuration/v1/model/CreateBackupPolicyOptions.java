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
 * The createBackupPolicy options.
 */
public class CreateBackupPolicyOptions extends GenericModel {

  /**
   * The type of backup to support. For LA+GA this is limited to "continuous".
   */
  public interface BackupType {
    /** continuous. */
    String CONTINUOUS = "continuous";
  }

  protected String bucket;
  protected DeleteAfterDays initialRetention;
  protected String policyName;
  protected String targetBackupVaultCrn;
  protected String backupType;
  protected String mD5;

  /**
   * Builder.
   */
  public static class Builder {
    private String bucket;
    private DeleteAfterDays initialRetention;
    private String policyName;
    private String targetBackupVaultCrn;
    private String backupType;
    private String mD5;

    /**
     * Instantiates a new Builder from an existing CreateBackupPolicyOptions instance.
     *
     * @param createBackupPolicyOptions the instance to initialize the Builder with
     */
    private Builder(CreateBackupPolicyOptions createBackupPolicyOptions) {
      this.bucket = createBackupPolicyOptions.bucket;
      this.initialRetention = createBackupPolicyOptions.initialRetention;
      this.policyName = createBackupPolicyOptions.policyName;
      this.targetBackupVaultCrn = createBackupPolicyOptions.targetBackupVaultCrn;
      this.backupType = createBackupPolicyOptions.backupType;
      this.mD5 = createBackupPolicyOptions.mD5;
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
     * @param initialRetention the initialRetention
     * @param policyName the policyName
     * @param targetBackupVaultCrn the targetBackupVaultCrn
     * @param backupType the backupType
     */
    public Builder(String bucket, DeleteAfterDays initialRetention, String policyName, String targetBackupVaultCrn, String backupType) {
      this.bucket = bucket;
      this.initialRetention = initialRetention;
      this.policyName = policyName;
      this.targetBackupVaultCrn = targetBackupVaultCrn;
      this.backupType = backupType;
    }

    /**
     * Builds a CreateBackupPolicyOptions.
     *
     * @return the new CreateBackupPolicyOptions instance
     */
    public CreateBackupPolicyOptions build() {
      return new CreateBackupPolicyOptions(this);
    }

    /**
     * Set the bucket.
     *
     * @param bucket the bucket
     * @return the CreateBackupPolicyOptions builder
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Set the initialRetention.
     *
     * @param initialRetention the initialRetention
     * @return the CreateBackupPolicyOptions builder
     */
    public Builder initialRetention(DeleteAfterDays initialRetention) {
      this.initialRetention = initialRetention;
      return this;
    }

    /**
     * Set the policyName.
     *
     * @param policyName the policyName
     * @return the CreateBackupPolicyOptions builder
     */
    public Builder policyName(String policyName) {
      this.policyName = policyName;
      return this;
    }

    /**
     * Set the targetBackupVaultCrn.
     *
     * @param targetBackupVaultCrn the targetBackupVaultCrn
     * @return the CreateBackupPolicyOptions builder
     */
    public Builder targetBackupVaultCrn(String targetBackupVaultCrn) {
      this.targetBackupVaultCrn = targetBackupVaultCrn;
      return this;
    }

    /**
     * Set the backupType.
     *
     * @param backupType the backupType
     * @return the CreateBackupPolicyOptions builder
     */
    public Builder backupType(String backupType) {
      this.backupType = backupType;
      return this;
    }

    /**
     * Set the mD5.
     *
     * @param mD5 the mD5
     * @return the CreateBackupPolicyOptions builder
     */
    public Builder mD5(String mD5) {
      this.mD5 = mD5;
      return this;
    }
  }

  protected CreateBackupPolicyOptions() { }

  protected CreateBackupPolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.bucket,
      "bucket cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.initialRetention,
      "initialRetention cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.policyName,
      "policyName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.targetBackupVaultCrn,
      "targetBackupVaultCrn cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.backupType,
      "backupType cannot be null");
    bucket = builder.bucket;
    initialRetention = builder.initialRetention;
    policyName = builder.policyName;
    targetBackupVaultCrn = builder.targetBackupVaultCrn;
    backupType = builder.backupType;
    mD5 = builder.mD5;
  }

  /**
   * New builder.
   *
   * @return a CreateBackupPolicyOptions builder
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

  /**
   * Gets the initialRetention.
   *
   * The number of days to retain data within a RecoveryRange.
   *
   * @return the initialRetention
   */
  public DeleteAfterDays initialRetention() {
    return initialRetention;
  }

  /**
   * Gets the policyName.
   *
   * The name granted to the policy. Validation :
   *   * chars limited to alphanumeric, underscore, hyphen and period.
   *
   * @return the policyName
   */
  public String policyName() {
    return policyName;
  }

  /**
   * Gets the targetBackupVaultCrn.
   *
   * The CRN for a COS BackupVault.
   *
   * @return the targetBackupVaultCrn
   */
  public String targetBackupVaultCrn() {
    return targetBackupVaultCrn;
  }

  /**
   * Gets the backupType.
   *
   * The type of backup to support. For LA+GA this is limited to "continuous".
   *
   * @return the backupType
   */
  public String backupType() {
    return backupType;
  }

  /**
   * Gets the mD5.
   *
   * MD5 hash of content. If provided, the hash of the request must match.
   *
   * @return the mD5
   */
  public String mD5() {
    return mD5;
  }
}

