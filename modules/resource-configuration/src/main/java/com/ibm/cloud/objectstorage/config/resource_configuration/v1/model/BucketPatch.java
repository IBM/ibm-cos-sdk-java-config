/*
 * (C) Copyright IBM Corp. 2022.
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
 * An object containing new bucket metadata.
 */
public class BucketPatch extends GenericModel {

  protected Firewall firewall;
  @SerializedName("activity_tracking")
  protected ActivityTracking activityTracking;
  @SerializedName("metrics_monitoring")
  protected MetricsMonitoring metricsMonitoring;
  @SerializedName("hard_quota")
  protected Long hardQuota;

  /**
   * Builder.
   */
  public static class Builder {
    private Firewall firewall;
    private ActivityTracking activityTracking;
    private MetricsMonitoring metricsMonitoring;
    private Long hardQuota;

    /**
     * Instantiates a new Builder from an existing BucketPatch instance.
     *
     * @param bucketPatch the instance to initialize the Builder with
     */
    private Builder(BucketPatch bucketPatch) {
      this.firewall = bucketPatch.firewall;
      this.activityTracking = bucketPatch.activityTracking;
      this.metricsMonitoring = bucketPatch.metricsMonitoring;
      this.hardQuota = bucketPatch.hardQuota;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a BucketPatch.
     *
     * @return the new BucketPatch instance
     */
    public BucketPatch build() {
      return new BucketPatch(this);
    }

    /**
     * Set the firewall.
     *
     * @param firewall the firewall
     * @return the BucketPatch builder
     */
    public Builder firewall(Firewall firewall) {
      this.firewall = firewall;
      return this;
    }

    /**
     * Set the activityTracking.
     *
     * @param activityTracking the activityTracking
     * @return the BucketPatch builder
     */
    public Builder activityTracking(ActivityTracking activityTracking) {
      this.activityTracking = activityTracking;
      return this;
    }

    /**
     * Set the metricsMonitoring.
     *
     * @param metricsMonitoring the metricsMonitoring
     * @return the BucketPatch builder
     */
    public Builder metricsMonitoring(MetricsMonitoring metricsMonitoring) {
      this.metricsMonitoring = metricsMonitoring;
      return this;
    }

    /**
     * Set the hardQuota.
     *
     * @param hardQuota the hardQuota
     * @return the BucketPatch builder
     */
    public Builder hardQuota(long hardQuota) {
      this.hardQuota = hardQuota;
      return this;
    }
  }

  protected BucketPatch() { }

  protected BucketPatch(Builder builder) {
    firewall = builder.firewall;
    activityTracking = builder.activityTracking;
    metricsMonitoring = builder.metricsMonitoring;
    hardQuota = builder.hardQuota;
  }

  /**
   * New builder.
   *
   * @return a BucketPatch builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the firewall.
   *
   * An access control mechanism based on the network (IP address) where request originated. Requests not originating
   * from IP addresses listed in the `allowed_ip` field will be denied regardless of any access policies (including
   * public access) that might otherwise permit the request.  Viewing or updating the `Firewall` element requires the
   * requester to have the `manager` role.
   *
   * @return the firewall
   */
  public Firewall firewall() {
    return firewall;
  }

  /**
   * Gets the activityTracking.
   *
   * Enables sending log data to IBM Cloud Activity Tracker to provide visibility into object read and write events. All
   * object events are sent to the activity tracker instance defined in the `activity_tracker_crn` field.
   *
   * @return the activityTracking
   */
  public ActivityTracking activityTracking() {
    return activityTracking;
  }

  /**
   * Gets the metricsMonitoring.
   *
   * Enables sending metrics to IBM Cloud Monitoring. All metrics are sent to the IBM Cloud Monitoring instance defined
   * in the `monitoring_crn` field.
   *
   * @return the metricsMonitoring
   */
  public MetricsMonitoring metricsMonitoring() {
    return metricsMonitoring;
  }

  /**
   * Gets the hardQuota.
   *
   * Maximum bytes for this bucket.
   *
   * @return the hardQuota
   */
  public Long hardQuota() {
    return hardQuota;
  }

  /**
   * Construct a JSON merge-patch from the BucketPatch.
   *
   * Note that properties of the BucketPatch with null values are not represented in the constructed
   * JSON merge-patch object, but can be explicitly set afterward to signify a property delete.
   *
   * @return a JSON merge-patch for the BucketPatch
   */
  public Map<String, Object> asPatch() {
    return GsonSingleton.getGson().fromJson(this.toString(), Map.class);
  }

}

