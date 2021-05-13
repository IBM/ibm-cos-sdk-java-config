/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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
 * Enables sending metrics to IBM Cloud Monitoring. All metrics are sent to the IBM Cloud Monitoring instance defined in
 * the `monitoring_crn` field.
 */
public class MetricsMonitoring extends GenericModel {

  @SerializedName("usage_metrics_enabled")
  private Boolean usageMetricsEnabled;
  @SerializedName("request_metrics_enabled")
  private Boolean requestMetricsEnabled;
  @SerializedName("metrics_monitoring_crn")
  private String metricsMonitoringCrn;

  /**
   * Gets the usageMetricsEnabled.
   *
   * If set to `true`, all usage metrics (i.e. `bytes_used`) will be sent to the monitoring service.
   *
   * @return the usageMetricsEnabled
   */
  public Boolean isUsageMetricsEnabled() {
    return usageMetricsEnabled;
  }

  /**
   * Gets the requestMetricsEnabled.
   *
   * If set to `true`, all request metrics (i.e. `rest.object.head`) will be sent to the monitoring service.
   *
   * @return the requestMetricsEnabled
   */
  public Boolean isRequestMetricsEnabled() {
    return requestMetricsEnabled;
  }

  /**
   * Gets the metricsMonitoringCrn.
   *
   * Required the first time `metrics_monitoring` is configured. The instance of IBM Cloud Monitoring that will receive
   * the bucket metrics. The format is "crn:v1:bluemix:public:logdnaat:{bucket location}:a/{storage account}:{monitoring
   * service instance}::".
   *
   * @return the metricsMonitoringCrn
   */
  public String getMetricsMonitoringCrn() {
    return metricsMonitoringCrn;
  }

  /**
   * Sets the usageMetricsEnabled.
   *
   * @param usageMetricsEnabled the new usageMetricsEnabled
   */
  public void setUsageMetricsEnabled(final Boolean usageMetricsEnabled) {
    this.usageMetricsEnabled = usageMetricsEnabled;
  }

  /**
   * Sets the requestMetricsEnabled.
   *
   * @param requestMetricsEnabled the new requestMetricsEnabled
   */
  public void setRequestMetricsEnabled(final Boolean requestMetricsEnabled) {
    this.requestMetricsEnabled = requestMetricsEnabled;
  }

  /**
   * Sets the metricsMonitoringCrn.
   *
   * @param metricsMonitoringCrn the new metricsMonitoringCrn
   */
  public void setMetricsMonitoringCrn(final String metricsMonitoringCrn) {
    this.metricsMonitoringCrn = metricsMonitoringCrn;
  }
}

