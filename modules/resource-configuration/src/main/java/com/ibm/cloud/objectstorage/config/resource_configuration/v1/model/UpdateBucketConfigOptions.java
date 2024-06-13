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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateBucketConfig options.
 */
public class UpdateBucketConfigOptions extends GenericModel {

  protected String bucket;
  protected Map<String, Object> bucketPatch;
  protected String ifMatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String bucket;
    private Map<String, Object> bucketPatch;
    private String ifMatch;

    /**
     * Instantiates a new Builder from an existing UpdateBucketConfigOptions instance.
     *
     * @param updateBucketConfigOptions the instance to initialize the Builder with
     */
    private Builder(UpdateBucketConfigOptions updateBucketConfigOptions) {
      this.bucket = updateBucketConfigOptions.bucket;
      this.bucketPatch = updateBucketConfigOptions.bucketPatch;
      this.ifMatch = updateBucketConfigOptions.ifMatch;
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
     * @return the new UpdateBucketConfigOptions instance
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
     * Set the bucketPatch.
     *
     * @param bucketPatch the bucketPatch
     * @return the UpdateBucketConfigOptions builder
     */
    public Builder bucketPatch(Map<String, Object> bucketPatch) {
      this.bucketPatch = bucketPatch;
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

  protected UpdateBucketConfigOptions() { }

  protected UpdateBucketConfigOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.bucket,
      "bucket cannot be empty");
    bucket = builder.bucket;
    bucketPatch = builder.bucketPatch;
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
   * Gets the bucketPatch.
   *
   * An object containing new configuration metadata.
   *
   * @return the bucketPatch
   */
  public Map<String, Object> bucketPatch() {
    return bucketPatch;
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

