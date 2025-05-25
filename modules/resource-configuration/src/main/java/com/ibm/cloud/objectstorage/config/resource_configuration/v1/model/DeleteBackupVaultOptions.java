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
 * The deleteBackupVault options.
 */
public class DeleteBackupVaultOptions extends GenericModel {

  protected String backupVaultName;

  /**
   * Builder.
   */
  public static class Builder {
    private String backupVaultName;

    /**
     * Instantiates a new Builder from an existing DeleteBackupVaultOptions instance.
     *
     * @param deleteBackupVaultOptions the instance to initialize the Builder with
     */
    private Builder(DeleteBackupVaultOptions deleteBackupVaultOptions) {
      this.backupVaultName = deleteBackupVaultOptions.backupVaultName;
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
     */
    public Builder(String backupVaultName) {
      this.backupVaultName = backupVaultName;
    }

    /**
     * Builds a DeleteBackupVaultOptions.
     *
     * @return the new DeleteBackupVaultOptions instance
     */
    public DeleteBackupVaultOptions build() {
      return new DeleteBackupVaultOptions(this);
    }

    /**
     * Set the backupVaultName.
     *
     * @param backupVaultName the backupVaultName
     * @return the DeleteBackupVaultOptions builder
     */
    public Builder backupVaultName(String backupVaultName) {
      this.backupVaultName = backupVaultName;
      return this;
    }
  }

  protected DeleteBackupVaultOptions() { }

  protected DeleteBackupVaultOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.backupVaultName,
      "backupVaultName cannot be empty");
    backupVaultName = builder.backupVaultName;
  }

  /**
   * New builder.
   *
   * @return a DeleteBackupVaultOptions builder
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
}

