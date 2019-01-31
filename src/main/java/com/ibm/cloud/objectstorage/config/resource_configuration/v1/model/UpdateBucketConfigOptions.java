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

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import com.ibm.cloud.sdk.core.util.Validator;

/**
 * The updateBucketConfig options.
 */
public class UpdateBucketConfigOptions extends GenericModel {

  private String bucket;
  private Firewall firewall;
  private String ifMatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String bucket;
    private Firewall firewall;
    private String ifMatch;

    private Builder(UpdateBucketConfigOptions updateBucketConfigOptions) {
      bucket = updateBucketConfigOptions.bucket;
      firewall = updateBucketConfigOptions.firewall;
      ifMatch = updateBucketConfigOptions.ifMatch;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param bucket the bucket
     */
    public Builder(String bucket) {
      this.bucket = bucket;
    }

    /**
     * Builds a UpdateBucketConfigOptions.
     *
     * @return the updateBucketConfigOptions
     */
    public UpdateBucketConfigOptions build() {
      return new UpdateBucketConfigOptions(this);
    }

    /**
     * Set the bucket.
     *
     * @param bucket the bucket
     * @return the UpdateBucketConfigOptions builder
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Set the firewall.
     *
     * @param firewall the firewall
     * @return the UpdateBucketConfigOptions builder
     */
    public Builder firewall(Firewall firewall) {
      this.firewall = firewall;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateBucketConfigOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }
  }

  private UpdateBucketConfigOptions(Builder builder) {
    Validator.notEmpty(builder.bucket, "bucket cannot be empty");
    bucket = builder.bucket;
    firewall = builder.firewall;
    ifMatch = builder.ifMatch;
  }

  /**
   * New builder.
   *
   * @return a UpdateBucketConfigOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the bucket.
   *
   * Name of a bucket.
   *
   * @return the bucket
   */
  public String bucket() {
    return bucket;
  }

  /**
   * Gets the firewall.
   *
   * An access control mechanism based on the network (IP address) where request originated. Requests not originating
   * from IP addresses listed in the `allowed_ip` field will be denied regardless of any access policies (including
   * public access) that might otherwise permit the request.  Viewing or updating the `Firewall` element requires the
   * requester to have the `manager` role.
   *
   * @return the firewall
   */
  public Firewall firewall() {
    return firewall;
  }

  /**
   * Gets the ifMatch.
   *
   * An Etag previously returned in a header when fetching or updating a bucket's metadata. If this value does not match
   * the active Etag, the request will fail.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }
}

