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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A bucket.
 */
public class Bucket extends GenericModel {

  protected String name;
  protected String crn;
  @SerializedName("service_instance_id")
  protected String serviceInstanceId;
  @SerializedName("service_instance_crn")
  protected String serviceInstanceCrn;
  @SerializedName("time_created")
  protected Date timeCreated;
  @SerializedName("time_updated")
  protected Date timeUpdated;
  @SerializedName("object_count")
  protected Long objectCount;
  @SerializedName("bytes_used")
  protected Long bytesUsed;
  @SerializedName("noncurrent_object_count")
  protected Long noncurrentObjectCount;
  @SerializedName("noncurrent_bytes_used")
  protected Long noncurrentBytesUsed;
  @SerializedName("delete_marker_count")
  protected Long deleteMarkerCount;
  protected Firewall firewall;
  @SerializedName("activity_tracking")
  protected ActivityTracking activityTracking;
  @SerializedName("metrics_monitoring")
  protected MetricsMonitoring metricsMonitoring;
  @SerializedName("hard_quota")
  protected Long hardQuota;
  @SerializedName("protection_management")
  protected ProtectionManagementResponse protectionManagement;

  protected Bucket() { }

  /**
   * Gets the name.
   *
   * The name of the bucket. Non-mutable.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the crn.
   *
   * The service instance that holds the bucket. Non-mutable.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the serviceInstanceId.
   *
   * The service instance that holds the bucket. Non-mutable.
   *
   * @return the serviceInstanceId
   */
  public String getServiceInstanceId() {
    return serviceInstanceId;
  }

  /**
   * Gets the serviceInstanceCrn.
   *
   * The service instance that holds the bucket. Non-mutable.
   *
   * @return the serviceInstanceCrn
   */
  public String getServiceInstanceCrn() {
    return serviceInstanceCrn;
  }

  /**
   * Gets the timeCreated.
   *
   * The creation time of the bucket in RFC 3339 format. Non-mutable.
   *
   * @return the timeCreated
   */
  public Date getTimeCreated() {
    return timeCreated;
  }

  /**
   * Gets the timeUpdated.
   *
   * The modification time of the bucket in RFC 3339 format. Non-mutable.
   *
   * @return the timeUpdated
   */
  public Date getTimeUpdated() {
    return timeUpdated;
  }

  /**
   * Gets the objectCount.
   *
   * Total number of objects in the bucket. Non-mutable.
   *
   * @return the objectCount
   */
  public Long getObjectCount() {
    return objectCount;
  }

  /**
   * Gets the bytesUsed.
   *
   * Total size of all objects in the bucket. Non-mutable.
   *
   * @return the bytesUsed
   */
  public Long getBytesUsed() {
    return bytesUsed;
  }

  /**
   * Gets the noncurrentObjectCount.
   *
   * Number of non-current object versions in the bucket. Non-mutable.
   *
   * @return the noncurrentObjectCount
   */
  public Long getNoncurrentObjectCount() {
    return noncurrentObjectCount;
  }

  /**
   * Gets the noncurrentBytesUsed.
   *
   * Total size of all non-current object versions in the bucket. Non-mutable.
   *
   * @return the noncurrentBytesUsed
   */
  public Long getNoncurrentBytesUsed() {
    return noncurrentBytesUsed;
  }

  /**
   * Gets the deleteMarkerCount.
   *
   * Total number of delete markers in the bucket. Non-mutable.
   *
   * @return the deleteMarkerCount
   */
  public Long getDeleteMarkerCount() {
    return deleteMarkerCount;
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
  public Firewall getFirewall() {
    return firewall;
  }

  /**
   * Gets the activityTracking.
   *
   * Enables sending log data to IBM Cloud Activity Tracker Event Routing to provide visibility into bucket management,
   * object read and write events. (Recommended) When the `activity_tracker_crn` is not populated, then enabled events
   * are sent to the Activity Tracker Event Routing instance at the container's location unless otherwise specified in
   * the Activity Tracker Event Routing Event Routing service configuration. (Legacy) When the `activity_tracker_crn` is
   * populated, then enabled events are sent to the Activity Tracker Event Routing instance specified.
   *
   * @return the activityTracking
   */
  public ActivityTracking getActivityTracking() {
    return activityTracking;
  }

  /**
   * Gets the metricsMonitoring.
   *
   * Enables sending metrics to IBM Cloud Monitoring.  All metrics are opt-in. (Recommended) When the
   * `metrics_monitoring_crn` is not populated, then enabled metrics are sent to the Monitoring instance at the
   * container's location unless otherwise specified in the Metrics Router service configuration. (Legacy) When the
   * `metrics_monitoring_crn` is populated, then enabled metrics are sent to the Monitoring instance defined in the
   * `metrics_monitoring_crn` field.
   *
   * @return the metricsMonitoring
   */
  public MetricsMonitoring getMetricsMonitoring() {
    return metricsMonitoring;
  }

  /**
   * Gets the hardQuota.
   *
   * Maximum bytes for this bucket.
   *
   * @return the hardQuota
   */
  public Long getHardQuota() {
    return hardQuota;
  }

  /**
   * Gets the protectionManagement.
   *
   * Data structure holding protection management response.
   *
   * @return the protectionManagement
   */
  public ProtectionManagementResponse getProtectionManagement() {
    return protectionManagement;
  }
}

