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
 * Metadata associated with a backup vault.
 */
public class BackupVault extends GenericModel {

  @SerializedName("activity_tracking")
  protected BackupVaultActivityTracking activityTracking;
  @SerializedName("metrics_monitoring")
  protected BackupVaultMetricsMonitoring metricsMonitoring;
  @SerializedName("backup_vault_name")
  protected String backupVaultName;
  protected String region;
  @SerializedName("sse_kp_customer_root_key_crn")
  protected String sseKpCustomerRootKeyCrn;
  protected String crn;
  @SerializedName("service_instance_crn")
  protected String serviceInstanceCrn;
  @SerializedName("time_created")
  protected Date timeCreated;
  @SerializedName("time_updated")
  protected Date timeUpdated;
  @SerializedName("bytes_used")
  protected Long bytesUsed;

  protected BackupVault() { }

  /**
   * Gets the activityTracking.
   *
   * Activity Tracking configuration. An empty object (`{}`) indicates no configuration, and no events will be sent
   * (This is the same behavior as `{"management_events":false}`). Note that read/write events cannot be enabled, and
   * events cannot be routed to a non-default Activity Tracker instance.
   *
   * @return the activityTracking
   */
  public BackupVaultActivityTracking getActivityTracking() {
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
  public BackupVaultMetricsMonitoring getMetricsMonitoring() {
    return metricsMonitoring;
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
  public String getBackupVaultName() {
    return backupVaultName;
  }

  /**
   * Gets the region.
   *
   * the region in which this backup-vault should be created within.
   *
   * @return the region
   */
  public String getRegion() {
    return region;
  }

  /**
   * Gets the sseKpCustomerRootKeyCrn.
   *
   * The CRN for a KeyProtect root key.
   *
   * @return the sseKpCustomerRootKeyCrn
   */
  public String getSseKpCustomerRootKeyCrn() {
    return sseKpCustomerRootKeyCrn;
  }

  /**
   * Gets the crn.
   *
   * The CRN for a COS BackupVault.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the serviceInstanceCrn.
   *
   * A COS ServiceInstance CRN.
   *
   * @return the serviceInstanceCrn
   */
  public String getServiceInstanceCrn() {
    return serviceInstanceCrn;
  }

  /**
   * Gets the timeCreated.
   *
   * creation time of the backup-vault. Returns "YYYY-MM-DDTHH:mm:ss.sssZ" timestamp format.
   *
   * @return the timeCreated
   */
  public Date getTimeCreated() {
    return timeCreated;
  }

  /**
   * Gets the timeUpdated.
   *
   * time of last update to the backup-vault Returns "YYYY-MM-DDTHH:mm:ss.sssZ" timestamp format.
   *
   * @return the timeUpdated
   */
  public Date getTimeUpdated() {
    return timeUpdated;
  }

  /**
   * Gets the bytesUsed.
   *
   * byte useage of the backup-vault. This should include all usage, including non-current versions. A maximum value is
   * not defined.
   *
   * @return the bytesUsed
   */
  public Long getBytesUsed() {
    return bytesUsed;
  }
}

