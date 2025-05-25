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
 * Metadata associated with a recovery range.
 */
public class RecoveryRange extends GenericModel {

  @SerializedName("source_resource_crn")
  protected String sourceResourceCrn;
  @SerializedName("backup_policy_name")
  protected String backupPolicyName;
  @SerializedName("range_start_time")
  protected Date rangeStartTime;
  @SerializedName("range_end_time")
  protected Date rangeEndTime;
  @SerializedName("range_create_time")
  protected Date rangeCreateTime;
  protected DeleteAfterDaysWithIndefinite retention;
  @SerializedName("recovery_range_id")
  protected String recoveryRangeId;

  protected RecoveryRange() { }

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
   * Gets the backupPolicyName.
   *
   * The name granted to the policy. Validation :
   *   * chars limited to alphanumeric, underscore, hyphen and period.
   *
   * @return the backupPolicyName
   */
  public String getBackupPolicyName() {
    return backupPolicyName;
  }

  /**
   * Gets the rangeStartTime.
   *
   * The point in time at which backup coverage of the sourceResource begins.
   *
   * Returns "YYYY-MM-DDTHH:mm:ss.sssZ" timestamp format.
   *
   * @return the rangeStartTime
   */
  public Date getRangeStartTime() {
    return rangeStartTime;
  }

  /**
   * Gets the rangeEndTime.
   *
   * the point in time at which backup coverage of the sourceResource ends. Returns "YYYY-MM-DDTHH:mm:ss.sssZ" timestamp
   * format.
   *
   * @return the rangeEndTime
   */
  public Date getRangeEndTime() {
    return rangeEndTime;
  }

  /**
   * Gets the rangeCreateTime.
   *
   * The time at which this recoveryRange was initially created.
   *
   * Returns "YYYY-MM-DDTHH:mm:ss.sssZ" timestamp format
   *
   * NOTE : this can be before the start-time.
   *
   * @return the rangeCreateTime
   */
  public Date getRangeCreateTime() {
    return rangeCreateTime;
  }

  /**
   * Gets the retention.
   *
   * The retention configuration for a RecoveryRange.
   *
   * @return the retention
   */
  public DeleteAfterDaysWithIndefinite getRetention() {
    return retention;
  }

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
}

