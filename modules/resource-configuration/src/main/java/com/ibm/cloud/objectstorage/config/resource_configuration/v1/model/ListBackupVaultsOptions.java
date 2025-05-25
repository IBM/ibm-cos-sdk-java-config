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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listBackupVaults options.
 */
public class ListBackupVaultsOptions extends GenericModel {

  protected String serviceInstanceId;
  protected String token;

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceInstanceId;
    private String token;

    /**
     * Instantiates a new Builder from an existing ListBackupVaultsOptions instance.
     *
     * @param listBackupVaultsOptions the instance to initialize the Builder with
     */
    private Builder(ListBackupVaultsOptions listBackupVaultsOptions) {
      this.serviceInstanceId = listBackupVaultsOptions.serviceInstanceId;
      this.token = listBackupVaultsOptions.token;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param serviceInstanceId the serviceInstanceId
     */
    public Builder(String serviceInstanceId) {
      this.serviceInstanceId = serviceInstanceId;
    }

    /**
     * Builds a ListBackupVaultsOptions.
     *
     * @return the new ListBackupVaultsOptions instance
     */
    public ListBackupVaultsOptions build() {
      return new ListBackupVaultsOptions(this);
    }

    /**
     * Set the serviceInstanceId.
     *
     * @param serviceInstanceId the serviceInstanceId
     * @return the ListBackupVaultsOptions builder
     */
    public Builder serviceInstanceId(String serviceInstanceId) {
      this.serviceInstanceId = serviceInstanceId;
      return this;
    }

    /**
     * Set the token.
     *
     * @param token the token
     * @return the ListBackupVaultsOptions builder
     */
    public Builder token(String token) {
      this.token = token;
      return this;
    }
  }

  protected ListBackupVaultsOptions() { }

  protected ListBackupVaultsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceInstanceId,
      "serviceInstanceId cannot be null");
    serviceInstanceId = builder.serviceInstanceId;
    token = builder.token;
  }

  /**
   * New builder.
   *
   * @return a ListBackupVaultsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the serviceInstanceId.
   *
   * Name of the service_instance to list BackupVaults for.
   *
   * @return the serviceInstanceId
   */
  public String serviceInstanceId() {
    return serviceInstanceId;
  }

  /**
   * Gets the token.
   *
   * the continuation token for controlling pagination.
   *
   * @return the token
   */
  public String token() {
    return token;
  }
}

