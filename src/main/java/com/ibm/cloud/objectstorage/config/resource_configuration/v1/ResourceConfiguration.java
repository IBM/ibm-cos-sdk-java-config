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
package com.ibm.cloud.objectstorage.config.resource_configuration.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.objectstorage.config.common.SdkCommon;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.Bucket;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.GetBucketConfigOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.UpdateBucketConfigOptions;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.cloud.sdk.core.util.GsonSingleton;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.cloud.sdk.core.util.Validator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * REST API used to configure Cloud Object Storage buckets.  This version of the API only supports reading bucket
 * metadata and setting IP access controls.
 *
 * @version v1
 * @see <a href="http://www.ibm.com/watson/developercloud/resource-configuration.html">ResourceConfiguration</a>
 */
public class ResourceConfiguration extends BaseService {

  private static final String SERVICE_NAME = "resource_configuration";
  private static final String URL = "https://config.cloud-object-storage.cloud.ibm.com/v1";

  /**
   * Instantiates a new `ResourceConfiguration`.
   *
   */
  public ResourceConfiguration() {
    super(SERVICE_NAME);
    if ((getEndPoint() == null) || getEndPoint().isEmpty()) {
      setEndPoint(URL);
    }
  }

  /**
   * Instantiates a new `ResourceConfiguration` with IAM. Note that if the access token is specified in the
   * iamOptions, you accept responsibility for managing the access token yourself. You must set a new access token before this
   * one expires or after receiving a 401 error from the service. Failing to do so will result in authentication errors
   * after this token expires.
   *
   * @param iamOptions the options for authenticating through IAM
   */
  public ResourceConfiguration(IamOptions iamOptions) {
    this();
    setIamCredentials(iamOptions);
  }

  /**
   * Returns metadata for the specified bucket.
   *
   * Returns metadata for the specified bucket.
   *
   * @param getBucketConfigOptions the {@link GetBucketConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of {@link Bucket}
   */
  public ServiceCall<Bucket> getBucketConfig(GetBucketConfigOptions getBucketConfigOptions) {
    Validator.notNull(getBucketConfigOptions, "getBucketConfigOptions cannot be null");
    String[] pathSegments = { "b" };
    String[] pathParameters = { getBucketConfigOptions.bucket() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "getBucketConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    return createServiceCall(builder.build(), ResponseConverterUtils.getObject(Bucket.class));
  }

  /**
   * Make changes to a bucket's configuration.
   *
   * Updates a bucket using [JSON Merge Patch](https://tools.ietf.org/html/rfc7396). This request is used to add
   * functionality (like an IP access filter) or to update existing parameters.  **Primitives are overwritten and
   * replaced in their entirety. It is not possible to append a new (or to delete a specific) value to an array.**
   * Arrays can be cleared by updating the parameter with an empty array `[]`. Only updates specified mutable fields.
   * Please don't use `PATCH` trying to update the number of objects in a bucket, any timestamps, or other non-mutable
   * fields.
   *
   * @param updateBucketConfigOptions the {@link UpdateBucketConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a response type of Void
   */
  public ServiceCall<Void> updateBucketConfig(UpdateBucketConfigOptions updateBucketConfigOptions) {
    Validator.notNull(updateBucketConfigOptions, "updateBucketConfigOptions cannot be null");
    String[] pathSegments = { "b" };
    String[] pathParameters = { updateBucketConfigOptions.bucket() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "updateBucketConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (updateBucketConfigOptions.ifMatch() != null) {
      builder.header("if-match", updateBucketConfigOptions.ifMatch());
    }
    final JsonObject contentJson = new JsonObject();
    if (updateBucketConfigOptions.firewall() != null) {
      contentJson.add("firewall", GsonSingleton.getGson().toJsonTree(updateBucketConfigOptions.firewall()));
    }
    if (updateBucketConfigOptions.activityTracking() != null) {
      contentJson.add("activity_tracking", GsonSingleton.getGson().toJsonTree(updateBucketConfigOptions.activityTracking()));
    }
    builder.bodyJson(contentJson);
    return createServiceCall(builder.build(), ResponseConverterUtils.getVoid());
  }

}
