/*
 * (C) Copyright IBM Corp. 2024.
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
 * Enables sending metrics to IBM Cloud Monitoring.  All metrics are opt-in. (Recommended) When the
 * `metrics_monitoring_crn` is not populated, then enabled metrics are sent to the Monitoring instance at the
 * container's location unless otherwise specified in the Metrics Router service configuration. (Legacy) When the
 * `metrics_monitoring_crn` is populated, then enabled metrics are sent to the Monitoring instance defined in the
 * `metrics_monitoring_crn` field.
 */
public class MetricsMonitoring extends GenericModel {

  @SerializedName("usage_metrics_enabled")
  protected Boolean usageMetricsEnabled;
  @SerializedName("request_metrics_enabled")
  protected Boolean requestMetricsEnabled;
  @SerializedName("metrics_monitoring_crn")
  protected String metricsMonitoringCrn;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean usageMetricsEnabled;
    private Boolean requestMetricsEnabled;
    private String metricsMonitoringCrn;

    /**
     * Instantiates a new Builder from an existing MetricsMonitoring instance.
     *
     * @param metricsMonitoring the instance to initialize the Builder with
     */
    private Builder(MetricsMonitoring metricsMonitoring) {
      this.usageMetricsEnabled = metricsMonitoring.usageMetricsEnabled;
      this.requestMetricsEnabled = metricsMonitoring.requestMetricsEnabled;
      this.metricsMonitoringCrn = metricsMonitoring.metricsMonitoringCrn;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MetricsMonitoring.
     *
     * @return the new MetricsMonitoring instance
     */
    public MetricsMonitoring build() {
      return new MetricsMonitoring(this);
    }

    /**
     * Set the usageMetricsEnabled.
     *
     * @param usageMetricsEnabled the usageMetricsEnabled
     * @return the MetricsMonitoring builder
     */
    public Builder usageMetricsEnabled(Boolean usageMetricsEnabled) {
      this.usageMetricsEnabled = usageMetricsEnabled;
      return this;
    }

    /**
     * Set the requestMetricsEnabled.
     *
     * @param requestMetricsEnabled the requestMetricsEnabled
     * @return the MetricsMonitoring builder
     */
    public Builder requestMetricsEnabled(Boolean requestMetricsEnabled) {
      this.requestMetricsEnabled = requestMetricsEnabled;
      return this;
    }

    /**
     * Set the metricsMonitoringCrn.
     *
     * @param metricsMonitoringCrn the metricsMonitoringCrn
     * @return the MetricsMonitoring builder
     */
    public Builder metricsMonitoringCrn(String metricsMonitoringCrn) {
      this.metricsMonitoringCrn = metricsMonitoringCrn;
      return this;
    }
  }

  protected MetricsMonitoring() { }

  protected MetricsMonitoring(Builder builder) {
    usageMetricsEnabled = builder.usageMetricsEnabled;
    requestMetricsEnabled = builder.requestMetricsEnabled;
    metricsMonitoringCrn = builder.metricsMonitoringCrn;
  }

  /**
   * New builder.
   *
   * @return a MetricsMonitoring builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the usageMetricsEnabled.
   *
   * If set to `true`, all usage metrics (i.e. `bytes_used`) will be sent to the monitoring service.
   *
   * @return the usageMetricsEnabled
   */
  public Boolean usageMetricsEnabled() {
    return usageMetricsEnabled;
  }

  /**
   * Gets the requestMetricsEnabled.
   *
   * If set to `true`, all request metrics (i.e. `rest.object.head`) will be sent to the monitoring service.
   *
   * @return the requestMetricsEnabled
   */
  public Boolean requestMetricsEnabled() {
    return requestMetricsEnabled;
  }

  /**
   * Gets the metricsMonitoringCrn.
   *
   * When the `metrics_monitoring_crn` is not populated, then enabled metrics are sent to the monitoring instance
   * associated to the container's location unless otherwise specified in the Metrics Router service configuration. If
   * `metrics_monitoring_crn` is populated, then enabled events are sent to the Metrics Monitoring instance specified.
   *
   * @return the metricsMonitoringCrn
   */
  public String metricsMonitoringCrn() {
    return metricsMonitoringCrn;
  }
}

