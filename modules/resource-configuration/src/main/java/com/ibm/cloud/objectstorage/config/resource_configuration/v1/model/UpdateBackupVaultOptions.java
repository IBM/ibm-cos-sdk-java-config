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
 * The updateBackupVault options.
 */
public class UpdateBackupVaultOptions extends GenericModel {

  protected String backupVaultName;
  protected Map<String, Object> backupVaultPatch;
  protected String ifMatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String backupVaultName;
    private Map<String, Object> backupVaultPatch;
    private String ifMatch;

    /**
     * Instantiates a new Builder from an existing UpdateBackupVaultOptions instance.
     *
     * @param updateBackupVaultOptions the instance to initialize the Builder with
     */
    private Builder(UpdateBackupVaultOptions updateBackupVaultOptions) {
      this.backupVaultName = updateBackupVaultOptions.backupVaultName;
      this.backupVaultPatch = updateBackupVaultOptions.backupVaultPatch;
      this.ifMatch = updateBackupVaultOptions.ifMatch;
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
     * @param backupVaultPatch the backupVaultPatch
     */
    public Builder(String backupVaultName, Map<String, Object> backupVaultPatch) {
      this.backupVaultName = backupVaultName;
      this.backupVaultPatch = backupVaultPatch;
    }

    /**
     * Builds a UpdateBackupVaultOptions.
     *
     * @return the new UpdateBackupVaultOptions instance
     */
    public UpdateBackupVaultOptions build() {
      return new UpdateBackupVaultOptions(this);
    }

    /**
     * Set the backupVaultName.
     *
     * @param backupVaultName the backupVaultName
     * @return the UpdateBackupVaultOptions builder
     */
    public Builder backupVaultName(String backupVaultName) {
      this.backupVaultName = backupVaultName;
      return this;
    }

    /**
     * Set the backupVaultPatch.
     *
     * @param backupVaultPatch the backupVaultPatch
     * @return the UpdateBackupVaultOptions builder
     */
    public Builder backupVaultPatch(Map<String, Object> backupVaultPatch) {
      this.backupVaultPatch = backupVaultPatch;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateBackupVaultOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }
  }

  protected UpdateBackupVaultOptions() { }

  protected UpdateBackupVaultOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.backupVaultName,
      "backupVaultName cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.backupVaultPatch,
      "backupVaultPatch cannot be null");
    backupVaultName = builder.backupVaultName;
    backupVaultPatch = builder.backupVaultPatch;
    ifMatch = builder.ifMatch;
  }

  /**
   * New builder.
   *
   * @return a UpdateBackupVaultOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the backupVaultName.
   *
   * Name of the backup-vault to create or update.
   *
   * @return the backupVaultName
   */
  public String backupVaultName() {
    return backupVaultName;
  }

  /**
   * Gets the backupVaultPatch.
   *
   * A Backup Vault config object containing changes to apply to the existing Backup Vault config.
   *
   * @return the backupVaultPatch
   */
  public Map<String, Object> backupVaultPatch() {
    return backupVaultPatch;
  }

  /**
   * Gets the ifMatch.
   *
   * Conditionally update the Backup Vault config if and only if the ETag of the existing config exactly matches the
   * provided If-Match MD5.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }
}

