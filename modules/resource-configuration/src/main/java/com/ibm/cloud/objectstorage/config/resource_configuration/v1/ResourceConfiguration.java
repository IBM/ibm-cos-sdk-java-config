/*
 * (C) Copyright IBM Corp. 2022.
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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.61.0-1667892a-20221109-194550
 */

package com.ibm.cloud.objectstorage.config.resource_configuration.v1;

import com.ibm.cloud.objectstorage.common.SdkCommon;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.Bucket;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.GetBucketConfigOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.UpdateBucketConfigOptions;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * REST API used to configure Cloud Object Storage buckets.
 *
 * API Version: 2.0.0
 */
public class ResourceConfiguration extends BaseService {

  /**
   * Default service name used when configuring the `ResourceConfiguration` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "resource_configuration";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://config.cloud-object-storage.cloud.ibm.com/v1";

 /**
   * Class method which constructs an instance of the `ResourceConfiguration` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `ResourceConfiguration` client using external configuration
   */
  public static ResourceConfiguration newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `ResourceConfiguration` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `ResourceConfiguration` client using external configuration
   */
  public static ResourceConfiguration newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    ResourceConfiguration service = new ResourceConfiguration(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `ResourceConfiguration` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public ResourceConfiguration(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Returns metadata for the specified bucket.
   *
   * Returns metadata for the specified bucket.
   *
   * @param getBucketConfigOptions the {@link GetBucketConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Bucket}
   */
  public ServiceCall<Bucket> getBucketConfig(GetBucketConfigOptions getBucketConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getBucketConfigOptions,
      "getBucketConfigOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("bucket", getBucketConfigOptions.bucket());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/b/{bucket}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "getBucketConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Bucket> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Bucket>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Make changes to a bucket's configuration.
   *
   * Updates a bucket using [JSON Merge Patch](https://tools.ietf.org/html/rfc7396). This request is used to add
   * functionality (like an IP access filter) or to update existing parameters.  **Primitives are overwritten and
   * replaced in their entirety. It is not possible to append a new (or to delete a specific) value to an array.**
   * Arrays can be cleared by updating the parameter with an empty array `[]`. A `PATCH` operation only updates
   * specified mutable fields. Please don't use `PATCH` trying to update the number of objects in a bucket, any
   * timestamps, or other non-mutable fields.
   *
   * @param updateBucketConfigOptions the {@link UpdateBucketConfigOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateBucketConfig(UpdateBucketConfigOptions updateBucketConfigOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateBucketConfigOptions,
      "updateBucketConfigOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("bucket", updateBucketConfigOptions.bucket());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/b/{bucket}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "updateBucketConfig");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (updateBucketConfigOptions.ifMatch() != null) {
      builder.header("if-match", updateBucketConfigOptions.ifMatch());
    }
    if (updateBucketConfigOptions.bucketPatch() != null) {
      builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(updateBucketConfigOptions.bucketPatch()), "application/merge-patch+json");
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
