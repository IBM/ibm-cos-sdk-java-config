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

/**
 * The patchSourceResourceRecoveryRange options.
 */
public class PatchSourceResourceRecoveryRangeOptions extends GenericModel {

  protected String backupVaultName;
  protected String recoveryRangeId;
  protected Map<String, Object> recoveryRangePatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String backupVaultName;
    private String recoveryRangeId;
    private Map<String, Object> recoveryRangePatch;

    /**
     * Instantiates a new Builder from an existing PatchSourceResourceRecoveryRangeOptions instance.
     *
     * @param patchSourceResourceRecoveryRangeOptions the instance to initialize the Builder with
     */
    private Builder(PatchSourceResourceRecoveryRangeOptions patchSourceResourceRecoveryRangeOptions) {
      this.backupVaultName = patchSourceResourceRecoveryRangeOptions.backupVaultName;
      this.recoveryRangeId = patchSourceResourceRecoveryRangeOptions.recoveryRangeId;
      this.recoveryRangePatch = patchSourceResourceRecoveryRangeOptions.recoveryRangePatch;
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
     * @param recoveryRangePatch the recoveryRangePatch
     */
    public Builder(String backupVaultName, String recoveryRangeId, Map<String, Object> recoveryRangePatch) {
      this.backupVaultName = backupVaultName;
      this.recoveryRangeId = recoveryRangeId;
      this.recoveryRangePatch = recoveryRangePatch;
    }

    /**
     * Builds a PatchSourceResourceRecoveryRangeOptions.
     *
     * @return the new PatchSourceResourceRecoveryRangeOptions instance
     */
    public PatchSourceResourceRecoveryRangeOptions build() {
      return new PatchSourceResourceRecoveryRangeOptions(this);
    }

    /**
     * Set the backupVaultName.
     *
     * @param backupVaultName the backupVaultName
     * @return the PatchSourceResourceRecoveryRangeOptions builder
     */
    public Builder backupVaultName(String backupVaultName) {
      this.backupVaultName = backupVaultName;
      return this;
    }

    /**
     * Set the recoveryRangeId.
     *
     * @param recoveryRangeId the recoveryRangeId
     * @return the PatchSourceResourceRecoveryRangeOptions builder
     */
    public Builder recoveryRangeId(String recoveryRangeId) {
      this.recoveryRangeId = recoveryRangeId;
      return this;
    }

    /**
     * Set the recoveryRangePatch.
     *
     * @param recoveryRangePatch the recoveryRangePatch
     * @return the PatchSourceResourceRecoveryRangeOptions builder
     */
    public Builder recoveryRangePatch(Map<String, Object> recoveryRangePatch) {
      this.recoveryRangePatch = recoveryRangePatch;
      return this;
    }
  }

  protected PatchSourceResourceRecoveryRangeOptions() { }

  protected PatchSourceResourceRecoveryRangeOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.backupVaultName,
      "backupVaultName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.recoveryRangeId,
      "recoveryRangeId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.recoveryRangePatch,
      "recoveryRangePatch cannot be null");
    backupVaultName = builder.backupVaultName;
    recoveryRangeId = builder.recoveryRangeId;
    recoveryRangePatch = builder.recoveryRangePatch;
  }

  /**
   * New builder.
   *
   * @return a PatchSourceResourceRecoveryRangeOptions builder
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

  /**
   * Gets the recoveryRangePatch.
   *
   * The RecoveryRange configuration elements that are to be changed.
   *
   * @return the recoveryRangePatch
   */
  public Map<String, Object> recoveryRangePatch() {
    return recoveryRangePatch;
  }
}

