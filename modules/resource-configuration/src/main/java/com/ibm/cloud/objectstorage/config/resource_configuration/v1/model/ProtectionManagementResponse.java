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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Data structure holding protection management response.
 */
public class ProtectionManagementResponse extends GenericModel {

  @SerializedName("token_applied_counter")
  protected String tokenAppliedCounter;
  @SerializedName("token_entries")
  protected List<ProtectionManagementResponseTokenEntry> tokenEntries;

  /**
   * Builder.
   */
  public static class Builder {
    private String tokenAppliedCounter;
    private List<ProtectionManagementResponseTokenEntry> tokenEntries;

    /**
     * Instantiates a new Builder from an existing ProtectionManagementResponse instance.
     *
     * @param protectionManagementResponse the instance to initialize the Builder with
     */
    private Builder(ProtectionManagementResponse protectionManagementResponse) {
      this.tokenAppliedCounter = protectionManagementResponse.tokenAppliedCounter;
      this.tokenEntries = protectionManagementResponse.tokenEntries;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ProtectionManagementResponse.
     *
     * @return the new ProtectionManagementResponse instance
     */
    public ProtectionManagementResponse build() {
      return new ProtectionManagementResponse(this);
    }

    /**
     * Adds a new element to tokenEntries.
     *
     * @param tokenEntries the new element to be added
     * @return the ProtectionManagementResponse builder
     */
    public Builder addTokenEntries(ProtectionManagementResponseTokenEntry tokenEntries) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tokenEntries,
        "tokenEntries cannot be null");
      if (this.tokenEntries == null) {
        this.tokenEntries = new ArrayList<ProtectionManagementResponseTokenEntry>();
      }
      this.tokenEntries.add(tokenEntries);
      return this;
    }

    /**
     * Set the tokenAppliedCounter.
     *
     * @param tokenAppliedCounter the tokenAppliedCounter
     * @return the ProtectionManagementResponse builder
     */
    public Builder tokenAppliedCounter(String tokenAppliedCounter) {
      this.tokenAppliedCounter = tokenAppliedCounter;
      return this;
    }

    /**
     * Set the tokenEntries.
     * Existing tokenEntries will be replaced.
     *
     * @param tokenEntries the tokenEntries
     * @return the ProtectionManagementResponse builder
     */
    public Builder tokenEntries(List<ProtectionManagementResponseTokenEntry> tokenEntries) {
      this.tokenEntries = tokenEntries;
      return this;
    }
  }

  protected ProtectionManagementResponse() { }

  protected ProtectionManagementResponse(Builder builder) {
    tokenAppliedCounter = builder.tokenAppliedCounter;
    tokenEntries = builder.tokenEntries;
  }

  /**
   * New builder.
   *
   * @return a ProtectionManagementResponse builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the tokenAppliedCounter.
   *
   * Indicates the X number of protection management tokens that have been applied to the bucket in its lifetime.
   *
   * @return the tokenAppliedCounter
   */
  public String tokenAppliedCounter() {
    return tokenAppliedCounter;
  }

  /**
   * Gets the tokenEntries.
   *
   * The 'protection management token list' holding a recent list of applied tokens. This list may contain a subset of
   * all tokens applied to the bucket, as indicated by the counter.
   *
   * @return the tokenEntries
   */
  public List<ProtectionManagementResponseTokenEntry> tokenEntries() {
    return tokenEntries;
  }
}

