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
 * The createBackupVault options.
 */
public class CreateBackupVaultOptions extends GenericModel {

  protected String serviceInstanceId;
  protected String backupVaultName;
  protected String region;
  protected BackupVaultActivityTracking activityTracking;
  protected BackupVaultMetricsMonitoring metricsMonitoring;
  protected String sseKpCustomerRootKeyCrn;

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceInstanceId;
    private String backupVaultName;
    private String region;
    private BackupVaultActivityTracking activityTracking;
    private BackupVaultMetricsMonitoring metricsMonitoring;
    private String sseKpCustomerRootKeyCrn;

    /**
     * Instantiates a new Builder from an existing CreateBackupVaultOptions instance.
     *
     * @param createBackupVaultOptions the instance to initialize the Builder with
     */
    private Builder(CreateBackupVaultOptions createBackupVaultOptions) {
      this.serviceInstanceId = createBackupVaultOptions.serviceInstanceId;
      this.backupVaultName = createBackupVaultOptions.backupVaultName;
      this.region = createBackupVaultOptions.region;
      this.activityTracking = createBackupVaultOptions.activityTracking;
      this.metricsMonitoring = createBackupVaultOptions.metricsMonitoring;
      this.sseKpCustomerRootKeyCrn = createBackupVaultOptions.sseKpCustomerRootKeyCrn;
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
     * @param backupVaultName the backupVaultName
     * @param region the region
     */
    public Builder(String serviceInstanceId, String backupVaultName, String region) {
      this.serviceInstanceId = serviceInstanceId;
      this.backupVaultName = backupVaultName;
      this.region = region;
    }

    /**
     * Builds a CreateBackupVaultOptions.
     *
     * @return the new CreateBackupVaultOptions instance
     */
    public CreateBackupVaultOptions build() {
      return new CreateBackupVaultOptions(this);
    }

    /**
     * Set the serviceInstanceId.
     *
     * @param serviceInstanceId the serviceInstanceId
     * @return the CreateBackupVaultOptions builder
     */
    public Builder serviceInstanceId(String serviceInstanceId) {
      this.serviceInstanceId = serviceInstanceId;
      return this;
    }

    /**
     * Set the backupVaultName.
     *
     * @param backupVaultName the backupVaultName
     * @return the CreateBackupVaultOptions builder
     */
    public Builder backupVaultName(String backupVaultName) {
      this.backupVaultName = backupVaultName;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the CreateBackupVaultOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the activityTracking.
     *
     * @param activityTracking the activityTracking
     * @return the CreateBackupVaultOptions builder
     */
    public Builder activityTracking(BackupVaultActivityTracking activityTracking) {
      this.activityTracking = activityTracking;
      return this;
    }

    /**
     * Set the metricsMonitoring.
     *
     * @param metricsMonitoring the metricsMonitoring
     * @return the CreateBackupVaultOptions builder
     */
    public Builder metricsMonitoring(BackupVaultMetricsMonitoring metricsMonitoring) {
      this.metricsMonitoring = metricsMonitoring;
      return this;
    }

    /**
     * Set the sseKpCustomerRootKeyCrn.
     *
     * @param sseKpCustomerRootKeyCrn the sseKpCustomerRootKeyCrn
     * @return the CreateBackupVaultOptions builder
     */
    public Builder sseKpCustomerRootKeyCrn(String sseKpCustomerRootKeyCrn) {
      this.sseKpCustomerRootKeyCrn = sseKpCustomerRootKeyCrn;
      return this;
    }
  }

  protected CreateBackupVaultOptions() { }

  protected CreateBackupVaultOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceInstanceId,
      "serviceInstanceId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.backupVaultName,
      "backupVaultName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.region,
      "region cannot be null");
    serviceInstanceId = builder.serviceInstanceId;
    backupVaultName = builder.backupVaultName;
    region = builder.region;
    activityTracking = builder.activityTracking;
    metricsMonitoring = builder.metricsMonitoring;
    sseKpCustomerRootKeyCrn = builder.sseKpCustomerRootKeyCrn;
  }

  /**
   * New builder.
   *
   * @return a CreateBackupVaultOptions builder
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
   * Gets the backupVaultName.
   *
   * The name given to a Bucket.
   *
   * Bucket names must be between 3 and 63 characters long must be made of lowercase letters, numbers, dots (periods),
   * and dashes (hyphens). Bucket names must begin and end with a lowercase letter or number. Bucket names canâ€t
   * contain consecutive dots or dashes. Bucket names that resemble IP addresses are not allowed.
   *
   * Bucket and BackupVault names exist in a global namespace and therefore must be unique.
   *
   * @return the backupVaultName
   */
  public String backupVaultName() {
    return backupVaultName;
  }

  /**
   * Gets the region.
   *
   * the region in which this backup-vault should be created within.
   *
   * @return the region
   */
  public String region() {
    return region;
  }

  /**
   * Gets the activityTracking.
   *
   * Activity Tracking configuration. An empty object (`{}`) indicates no configuration, and no events will be sent
   * (This is the same behavior as `{"management_events":false}`). Note that read/write events cannot be enabled, and
   * events cannot be routed to a non-default Activity Tracker instance.
   *
   * @return the activityTracking
   */
  public BackupVaultActivityTracking activityTracking() {
    return activityTracking;
  }

  /**
   * Gets the metricsMonitoring.
   *
   * Metrics Monitoring configuration. An empty object (`{}`) indicates no configuration, and no metrics will be
   * collected (This is the same behavior as `{"usage_metrics_enabled":false}`). Note that request metrics cannot be
   * enabled, and metrics cannot be routed to a non-default metrics router instance.
   *
   * @return the metricsMonitoring
   */
  public BackupVaultMetricsMonitoring metricsMonitoring() {
    return metricsMonitoring;
  }

  /**
   * Gets the sseKpCustomerRootKeyCrn.
   *
   * The CRN for a KeyProtect root key.
   *
   * @return the sseKpCustomerRootKeyCrn
   */
  public String sseKpCustomerRootKeyCrn() {
    return sseKpCustomerRootKeyCrn;
  }
}

