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
 * Enables sending log data to Activity Tracker and LogDNA to provide visibility into object read and write events. All
 * object events are sent to the activity tracker instance defined in the `activity_tracker_crn` field.
 */
public class ActivityTracking extends GenericModel {

  @SerializedName("read_data_events")
  private Boolean readDataEvents;
  @SerializedName("write_data_events")
  private Boolean writeDataEvents;
  @SerializedName("activity_tracker_crn")
  private String activityTrackerCrn;

  /**
   * Gets the readDataEvents.
   *
   * If set to `true`, all object read events (i.e. downloads) will be sent to Activity Tracker.
   *
   * @return the readDataEvents
   */
  public Boolean isReadDataEvents() {
    return readDataEvents;
  }

  /**
   * Gets the writeDataEvents.
   *
   * If set to `true`, all object write events (i.e. uploads) will be sent to Activity Tracker.
   *
   * @return the writeDataEvents
   */
  public Boolean isWriteDataEvents() {
    return writeDataEvents;
  }

  /**
   * Gets the activityTrackerCrn.
   *
   * Required the first time `activity_tracking` is configured. The instance of Activity Tracker that will receive
   * object event data. The format is "crn:v1:bluemix:public:logdnaat:{bucket location}:a/{storage account}:{activity
   * tracker service instance}::".
   *
   * @return the activityTrackerCrn
   */
  public String getActivityTrackerCrn() {
    return activityTrackerCrn;
  }

  /**
   * Sets the readDataEvents.
   *
   * @param readDataEvents the new readDataEvents
   */
  public void setReadDataEvents(final Boolean readDataEvents) {
    this.readDataEvents = readDataEvents;
  }

  /**
   * Sets the writeDataEvents.
   *
   * @param writeDataEvents the new writeDataEvents
   */
  public void setWriteDataEvents(final Boolean writeDataEvents) {
    this.writeDataEvents = writeDataEvents;
  }

  /**
   * Sets the activityTrackerCrn.
   *
   * @param activityTrackerCrn the new activityTrackerCrn
   */
  public void setActivityTrackerCrn(final String activityTrackerCrn) {
    this.activityTrackerCrn = activityTrackerCrn;
  }
}

