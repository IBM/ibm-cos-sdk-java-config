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

import java.util.Date;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createRestore options.
 */
public class CreateRestoreOptions extends GenericModel {

  /**
   * The type of restore to support. More options will be available in the future.
   */
  public interface RestoreType {
    /** in_place. */
    String IN_PLACE = "in_place";
  }

  protected String backupVaultName;
  protected String recoveryRangeId;
  protected String restoreType;
  protected Date restorePointInTime;
  protected String targetResourceCrn;

  /**
   * Builder.
   */
  public static class Builder {
    private String backupVaultName;
    private String recoveryRangeId;
    private String restoreType;
    private Date restorePointInTime;
    private String targetResourceCrn;

    /**
     * Instantiates a new Builder from an existing CreateRestoreOptions instance.
     *
     * @param createRestoreOptions the instance to initialize the Builder with
     */
    private Builder(CreateRestoreOptions createRestoreOptions) {
      this.backupVaultName = createRestoreOptions.backupVaultName;
      this.recoveryRangeId = createRestoreOptions.recoveryRangeId;
      this.restoreType = createRestoreOptions.restoreType;
      this.restorePointInTime = createRestoreOptions.restorePointInTime;
      this.targetResourceCrn = createRestoreOptions.targetResourceCrn;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param backupVaultName the backupVaultName
     * @param recoveryRangeId the recoveryRangeId
     * @param restoreType the restoreType
     * @param restorePointInTime the restorePointInTime
     * @param targetResourceCrn the targetResourceCrn
     */
    public Builder(String backupVaultName, String recoveryRangeId, String restoreType, Date restorePointInTime, String targetResourceCrn) {
      this.backupVaultName = backupVaultName;
      this.recoveryRangeId = recoveryRangeId;
      this.restoreType = restoreType;
      this.restorePointInTime = restorePointInTime;
      this.targetResourceCrn = targetResourceCrn;
    }

    /**
     * Builds a CreateRestoreOptions.
     *
     * @return the new CreateRestoreOptions instance
     */
    public CreateRestoreOptions build() {
      return new CreateRestoreOptions(this);
    }

    /**
     * Set the backupVaultName.
     *
     * @param backupVaultName the backupVaultName
     * @return the CreateRestoreOptions builder
     */
    public Builder backupVaultName(String backupVaultName) {
      this.backupVaultName = backupVaultName;
      return this;
    }

    /**
     * Set the recoveryRangeId.
     *
     * @param recoveryRangeId the recoveryRangeId
     * @return the CreateRestoreOptions builder
     */
    public Builder recoveryRangeId(String recoveryRangeId) {
      this.recoveryRangeId = recoveryRangeId;
      return this;
    }

    /**
     * Set the restoreType.
     *
     * @param restoreType the restoreType
     * @return the CreateRestoreOptions builder
     */
    public Builder restoreType(String restoreType) {
      this.restoreType = restoreType;
      return this;
    }

    /**
     * Set the restorePointInTime.
     *
     * @param restorePointInTime the restorePointInTime
     * @return the CreateRestoreOptions builder
     */
    public Builder restorePointInTime(Date restorePointInTime) {
      this.restorePointInTime = restorePointInTime;
      return this;
    }

    /**
     * Set the targetResourceCrn.
     *
     * @param targetResourceCrn the targetResourceCrn
     * @return the CreateRestoreOptions builder
     */
    public Builder targetResourceCrn(String targetResourceCrn) {
      this.targetResourceCrn = targetResourceCrn;
      return this;
    }
  }

  protected CreateRestoreOptions() { }

  protected CreateRestoreOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.backupVaultName,
      "backupVaultName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.recoveryRangeId,
      "recoveryRangeId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.restoreType,
      "restoreType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.restorePointInTime,
      "restorePointInTime cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.targetResourceCrn,
      "targetResourceCrn cannot be null");
    backupVaultName = builder.backupVaultName;
    recoveryRangeId = builder.recoveryRangeId;
    restoreType = builder.restoreType;
    restorePointInTime = builder.restorePointInTime;
    targetResourceCrn = builder.targetResourceCrn;
  }

  /**
   * New builder.
   *
   * @return a CreateRestoreOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the backupVaultName.
   *
   * name of BackupVault to restore from.
   *
   * @return the backupVaultName
   */
  public String backupVaultName() {
    return backupVaultName;
  }

  /**
   * Gets the recoveryRangeId.
   *
   * A UUID that uniquely identifies a resource.
   *
   * @return the recoveryRangeId
   */
  public String recoveryRangeId() {
    return recoveryRangeId;
  }

  /**
   * Gets the restoreType.
   *
   * The type of restore to support. More options will be available in the future.
   *
   * @return the restoreType
   */
  public String restoreType() {
    return restoreType;
  }

  /**
   * Gets the restorePointInTime.
   *
   * Timestamp format used throughout the API.
   *
   * Accepts the following formats:
   *
   * YYYY-MM-DDTHH:mm:ssZ YYYY-MM-DDTHH:mm:ss YYYY-MM-DDTHH:mm:ss-hh:mm YYYY-MM-DDTHH:mm:ss+hh:mm
   * YYYY-MM-DDTHH:mm:ss.sssZ YYYY-MM-DDTHH:mm:ss.sss YYYY-MM-DDTHH:mm:ss.sss-hh:mm YYYY-MM-DDTHH:mm:ss.sss+hh:mm.
   *
   * @return the restorePointInTime
   */
  public Date restorePointInTime() {
    return restorePointInTime;
  }

  /**
   * Gets the targetResourceCrn.
   *
   * The CRN for a COS Bucket.
   *
   * Note that Softlayer CRNs do not contain dashes within the service_instance_id, whereas regular CRNs do. Although
   * bucket backup is not supported for softlayer accounts, this need not be enforced at the CRN parsing level.
   *
   * @return the targetResourceCrn
   */
  public String targetResourceCrn() {
    return targetResourceCrn;
  }
}

