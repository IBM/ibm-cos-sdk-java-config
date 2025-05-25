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
 * The getSourceResourceRecoveryRange options.
 */
public class GetSourceResourceRecoveryRangeOptions extends GenericModel {

  protected String backupVaultName;
  protected String recoveryRangeId;

  /**
   * Builder.
   */
  public static class Builder {
    private String backupVaultName;
    private String recoveryRangeId;

    /**
     * Instantiates a new Builder from an existing GetSourceResourceRecoveryRangeOptions instance.
     *
     * @param getSourceResourceRecoveryRangeOptions the instance to initialize the Builder with
     */
    private Builder(GetSourceResourceRecoveryRangeOptions getSourceResourceRecoveryRangeOptions) {
      this.backupVaultName = getSourceResourceRecoveryRangeOptions.backupVaultName;
      this.recoveryRangeId = getSourceResourceRecoveryRangeOptions.recoveryRangeId;
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
     */
    public Builder(String backupVaultName, String recoveryRangeId) {
      this.backupVaultName = backupVaultName;
      this.recoveryRangeId = recoveryRangeId;
    }

    /**
     * Builds a GetSourceResourceRecoveryRangeOptions.
     *
     * @return the new GetSourceResourceRecoveryRangeOptions instance
     */
    public GetSourceResourceRecoveryRangeOptions build() {
      return new GetSourceResourceRecoveryRangeOptions(this);
    }

    /**
     * Set the backupVaultName.
     *
     * @param backupVaultName the backupVaultName
     * @return the GetSourceResourceRecoveryRangeOptions builder
     */
    public Builder backupVaultName(String backupVaultName) {
      this.backupVaultName = backupVaultName;
      return this;
    }

    /**
     * Set the recoveryRangeId.
     *
     * @param recoveryRangeId the recoveryRangeId
     * @return the GetSourceResourceRecoveryRangeOptions builder
     */
    public Builder recoveryRangeId(String recoveryRangeId) {
      this.recoveryRangeId = recoveryRangeId;
      return this;
    }
  }

  protected GetSourceResourceRecoveryRangeOptions() { }

  protected GetSourceResourceRecoveryRangeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.backupVaultName,
      "backupVaultName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.recoveryRangeId,
      "recoveryRangeId cannot be empty");
    backupVaultName = builder.backupVaultName;
    recoveryRangeId = builder.recoveryRangeId;
  }

  /**
   * New builder.
   *
   * @return a GetSourceResourceRecoveryRangeOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the backupVaultName.
   *
   * name of BackupVault to update.
   *
   * @return the backupVaultName
   */
  public String backupVaultName() {
    return backupVaultName;
  }

  /**
   * Gets the recoveryRangeId.
   *
   * ID of the RecoveryRange to update.
   *
   * @return the recoveryRangeId
   */
  public String recoveryRangeId() {
    return recoveryRangeId;
  }
}

