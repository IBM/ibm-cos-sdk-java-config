/*
 * Copyright 2018 IBM Corp. All Rights Reserved.
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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An access control mechanism based on the network (IP address) where request originated. Requests not originating from
 * IP addresses listed in the `allowed_ip` field will be denied regardless of any access policies (including public
 * access) that might otherwise permit the request.  Viewing or updating the `Firewall` element requires the requester
 * to have the `manager` role.
 */
public class Firewall extends GenericModel {

  /**
   * May contain `public`, `private`, and/or `direct` elements. Setting `allowed_network_type` to only `private` will
   * prevent access to object storage from outside of the IBM Cloud.  The entire array will be overwritten in a `PATCH`
   * operation. For more information on network types, [see the
   * documentation](https://cloud.ibm.com/docs/cloud-object-storage?topic=cloud-object-storage-endpoints#advanced-endpoint-types).
   */
  public interface AllowedNetworkType {
    /** public. */
    String XPUBLIC = "public";
    /** private. */
    String XPRIVATE = "private";
    /** direct. */
    String DIRECT = "direct";
  }

  @SerializedName("allowed_ip")
  private List<String> allowedIp;
  @SerializedName("denied_ip")
  private List<String> deniedIp;
  @SerializedName("allowed_network_type")
  private List<String> allowedNetworkType;

  /**
   * Gets the allowedIp.
   *
   * List of IPv4 or IPv6 addresses in CIDR notation to be affected by firewall in CIDR notation is supported. Passing
   * an empty array will lift the IP address filter.  The `allowed_ip` array can contain a maximum of 1000 items.
   *
   * @return the allowedIp
   */
  public List<String> getAllowedIp() {
    return allowedIp;
  }

  /**
   * Gets the deniedIp.
   *
   * List of IPv4 or IPv6 addresses in CIDR notation to be affected by firewall in CIDR notation is supported. Passing
   * an empty array will lift the IP address filter.  The `denied_ip` array can contain a maximum of 1000 items.
   *
   * @return the deniedIp
   */
  public List<String> getDeniedIp() {
    return deniedIp;
  }

  /**
   * Gets the allowedNetworkType.
   *
   * Indicates which network types are allowed for bucket access. May contain `public`, `private`, and/or `direct`
   * elements. Setting `allowed_network_type` to only `private` will prevent access to object storage from outside of
   * the IBM Cloud.  The entire array will be overwritten in a `PATCH` operation. For more information on network types,
   * [see the
   * documentation](https://cloud.ibm.com/docs/cloud-object-storage?topic=cloud-object-storage-endpoints#advanced-endpoint-types).
   *
   * @return the allowedNetworkType
   */
  public List<String> getAllowedNetworkType() {
    return allowedNetworkType;
  }

  /**
   * Sets the allowedIp.
   *
   * @param allowedIp the new allowedIp
   */
  public void setAllowedIp(final List<String> allowedIp) {
    this.allowedIp = allowedIp;
  }

  /**
   * Sets the deniedIp.
   *
   * @param deniedIp the new deniedIp
   */
  public void setDeniedIp(final List<String> deniedIp) {
    this.deniedIp = deniedIp;
  }

  /**
   * Sets the allowedNetworkType.
   *
   * @param allowedNetworkType the new allowedNetworkType
   */
  public void setAllowedNetworkType(final List<String> allowedNetworkType) {
    this.allowedNetworkType = allowedNetworkType;
  }
}

