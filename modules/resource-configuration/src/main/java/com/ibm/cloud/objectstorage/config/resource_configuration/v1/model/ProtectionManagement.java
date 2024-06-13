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
 * Data structure holding protection management operations.
 */
public class ProtectionManagement extends GenericModel {

  /**
   * If set to `activate`, protection management action on the bucket is being activated.
   */
  public interface RequestedState {
    /** activate. */
    String ACTIVATE = "activate";
    /** deactivate. */
    String DEACTIVATE = "deactivate";
  }

  @SerializedName("requested_state")
  protected String requestedState;
  @SerializedName("protection_management_token")
  protected String protectionManagementToken;

  /**
   * Builder.
   */
  public static class Builder {
    private String requestedState;
    private String protectionManagementToken;

    /**
     * Instantiates a new Builder from an existing ProtectionManagement instance.
     *
     * @param protectionManagement the instance to initialize the Builder with
     */
    private Builder(ProtectionManagement protectionManagement) {
      this.requestedState = protectionManagement.requestedState;
      this.protectionManagementToken = protectionManagement.protectionManagementToken;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ProtectionManagement.
     *
     * @return the new ProtectionManagement instance
     */
    public ProtectionManagement build() {
      return new ProtectionManagement(this);
    }

    /**
     * Set the requestedState.
     *
     * @param requestedState the requestedState
     * @return the ProtectionManagement builder
     */
    public Builder requestedState(String requestedState) {
      this.requestedState = requestedState;
      return this;
    }

    /**
     * Set the protectionManagementToken.
     *
     * @param protectionManagementToken the protectionManagementToken
     * @return the ProtectionManagement builder
     */
    public Builder protectionManagementToken(String protectionManagementToken) {
      this.protectionManagementToken = protectionManagementToken;
      return this;
    }
  }

  protected ProtectionManagement() { }

  protected ProtectionManagement(Builder builder) {
    requestedState = builder.requestedState;
    protectionManagementToken = builder.protectionManagementToken;
  }

  /**
   * New builder.
   *
   * @return a ProtectionManagement builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the requestedState.
   *
   * If set to `activate`, protection management action on the bucket is being activated.
   *
   * @return the requestedState
   */
  public String requestedState() {
    return requestedState;
  }

  /**
   * Gets the protectionManagementToken.
   *
   * This field is required when using requested_state\:`activate` and holds a JWT that is provided by the Cloud
   * Operator. This should be the encoded JWT.
   *
   * @return the protectionManagementToken
   */
  public String protectionManagementToken() {
    return protectionManagementToken;
  }
}

