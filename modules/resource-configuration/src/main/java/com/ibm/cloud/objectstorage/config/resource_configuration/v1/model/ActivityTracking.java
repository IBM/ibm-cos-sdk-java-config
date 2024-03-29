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
 * Enables sending log data to IBM Cloud Activity Tracker to provide visibility into object read and write events. All
 * object events are sent to the activity tracker instance defined in the `activity_tracker_crn` field.
 */
public class ActivityTracking extends GenericModel {

  @SerializedName("read_data_events")
  protected Boolean readDataEvents;
  @SerializedName("write_data_events")
  protected Boolean writeDataEvents;
  @SerializedName("activity_tracker_crn")
  protected String activityTrackerCrn;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean readDataEvents;
    private Boolean writeDataEvents;
    private String activityTrackerCrn;

    /**
     * Instantiates a new Builder from an existing ActivityTracking instance.
     *
     * @param activityTracking the instance to initialize the Builder with
     */
    private Builder(ActivityTracking activityTracking) {
      this.readDataEvents = activityTracking.readDataEvents;
      this.writeDataEvents = activityTracking.writeDataEvents;
      this.activityTrackerCrn = activityTracking.activityTrackerCrn;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ActivityTracking.
     *
     * @return the new ActivityTracking instance
     */
    public ActivityTracking build() {
      return new ActivityTracking(this);
    }

    /**
     * Set the readDataEvents.
     *
     * @param readDataEvents the readDataEvents
     * @return the ActivityTracking builder
     */
    public Builder readDataEvents(Boolean readDataEvents) {
      this.readDataEvents = readDataEvents;
      return this;
    }

    /**
     * Set the writeDataEvents.
     *
     * @param writeDataEvents the writeDataEvents
     * @return the ActivityTracking builder
     */
    public Builder writeDataEvents(Boolean writeDataEvents) {
      this.writeDataEvents = writeDataEvents;
      return this;
    }

    /**
     * Set the activityTrackerCrn.
     *
     * @param activityTrackerCrn the activityTrackerCrn
     * @return the ActivityTracking builder
     */
    public Builder activityTrackerCrn(String activityTrackerCrn) {
      this.activityTrackerCrn = activityTrackerCrn;
      return this;
    }
  }

  protected ActivityTracking() { }

  protected ActivityTracking(Builder builder) {
    readDataEvents = builder.readDataEvents;
    writeDataEvents = builder.writeDataEvents;
    activityTrackerCrn = builder.activityTrackerCrn;
  }

  /**
   * New builder.
   *
   * @return a ActivityTracking builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the readDataEvents.
   *
   * If set to `true`, all object read events (i.e. downloads) will be sent to Activity Tracker.
   *
   * @return the readDataEvents
   */
  public Boolean readDataEvents() {
    return readDataEvents;
  }

  /**
   * Gets the writeDataEvents.
   *
   * If set to `true`, all object write events (i.e. uploads) will be sent to Activity Tracker.
   *
   * @return the writeDataEvents
   */
  public Boolean writeDataEvents() {
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
  public String activityTrackerCrn() {
    return activityTrackerCrn;
  }
}

