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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.GsonSingleton;

/**
 * Metadata elements on a backup vault that can be updated.
 */
public class BackupVaultPatch extends GenericModel {

  @SerializedName("activity_tracking")
  protected BackupVaultActivityTracking activityTracking;
  @SerializedName("metrics_monitoring")
  protected BackupVaultMetricsMonitoring metricsMonitoring;

  /**
   * Builder.
   */
  public static class Builder {
    private BackupVaultActivityTracking activityTracking;
    private BackupVaultMetricsMonitoring metricsMonitoring;

    /**
     * Instantiates a new Builder from an existing BackupVaultPatch instance.
     *
     * @param backupVaultPatch the instance to initialize the Builder with
     */
    private Builder(BackupVaultPatch backupVaultPatch) {
      this.activityTracking = backupVaultPatch.activityTracking;
      this.metricsMonitoring = backupVaultPatch.metricsMonitoring;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a BackupVaultPatch.
     *
     * @return the new BackupVaultPatch instance
     */
    public BackupVaultPatch build() {
      return new BackupVaultPatch(this);
    }

    /**
     * Set the activityTracking.
     *
     * @param activityTracking the activityTracking
     * @return the BackupVaultPatch builder
     */
    public Builder activityTracking(BackupVaultActivityTracking activityTracking) {
      this.activityTracking = activityTracking;
      return this;
    }

    /**
     * Set the metricsMonitoring.
     *
     * @param metricsMonitoring the metricsMonitoring
     * @return the BackupVaultPatch builder
     */
    public Builder metricsMonitoring(BackupVaultMetricsMonitoring metricsMonitoring) {
      this.metricsMonitoring = metricsMonitoring;
      return this;
    }
  }

  protected BackupVaultPatch() { }

  protected BackupVaultPatch(Builder builder) {
    activityTracking = builder.activityTracking;
    metricsMonitoring = builder.metricsMonitoring;
  }

  /**
   * New builder.
   *
   * @return a BackupVaultPatch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the activityTracking.
   *
   * Activity Tracking configuration. An empty object (`{}`) indicates no configuration, and no events will be sent
   * (This is the same behavior as `{"management_events":false}`). Note that read/write events cannot be enabled, and
   * events cannot be routed to a non-default Activity Tracker instance.
   *
   * @return the activityTracking
   */
  public BackupVaultActivityTracking activityTracking() {
    return activityTracking;
  }

  /**
   * Gets the metricsMonitoring.
   *
   * Metrics Monitoring configuration. An empty object (`{}`) indicates no configuration, and no metrics will be
   * collected (This is the same behavior as `{"usage_metrics_enabled":false}`). Note that request metrics cannot be
   * enabled, and metrics cannot be routed to a non-default metrics router instance.
   *
   * @return the metricsMonitoring
   */
  public BackupVaultMetricsMonitoring metricsMonitoring() {
    return metricsMonitoring;
  }

  /**
   * Construct a JSON merge-patch from the BackupVaultPatch.
   *
   * Note that properties of the BackupVaultPatch with null values are not represented in the constructed
   * JSON merge-patch object, but can be explicitly set afterward to signify a property delete.
   *
   * @return a JSON merge-patch for the BackupVaultPatch
   */
  public Map<String, Object> asPatch() {
    return GsonSingleton.getGson().fromJson(this.toString(), Map.class);
  }
}

