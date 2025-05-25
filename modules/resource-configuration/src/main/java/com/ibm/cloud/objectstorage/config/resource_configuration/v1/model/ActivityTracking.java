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
 * Enables sending log data to IBM Cloud Activity Tracker Event Routing to provide visibility into bucket management,
 * object read and write events. (Recommended) When the `activity_tracker_crn` is not populated, then enabled events are
 * sent to the Activity Tracker Event Routing instance at the container's location unless otherwise specified in the
 * Activity Tracker Event Routing Event Routing service configuration. (Legacy) When the `activity_tracker_crn` is
 * populated, then enabled events are sent to the Activity Tracker Event Routing instance specified.
 */
public class ActivityTracking extends GenericModel {

  @SerializedName("read_data_events")
  protected Boolean readDataEvents;
  @SerializedName("write_data_events")
  protected Boolean writeDataEvents;
  @SerializedName("activity_tracker_crn")
  protected String activityTrackerCrn;
  @SerializedName("management_events")
  protected Boolean managementEvents;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean readDataEvents;
    private Boolean writeDataEvents;
    private String activityTrackerCrn;
    private Boolean managementEvents;

    /**
     * Instantiates a new Builder from an existing ActivityTracking instance.
     *
     * @param activityTracking the instance to initialize the Builder with
     */
    private Builder(ActivityTracking activityTracking) {
      this.readDataEvents = activityTracking.readDataEvents;
      this.writeDataEvents = activityTracking.writeDataEvents;
      this.activityTrackerCrn = activityTracking.activityTrackerCrn;
      this.managementEvents = activityTracking.managementEvents;
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

    /**
     * Set the managementEvents.
     *
     * @param managementEvents the managementEvents
     * @return the ActivityTracking builder
     */
    public Builder managementEvents(Boolean managementEvents) {
      this.managementEvents = managementEvents;
      return this;
    }
  }

  protected ActivityTracking() { }

  protected ActivityTracking(Builder builder) {
    readDataEvents = builder.readDataEvents;
    writeDataEvents = builder.writeDataEvents;
    activityTrackerCrn = builder.activityTrackerCrn;
    managementEvents = builder.managementEvents;
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
   * If set to `true`, all object read events (i.e. downloads) will be sent to Activity Tracker Event Routing.
   *
   * @return the readDataEvents
   */
  public Boolean readDataEvents() {
    return readDataEvents;
  }

  /**
   * Gets the writeDataEvents.
   *
   * If set to `true`, all object write events (i.e. uploads) will be sent to Activity Tracker Event Routing.
   *
   * @return the writeDataEvents
   */
  public Boolean writeDataEvents() {
    return writeDataEvents;
  }

  /**
   * Gets the activityTrackerCrn.
   *
   * When the `activity_tracker_crn` is not populated, then enabled events are sent to the Activity Tracker Event
   * Routing instance associated to the container's location unless otherwise specified in the Activity Tracker Event
   * Routing Event Routing service configuration. If `activity_tracker_crn` is populated, then enabled events are sent
   * to the Activity Tracker Event Routing instance specified and bucket management events are always enabled.
   *
   * @return the activityTrackerCrn
   */
  public String activityTrackerCrn() {
    return activityTrackerCrn;
  }

  /**
   * Gets the managementEvents.
   *
   * This field only applies if `activity_tracker_crn` is not populated. If set to `true`, all bucket management events
   * will be sent to Activity Tracker Event Routing.
   *
   * @return the managementEvents
   */
  public Boolean managementEvents() {
    return managementEvents;
  }
}

