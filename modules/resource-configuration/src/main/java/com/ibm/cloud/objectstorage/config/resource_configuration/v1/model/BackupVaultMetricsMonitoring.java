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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Metrics Monitoring configuration. An empty object (`{}`) indicates no configuration, and no metrics will be collected
 * (This is the same behavior as `{"usage_metrics_enabled":false}`). Note that request metrics cannot be enabled, and
 * metrics cannot be routed to a non-default metrics router instance.
 */
public class BackupVaultMetricsMonitoring extends GenericModel {

  @SerializedName("usage_metrics_enabled")
  protected Boolean usageMetricsEnabled;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean usageMetricsEnabled;

    /**
     * Instantiates a new Builder from an existing BackupVaultMetricsMonitoring instance.
     *
     * @param backupVaultMetricsMonitoring the instance to initialize the Builder with
     */
    private Builder(BackupVaultMetricsMonitoring backupVaultMetricsMonitoring) {
      this.usageMetricsEnabled = backupVaultMetricsMonitoring.usageMetricsEnabled;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a BackupVaultMetricsMonitoring.
     *
     * @return the new BackupVaultMetricsMonitoring instance
     */
    public BackupVaultMetricsMonitoring build() {
      return new BackupVaultMetricsMonitoring(this);
    }

    /**
     * Set the usageMetricsEnabled.
     *
     * @param usageMetricsEnabled the usageMetricsEnabled
     * @return the BackupVaultMetricsMonitoring builder
     */
    public Builder usageMetricsEnabled(Boolean usageMetricsEnabled) {
      this.usageMetricsEnabled = usageMetricsEnabled;
      return this;
    }
  }

  protected BackupVaultMetricsMonitoring() { }

  protected BackupVaultMetricsMonitoring(Builder builder) {
    usageMetricsEnabled = builder.usageMetricsEnabled;
  }

  /**
   * New builder.
   *
   * @return a BackupVaultMetricsMonitoring builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the usageMetricsEnabled.
   *
   * Whether usage metrics are collected for this BackupVault.
   *
   * @return the usageMetricsEnabled
   */
  public Boolean usageMetricsEnabled() {
    return usageMetricsEnabled;
  }
}

