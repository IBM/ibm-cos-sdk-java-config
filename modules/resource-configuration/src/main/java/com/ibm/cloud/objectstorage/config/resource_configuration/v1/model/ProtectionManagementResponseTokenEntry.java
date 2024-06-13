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
 * Data structure holding protection management token.
 */
public class ProtectionManagementResponseTokenEntry extends GenericModel {

  @SerializedName("token_id")
  protected String tokenId;
  @SerializedName("token_expiration_time")
  protected String tokenExpirationTime;
  @SerializedName("token_reference_id")
  protected String tokenReferenceId;
  @SerializedName("applied_time")
  protected String appliedTime;
  @SerializedName("invalidated_time")
  protected String invalidatedTime;
  @SerializedName("expiration_time")
  protected String expirationTime;
  @SerializedName("shorten_retention_flag")
  protected Boolean shortenRetentionFlag;

  protected ProtectionManagementResponseTokenEntry() { }

  /**
   * Gets the tokenId.
   *
   * @return the tokenId
   */
  public String getTokenId() {
    return tokenId;
  }

  /**
   * Gets the tokenExpirationTime.
   *
   * @return the tokenExpirationTime
   */
  public String getTokenExpirationTime() {
    return tokenExpirationTime;
  }

  /**
   * Gets the tokenReferenceId.
   *
   * @return the tokenReferenceId
   */
  public String getTokenReferenceId() {
    return tokenReferenceId;
  }

  /**
   * Gets the appliedTime.
   *
   * @return the appliedTime
   */
  public String getAppliedTime() {
    return appliedTime;
  }

  /**
   * Gets the invalidatedTime.
   *
   * @return the invalidatedTime
   */
  public String getInvalidatedTime() {
    return invalidatedTime;
  }

  /**
   * Gets the expirationTime.
   *
   * @return the expirationTime
   */
  public String getExpirationTime() {
    return expirationTime;
  }

  /**
   * Gets the shortenRetentionFlag.
   *
   * @return the shortenRetentionFlag
   */
  public Boolean isShortenRetentionFlag() {
    return shortenRetentionFlag;
  }
}

