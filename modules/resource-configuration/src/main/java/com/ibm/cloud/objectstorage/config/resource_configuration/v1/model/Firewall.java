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

import java.util.ArrayList;
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
    String X_PUBLIC = "public";
    /** private. */
    String X_PRIVATE = "private";
    /** direct. */
    String DIRECT = "direct";
  }

  @SerializedName("allowed_ip")
  protected List<String> allowedIp;
  @SerializedName("denied_ip")
  protected List<String> deniedIp;
  @SerializedName("allowed_network_type")
  protected List<String> allowedNetworkType;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> allowedIp;
    private List<String> deniedIp;
    private List<String> allowedNetworkType;

    /**
     * Instantiates a new Builder from an existing Firewall instance.
     *
     * @param firewall the instance to initialize the Builder with
     */
    private Builder(Firewall firewall) {
      this.allowedIp = firewall.allowedIp;
      this.deniedIp = firewall.deniedIp;
      this.allowedNetworkType = firewall.allowedNetworkType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Firewall.
     *
     * @return the new Firewall instance
     */
    public Firewall build() {
      return new Firewall(this);
    }

    /**
     * Adds a new element to allowedIp.
     *
     * @param allowedIp the new element to be added
     * @return the Firewall builder
     */
    public Builder addAllowedIp(String allowedIp) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(allowedIp,
        "allowedIp cannot be null");
      if (this.allowedIp == null) {
        this.allowedIp = new ArrayList<String>();
      }
      this.allowedIp.add(allowedIp);
      return this;
    }

    /**
     * Adds a new element to deniedIp.
     *
     * @param deniedIp the new element to be added
     * @return the Firewall builder
     */
    public Builder addDeniedIp(String deniedIp) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(deniedIp,
        "deniedIp cannot be null");
      if (this.deniedIp == null) {
        this.deniedIp = new ArrayList<String>();
      }
      this.deniedIp.add(deniedIp);
      return this;
    }

    /**
     * Adds a new element to allowedNetworkType.
     *
     * @param allowedNetworkType the new element to be added
     * @return the Firewall builder
     */
    public Builder addAllowedNetworkType(String allowedNetworkType) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(allowedNetworkType,
        "allowedNetworkType cannot be null");
      if (this.allowedNetworkType == null) {
        this.allowedNetworkType = new ArrayList<String>();
      }
      this.allowedNetworkType.add(allowedNetworkType);
      return this;
    }

    /**
     * Set the allowedIp.
     * Existing allowedIp will be replaced.
     *
     * @param allowedIp the allowedIp
     * @return the Firewall builder
     */
    public Builder allowedIp(List<String> allowedIp) {
      this.allowedIp = allowedIp;
      return this;
    }

    /**
     * Set the deniedIp.
     * Existing deniedIp will be replaced.
     *
     * @param deniedIp the deniedIp
     * @return the Firewall builder
     */
    public Builder deniedIp(List<String> deniedIp) {
      this.deniedIp = deniedIp;
      return this;
    }

    /**
     * Set the allowedNetworkType.
     * Existing allowedNetworkType will be replaced.
     *
     * @param allowedNetworkType the allowedNetworkType
     * @return the Firewall builder
     */
    public Builder allowedNetworkType(List<String> allowedNetworkType) {
      this.allowedNetworkType = allowedNetworkType;
      return this;
    }
  }

  protected Firewall() { }

  protected Firewall(Builder builder) {
    allowedIp = builder.allowedIp;
    deniedIp = builder.deniedIp;
    allowedNetworkType = builder.allowedNetworkType;
  }

  /**
   * New builder.
   *
   * @return a Firewall builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the allowedIp.
   *
   * List of IPv4 or IPv6 addresses in CIDR notation to be affected by firewall in CIDR notation is supported. Passing
   * an empty array will lift the IP address filter.  The `allowed_ip` array can contain a maximum of 1000 items.
   *
   * @return the allowedIp
   */
  public List<String> allowedIp() {
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
  public List<String> deniedIp() {
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
  public List<String> allowedNetworkType() {
    return allowedNetworkType;
  }
}

