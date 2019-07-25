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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A bucket.
 */
public class Bucket extends GenericModel {

  private String name;
  private String crn;
  @SerializedName("service_instance_id")
  private String serviceInstanceId;
  @SerializedName("service_instance_crn")
  private String serviceInstanceCrn;
  @SerializedName("time_created")
  private Date timeCreated;
  @SerializedName("time_updated")
  private Date timeUpdated;
  @SerializedName("object_count")
  private Long objectCount;
  @SerializedName("bytes_used")
  private Long bytesUsed;
  private Firewall firewall;
  @SerializedName("activity_tracking")
  private ActivityTracking activityTracking;

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
   * Enables sending log data to Activity Tracker and LogDNA to provide visibility into object read and write events.
   * All object events are sent to the activity tracker instance defined in the `activity_tracker_crn` field.
   *
   * @return the activityTracking
   */
  public ActivityTracking getActivityTracking() {
    return activityTracking;
  }
}

