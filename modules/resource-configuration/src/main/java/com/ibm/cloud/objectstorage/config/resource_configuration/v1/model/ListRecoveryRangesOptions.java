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
 * The listRecoveryRanges options.
 */
public class ListRecoveryRangesOptions extends GenericModel {

  protected String backupVaultName;
  protected String sourceResourceCrn;
  protected String latest;
  protected String token;

  /**
   * Builder.
   */
  public static class Builder {
    private String backupVaultName;
    private String sourceResourceCrn;
    private String latest;
    private String token;

    /**
     * Instantiates a new Builder from an existing ListRecoveryRangesOptions instance.
     *
     * @param listRecoveryRangesOptions the instance to initialize the Builder with
     */
    private Builder(ListRecoveryRangesOptions listRecoveryRangesOptions) {
      this.backupVaultName = listRecoveryRangesOptions.backupVaultName;
      this.sourceResourceCrn = listRecoveryRangesOptions.sourceResourceCrn;
      this.latest = listRecoveryRangesOptions.latest;
      this.token = listRecoveryRangesOptions.token;
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
     * Builds a ListRecoveryRangesOptions.
     *
     * @return the new ListRecoveryRangesOptions instance
     */
    public ListRecoveryRangesOptions build() {
      return new ListRecoveryRangesOptions(this);
    }

    /**
     * Set the backupVaultName.
     *
     * @param backupVaultName the backupVaultName
     * @return the ListRecoveryRangesOptions builder
     */
    public Builder backupVaultName(String backupVaultName) {
      this.backupVaultName = backupVaultName;
      return this;
    }

    /**
     * Set the sourceResourceCrn.
     *
     * @param sourceResourceCrn the sourceResourceCrn
     * @return the ListRecoveryRangesOptions builder
     */
    public Builder sourceResourceCrn(String sourceResourceCrn) {
      this.sourceResourceCrn = sourceResourceCrn;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the ListRecoveryRangesOptions builder
     */
    public Builder latest(String latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the token.
     *
     * @param token the token
     * @return the ListRecoveryRangesOptions builder
     */
    public Builder token(String token) {
      this.token = token;
      return this;
    }
  }

  protected ListRecoveryRangesOptions() { }

  protected ListRecoveryRangesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.backupVaultName,
      "backupVaultName cannot be empty");
    backupVaultName = builder.backupVaultName;
    sourceResourceCrn = builder.sourceResourceCrn;
    latest = builder.latest;
    token = builder.token;
  }

  /**
   * New builder.
   *
   * @return a ListRecoveryRangesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the backupVaultName.
   *
   * name of BackupVault.
   *
   * @return the backupVaultName
   */
  public String backupVaultName() {
    return backupVaultName;
  }

  /**
   * Gets the sourceResourceCrn.
   *
   * CRN of source resource to filter on. This limits ranges returned to only ranges where the source_resource_crn
   * matches the parameter value.
   *
   * @return the sourceResourceCrn
   */
  public String sourceResourceCrn() {
    return sourceResourceCrn;
  }

  /**
   * Gets the latest.
   *
   * If "true", then return only the latest RecoveryRange for each source-resource that is backed up.
   *
   * If "false" or not specified, then the default behavior is produced.
   *
   * Value is can insensative. If any value is provided other than "true" or "false" then return 400.
   *
   * @return the latest
   */
  public String latest() {
    return latest;
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

