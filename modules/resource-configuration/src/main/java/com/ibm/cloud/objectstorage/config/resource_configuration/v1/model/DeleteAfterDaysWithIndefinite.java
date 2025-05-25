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
 * The retention configuration for a RecoveryRange.
 */
public class DeleteAfterDaysWithIndefinite extends GenericModel {

  @SerializedName("delete_after_days")
  protected Long deleteAfterDays;

  protected DeleteAfterDaysWithIndefinite() { }

  /**
   * Gets the deleteAfterDays.
   *
   * The number of days to retain data within a RecoveryRange. -1 is a special value that denotes "indefinite"
   * retention. This value can only be set implicitly via a policy created during the LA release being upgraded to the
   * GA release.
   *
   * @return the deleteAfterDays
   */
  public Long getDeleteAfterDays() {
    return deleteAfterDays;
  }
}

