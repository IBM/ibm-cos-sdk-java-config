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
 * Metadata associated with a requested restore operation.
 */
public class Restore extends GenericModel {

  /**
   * The type of restore to support. More options will be available in the future.
   */
  public interface RestoreType {
    /** in_place. */
    String IN_PLACE = "in_place";
  }

  /**
   * The current status for this restore operation.
   *
   * initializing: The operation is initializing. Do not expect to see restored objects on the target bucket.  running :
   * The operation is ongoing. Expect to see some restored objects on the target bucket.  complete: The operation has
   * completed successfully.  failed: The operation has completed unsuccessfully.
   */
  public interface RestoreStatus {
    /** initializing. */
    String INITIALIZING = "initializing";
    /** running. */
    String RUNNING = "running";
    /** complete. */
    String COMPLETE = "complete";
    /** failed. */
    String FAILED = "failed";
  }

  @SerializedName("recovery_range_id")
  protected String recoveryRangeId;
  @SerializedName("restore_type")
  protected String restoreType;
  @SerializedName("restore_point_in_time")
  protected Date restorePointInTime;
  @SerializedName("target_resource_crn")
  protected String targetResourceCrn;
  @SerializedName("source_resource_crn")
  protected String sourceResourceCrn;
  @SerializedName("restore_id")
  protected String restoreId;
  @SerializedName("restore_status")
  protected String restoreStatus;
  @SerializedName("init_time")
  protected Date initTime;
  @SerializedName("complete_time")
  protected Date completeTime;
  @SerializedName("restore_percent_progress")
  protected Long restorePercentProgress;
  @SerializedName("error_cause")
  protected String errorCause;

  protected Restore() { }

  /**
   * Gets the recoveryRangeId.
   *
   * A UUID that uniquely identifies a resource.
   *
   * @return the recoveryRangeId
   */
  public String getRecoveryRangeId() {
    return recoveryRangeId;
  }

  /**
   * Gets the restoreType.
   *
   * The type of restore to support. More options will be available in the future.
   *
   * @return the restoreType
   */
  public String getRestoreType() {
    return restoreType;
  }

  /**
   * Gets the restorePointInTime.
   *
   * Timestamp format used throughout the API.
   *
   * Accepts the following formats:
   *
   * YYYY-MM-DDTHH:mm:ssZ YYYY-MM-DDTHH:mm:ss YYYY-MM-DDTHH:mm:ss-hh:mm YYYY-MM-DDTHH:mm:ss+hh:mm
   * YYYY-MM-DDTHH:mm:ss.sssZ YYYY-MM-DDTHH:mm:ss.sss YYYY-MM-DDTHH:mm:ss.sss-hh:mm YYYY-MM-DDTHH:mm:ss.sss+hh:mm.
   *
   * @return the restorePointInTime
   */
  public Date getRestorePointInTime() {
    return restorePointInTime;
  }

  /**
   * Gets the targetResourceCrn.
   *
   * The CRN for a COS Bucket.
   *
   * Note that Softlayer CRNs do not contain dashes within the service_instance_id, whereas regular CRNs do. Although
   * bucket backup is not supported for softlayer accounts, this need not be enforced at the CRN parsing level.
   *
   * @return the targetResourceCrn
   */
  public String getTargetResourceCrn() {
    return targetResourceCrn;
  }

  /**
   * Gets the sourceResourceCrn.
   *
   * The CRN for a COS Bucket.
   *
   * Note that Softlayer CRNs do not contain dashes within the service_instance_id, whereas regular CRNs do. Although
   * bucket backup is not supported for softlayer accounts, this need not be enforced at the CRN parsing level.
   *
   * @return the sourceResourceCrn
   */
  public String getSourceResourceCrn() {
    return sourceResourceCrn;
  }

  /**
   * Gets the restoreId.
   *
   * A UUID that uniquely identifies a resource.
   *
   * @return the restoreId
   */
  public String getRestoreId() {
    return restoreId;
  }

  /**
   * Gets the restoreStatus.
   *
   * The current status for this restore operation.
   *
   * initializing: The operation is initializing. Do not expect to see restored objects on the target bucket.  running :
   * The operation is ongoing. Expect to see some restored objects on the target bucket.  complete: The operation has
   * completed successfully.  failed: The operation has completed unsuccessfully.
   *
   * @return the restoreStatus
   */
  public String getRestoreStatus() {
    return restoreStatus;
  }

  /**
   * Gets the initTime.
   *
   * The time at which this restore was initiated Returns "YYYY-MM-DDTHH:mm:ss.sssZ" timestamp format.
   *
   * @return the initTime
   */
  public Date getInitTime() {
    return initTime;
  }

  /**
   * Gets the completeTime.
   *
   * The time at which this restore ended (in both success and error cases) Returns "YYYY-MM-DDTHH:mm:ss.sssZ" timestamp
   * format.
   *
   * @return the completeTime
   */
  public Date getCompleteTime() {
    return completeTime;
  }

  /**
   * Gets the restorePercentProgress.
   *
   * reports percent-doneness of init. Only present when restore_status=running.
   *
   * @return the restorePercentProgress
   */
  public Long getRestorePercentProgress() {
    return restorePercentProgress;
  }

  /**
   * Gets the errorCause.
   *
   * Only present when restore_status=running.
   *
   * @return the errorCause
   */
  public String getErrorCause() {
    return errorCause;
  }
}

