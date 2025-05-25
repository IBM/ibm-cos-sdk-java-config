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
 * The current backup coverage for a COS Bucket.
 */
public class BackupPolicy extends GenericModel {

  /**
   * The type of backup to support. For LA+GA this is limited to "continuous".
   */
  public interface BackupType {
    /** continuous. */
    String CONTINUOUS = "continuous";
  }

  /**
   * The current status of the backup policy.
   *
   * pending : the policy has been received and has begun processing. initializing : pre-existing objects are being sync
   * to the backup vault. active : the policy is active and healthy. action_needed : the policy is unhealthy and
   * requires some intervention to recover degraded : the policy is unhealthy failed : the policy has failed
   * unrecoverably.
   */
  public interface PolicyStatus {
    /** pending. */
    String PENDING = "pending";
    /** initializing. */
    String INITIALIZING = "initializing";
    /** active. */
    String ACTIVE = "active";
    /** action_needed. */
    String ACTION_NEEDED = "action_needed";
    /** degraded. */
    String DEGRADED = "degraded";
    /** failed. */
    String FAILED = "failed";
  }

  @SerializedName("initial_retention")
  protected DeleteAfterDays initialRetention;
  @SerializedName("policy_name")
  protected String policyName;
  @SerializedName("target_backup_vault_crn")
  protected String targetBackupVaultCrn;
  @SerializedName("backup_type")
  protected String backupType;
  @SerializedName("policy_id")
  protected String policyId;
  @SerializedName("policy_status")
  protected String policyStatus;
  @SerializedName("initial_sync_progress")
  protected Double initialSyncProgress;
  @SerializedName("error_cause")
  protected String errorCause;

  protected BackupPolicy() { }

  /**
   * Gets the initialRetention.
   *
   * The number of days to retain data within a RecoveryRange.
   *
   * @return the initialRetention
   */
  public DeleteAfterDays getInitialRetention() {
    return initialRetention;
  }

  /**
   * Gets the policyName.
   *
   * The name granted to the policy. Validation :
   *   * chars limited to alphanumeric, underscore, hyphen and period.
   *
   * @return the policyName
   */
  public String getPolicyName() {
    return policyName;
  }

  /**
   * Gets the targetBackupVaultCrn.
   *
   * The CRN for a COS BackupVault.
   *
   * @return the targetBackupVaultCrn
   */
  public String getTargetBackupVaultCrn() {
    return targetBackupVaultCrn;
  }

  /**
   * Gets the backupType.
   *
   * The type of backup to support. For LA+GA this is limited to "continuous".
   *
   * @return the backupType
   */
  public String getBackupType() {
    return backupType;
  }

  /**
   * Gets the policyId.
   *
   * A UUID that uniquely identifies a resource.
   *
   * @return the policyId
   */
  public String getPolicyId() {
    return policyId;
  }

  /**
   * Gets the policyStatus.
   *
   * The current status of the backup policy.
   *
   * pending : the policy has been received and has begun processing. initializing : pre-existing objects are being sync
   * to the backup vault. active : the policy is active and healthy. action_needed : the policy is unhealthy and
   * requires some intervention to recover degraded : the policy is unhealthy failed : the policy has failed
   * unrecoverably.
   *
   * @return the policyStatus
   */
  public String getPolicyStatus() {
    return policyStatus;
  }

  /**
   * Gets the initialSyncProgress.
   *
   * Reports percent-doneness of init. Only present when policy_status=INITIALIZING/PENDING.
   *
   * @return the initialSyncProgress
   */
  public Double getInitialSyncProgress() {
    return initialSyncProgress;
  }

  /**
   * Gets the errorCause.
   *
   * reports error cause. Only present when policy_status=ERROR/FAILED.
   *
   * @return the errorCause
   */
  public String getErrorCause() {
    return errorCause;
  }
}

