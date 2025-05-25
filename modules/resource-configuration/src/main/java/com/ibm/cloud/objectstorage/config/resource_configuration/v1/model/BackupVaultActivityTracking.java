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
 * Activity Tracking configuration. An empty object (`{}`) indicates no configuration, and no events will be sent (This
 * is the same behavior as `{"management_events":false}`). Note that read/write events cannot be enabled, and events
 * cannot be routed to a non-default Activity Tracker instance.
 */
public class BackupVaultActivityTracking extends GenericModel {

  @SerializedName("management_events")
  protected Boolean managementEvents;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean managementEvents;

    /**
     * Instantiates a new Builder from an existing BackupVaultActivityTracking instance.
     *
     * @param backupVaultActivityTracking the instance to initialize the Builder with
     */
    private Builder(BackupVaultActivityTracking backupVaultActivityTracking) {
      this.managementEvents = backupVaultActivityTracking.managementEvents;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a BackupVaultActivityTracking.
     *
     * @return the new BackupVaultActivityTracking instance
     */
    public BackupVaultActivityTracking build() {
      return new BackupVaultActivityTracking(this);
    }

    /**
     * Set the managementEvents.
     *
     * @param managementEvents the managementEvents
     * @return the BackupVaultActivityTracking builder
     */
    public Builder managementEvents(Boolean managementEvents) {
      this.managementEvents = managementEvents;
      return this;
    }
  }

  protected BackupVaultActivityTracking() { }

  protected BackupVaultActivityTracking(Builder builder) {
    managementEvents = builder.managementEvents;
  }

  /**
   * New builder.
   *
   * @return a BackupVaultActivityTracking builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the managementEvents.
   *
   * Whether to send notifications for management events on the BackupVault.
   *
   * @return the managementEvents
   */
  public Boolean managementEvents() {
    return managementEvents;
  }
}

