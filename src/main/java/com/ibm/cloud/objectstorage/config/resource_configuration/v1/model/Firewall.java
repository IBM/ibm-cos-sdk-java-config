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

  @SerializedName("allowed_ip")
  private List<String> allowedIp;

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
   * Sets the allowedIp.
   *
   * @param allowedIp the new allowedIp
   */
  public void setAllowedIp(final List<String> allowedIp) {
    this.allowedIp = allowedIp;
  }
}

