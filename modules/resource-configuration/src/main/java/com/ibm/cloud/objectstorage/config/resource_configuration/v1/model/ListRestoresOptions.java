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
 * The listRestores options.
 */
public class ListRestoresOptions extends GenericModel {

  protected String backupVaultName;
  protected String token;

  /**
   * Builder.
   */
  public static class Builder {
    private String backupVaultName;
    private String token;

    /**
     * Instantiates a new Builder from an existing ListRestoresOptions instance.
     *
     * @param listRestoresOptions the instance to initialize the Builder with
     */
    private Builder(ListRestoresOptions listRestoresOptions) {
      this.backupVaultName = listRestoresOptions.backupVaultName;
      this.token = listRestoresOptions.token;
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
     * Builds a ListRestoresOptions.
     *
     * @return the new ListRestoresOptions instance
     */
    public ListRestoresOptions build() {
      return new ListRestoresOptions(this);
    }

    /**
     * Set the backupVaultName.
     *
     * @param backupVaultName the backupVaultName
     * @return the ListRestoresOptions builder
     */
    public Builder backupVaultName(String backupVaultName) {
      this.backupVaultName = backupVaultName;
      return this;
    }

    /**
     * Set the token.
     *
     * @param token the token
     * @return the ListRestoresOptions builder
     */
    public Builder token(String token) {
      this.token = token;
      return this;
    }
  }

  protected ListRestoresOptions() { }

  protected ListRestoresOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.backupVaultName,
      "backupVaultName cannot be empty");
    backupVaultName = builder.backupVaultName;
    token = builder.token;
  }

  /**
   * New builder.
   *
   * @return a ListRestoresOptions builder
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
   * Gets the token.
   *
   * the continuation token for controlling pagination.
   *
   * @return the token
   */
  public String token() {
    return token;
  }
}

