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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.98.0-8be2046a-20241205-162752
 */

package com.ibm.cloud.objectstorage.config.resource_configuration.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.objectstorage.common.SdkCommon;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.BackupPolicy;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.BackupPolicyCollection;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.BackupVault;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.BackupVaultCollection;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.Bucket;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.CreateBackupPolicyOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.CreateBackupVaultOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.CreateRestoreOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.DeleteBackupPolicyOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.DeleteBackupVaultOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.GetBackupPolicyOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.GetBackupVaultOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.GetBucketConfigOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.GetRestoreOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.GetSourceResourceRecoveryRangeOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.ListBackupPoliciesOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.ListBackupVaultsOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.ListRecoveryRangesOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.ListRestoresOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.PatchSourceResourceRecoveryRangeOptions;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.RecoveryRange;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.RecoveryRangeCollection;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.Restore;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.RestoreCollection;
import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.UpdateBackupVaultOptions;
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
 * API Version: 1.0.0
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
   * Add a new backup policy to the COS Bucket.
   *
   * Attach a new Backup Policy on a bucket.
   *
   * This request results in the creation of a single, new RecoveryRange on the destination BackupVault.
   *
   * Deletion and re-creation of a BackupPolicy to the same BackupVault destination will generate a new RecoveryRange.
   *
   * The following shall be validated. Any failure to validate shall cause a HTTP 400 to be returned.
   *
   *   * the user has `cloud-object-storage.bucket.post_backup_policy` permissions on the source-bucket
   *   * the source-bucket must have `cloud-object-storage.backup_vault.sync` permissions on the Backup Vault
   *   * the source-bucket must have versioning-on
   *   * the Backup Vault must exist and be able to be contacted by the source-bucket
   *   * the source-bucket must not have an existing BackupPolicy targeting the Backup Vault
   *   * the source-bucket must not have a BackupPolicy with the same policy_name
   *   * the source-bucket must have fewer than 3 total BackupPolicies.
   *
   * @param createBackupPolicyOptions the {@link CreateBackupPolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BackupPolicy}
   */
  public ServiceCall<BackupPolicy> createBackupPolicy(CreateBackupPolicyOptions createBackupPolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createBackupPolicyOptions,
      "createBackupPolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("bucket", createBackupPolicyOptions.bucket());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/buckets/{bucket}/backup_policies", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "createBackupPolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createBackupPolicyOptions.mD5() != null) {
      builder.header("MD5", createBackupPolicyOptions.mD5());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("initial_retention", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createBackupPolicyOptions.initialRetention()));
    contentJson.addProperty("policy_name", createBackupPolicyOptions.policyName());
    contentJson.addProperty("target_backup_vault_crn", createBackupPolicyOptions.targetBackupVaultCrn());
    contentJson.addProperty("backup_type", createBackupPolicyOptions.backupType());
    builder.bodyJson(contentJson);
    ResponseConverter<BackupPolicy> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BackupPolicy>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List BackupPolicies.
   *
   * Get all backup policies on a bucket.
   *
   * Requires that the user has `cloud-object-storage.bucket.list_backup_policies` permissions on the source bucket.
   *
   * This request generates the "cloud-object-storage.bucket-backup-policy.list" ActivityTracking event.
   *
   * @param listBackupPoliciesOptions the {@link ListBackupPoliciesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BackupPolicyCollection}
   */
  public ServiceCall<BackupPolicyCollection> listBackupPolicies(ListBackupPoliciesOptions listBackupPoliciesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listBackupPoliciesOptions,
      "listBackupPoliciesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("bucket", listBackupPoliciesOptions.bucket());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/buckets/{bucket}/backup_policies", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "listBackupPolicies");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<BackupPolicyCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BackupPolicyCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get BackupPolicy.
   *
   * Read a specific backup policy on a bucket.
   *
   * Requires that the user has `cloud-object-storage.bucket.get_backup_policy` permissions on the bucket.
   *
   * @param getBackupPolicyOptions the {@link GetBackupPolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BackupPolicy}
   */
  public ServiceCall<BackupPolicy> getBackupPolicy(GetBackupPolicyOptions getBackupPolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getBackupPolicyOptions,
      "getBackupPolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("bucket", getBackupPolicyOptions.bucket());
    pathParamsMap.put("policy_id", getBackupPolicyOptions.policyId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/buckets/{bucket}/backup_policies/{policy_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "getBackupPolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<BackupPolicy> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BackupPolicy>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a BackupPolicy.
   *
   * Delete a specific BackupPolicy.
   *
   * Requires that the user has `cloud-object-storage.bucket.delete_backup_policy` permissions on the bucket.
   *
   * @param deleteBackupPolicyOptions the {@link DeleteBackupPolicyOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteBackupPolicy(DeleteBackupPolicyOptions deleteBackupPolicyOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteBackupPolicyOptions,
      "deleteBackupPolicyOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("bucket", deleteBackupPolicyOptions.bucket());
    pathParamsMap.put("policy_id", deleteBackupPolicyOptions.policyId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/buckets/{bucket}/backup_policies/{policy_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "deleteBackupPolicy");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * list BackupVaults.
   *
   * Returns a list of BackupVault CRNs owned by the account.
   *
   * Requires that the user has `cloud-object-storage.backup_vault.list_account_backup_vaults` permissions for the
   * account.
   *
   * @param listBackupVaultsOptions the {@link ListBackupVaultsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BackupVaultCollection}
   */
  public ServiceCall<BackupVaultCollection> listBackupVaults(ListBackupVaultsOptions listBackupVaultsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listBackupVaultsOptions,
      "listBackupVaultsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "listBackupVaults");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("service_instance_id", String.valueOf(listBackupVaultsOptions.serviceInstanceId()));
    if (listBackupVaultsOptions.token() != null) {
      builder.query("token", String.valueOf(listBackupVaultsOptions.token()));
    }
    ResponseConverter<BackupVaultCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BackupVaultCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * create a BackupVault.
   *
   * Creates a BackupVault.
   *
   * Requires that the user has `cloud-object-storage.backup_vault.post_backup_vault` permissions for the account.
   *
   * Certain fields will be returned only if the user has specific permissions:
   *   - `activity_tracking` requires `cloud-object-storage.backup_vault.put_activity_tracking`
   *   - `metrics_monitoring` requires `cloud-object-storage.backup_vault.put_metrics_monitoring`.
   *
   * @param createBackupVaultOptions the {@link CreateBackupVaultOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BackupVault}
   */
  public ServiceCall<BackupVault> createBackupVault(CreateBackupVaultOptions createBackupVaultOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createBackupVaultOptions,
      "createBackupVaultOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "createBackupVault");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("service_instance_id", String.valueOf(createBackupVaultOptions.serviceInstanceId()));
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("backup_vault_name", createBackupVaultOptions.backupVaultName());
    contentJson.addProperty("region", createBackupVaultOptions.region());
    if (createBackupVaultOptions.activityTracking() != null) {
      contentJson.add("activity_tracking", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createBackupVaultOptions.activityTracking()));
    }
    if (createBackupVaultOptions.metricsMonitoring() != null) {
      contentJson.add("metrics_monitoring", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createBackupVaultOptions.metricsMonitoring()));
    }
    if (createBackupVaultOptions.sseKpCustomerRootKeyCrn() != null) {
      contentJson.addProperty("sse_kp_customer_root_key_crn", createBackupVaultOptions.sseKpCustomerRootKeyCrn());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<BackupVault> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BackupVault>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * get the config for a Backup Vault.
   *
   * Gets configuration information for a Backup Vault.
   *
   * Requires that the user has `cloud-object-storage.backup_vault.get_basic` permissions on the backup vault.
   *
   * Certain fields will be returned only if the user has specific permissions:
   *   - `activity_tracking` requires `cloud-object-storage.backup_vault.get_activity_tracking`
   *   - `metrics_monitoring` requires `cloud-object-storage.backup_vault.get_metrics_monitoring`
   *   - `sse_kp_customer_root_key_crn` requires `cloud-object-storage.backup_vault.get_crk_id`.
   *
   * @param getBackupVaultOptions the {@link GetBackupVaultOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BackupVault}
   */
  public ServiceCall<BackupVault> getBackupVault(GetBackupVaultOptions getBackupVaultOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getBackupVaultOptions,
      "getBackupVaultOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("backup_vault_name", getBackupVaultOptions.backupVaultName());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults/{backup_vault_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "getBackupVault");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<BackupVault> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BackupVault>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update the config on a Backup Vault.
   *
   * Update the Backup Vault config via JSON Merge Patch update semantics.
   *
   * In particular, note that providing an empty object (`{}`) to either field in the request body will remove any
   * existing configuration.
   *
   * Requires that the user have specific permissions depending on what is being changed:
   *   - `activity_tracking` requires `cloud-object-storage.backup_vault.put_activity_tracking`
   *   - `metrics_monitoring` requires `cloud-object-storage.backup_vault.put_metrics_monitoring`.
   *
   * @param updateBackupVaultOptions the {@link UpdateBackupVaultOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BackupVault}
   */
  public ServiceCall<BackupVault> updateBackupVault(UpdateBackupVaultOptions updateBackupVaultOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateBackupVaultOptions,
      "updateBackupVaultOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("backup_vault_name", updateBackupVaultOptions.backupVaultName());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults/{backup_vault_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "updateBackupVault");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateBackupVaultOptions.ifMatch() != null) {
      builder.header("If-Match", updateBackupVaultOptions.ifMatch());
    }
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithSerializeNulls().toJson(updateBackupVaultOptions.backupVaultPatch()), "application/merge-patch+json");
    ResponseConverter<BackupVault> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BackupVault>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an empty Backup Vault.
   *
   * Delete the Backup Vault.
   *
   * Requires that the BackupVault not contain any RecoveryRanges.  Requires that the user has
   * `cloud-object-storage.backup_vault.delete_backup_vault` permissions for the account.
   *
   * @param deleteBackupVaultOptions the {@link DeleteBackupVaultOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteBackupVault(DeleteBackupVaultOptions deleteBackupVaultOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteBackupVaultOptions,
      "deleteBackupVaultOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("backup_vault_name", deleteBackupVaultOptions.backupVaultName());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults/{backup_vault_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "deleteBackupVault");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
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
      builder.header("If-Match", updateBucketConfigOptions.ifMatch());
    }
    if (updateBucketConfigOptions.bucketPatch() != null) {
      builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithSerializeNulls().toJson(updateBucketConfigOptions.bucketPatch()), "application/merge-patch+json");
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List RecoveryRanges on a backup vault.
   *
   * List RecoveryRanges on a backup vault. Lists all available ranges for all source resources by default. The
   * `?source_resource_crn` query parameter will limit the list to only ranges for the specified resource.
   *
   * Requires the user have `cloud-object-storage.backup_vault.list_recovery_ranges` permissions to the Backup Vault.
   *
   * @param listRecoveryRangesOptions the {@link ListRecoveryRangesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RecoveryRangeCollection}
   */
  public ServiceCall<RecoveryRangeCollection> listRecoveryRanges(ListRecoveryRangesOptions listRecoveryRangesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listRecoveryRangesOptions,
      "listRecoveryRangesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("backup_vault_name", listRecoveryRangesOptions.backupVaultName());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults/{backup_vault_name}/recovery_ranges", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "listRecoveryRanges");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listRecoveryRangesOptions.sourceResourceCrn() != null) {
      builder.query("source_resource_crn", String.valueOf(listRecoveryRangesOptions.sourceResourceCrn()));
    }
    if (listRecoveryRangesOptions.latest() != null) {
      builder.query("latest", String.valueOf(listRecoveryRangesOptions.latest()));
    }
    if (listRecoveryRangesOptions.token() != null) {
      builder.query("token", String.valueOf(listRecoveryRangesOptions.token()));
    }
    ResponseConverter<RecoveryRangeCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RecoveryRangeCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * get RecoveryRange info.
   *
   * Get info for a specific RecoveryRange.
   *
   * Requires the user have `cloud-object-storage.backup_vault.get_recovery_range` permissions to the Backup Vault.
   *
   * @param getSourceResourceRecoveryRangeOptions the {@link GetSourceResourceRecoveryRangeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RecoveryRange}
   */
  public ServiceCall<RecoveryRange> getSourceResourceRecoveryRange(GetSourceResourceRecoveryRangeOptions getSourceResourceRecoveryRangeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getSourceResourceRecoveryRangeOptions,
      "getSourceResourceRecoveryRangeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("backup_vault_name", getSourceResourceRecoveryRangeOptions.backupVaultName());
    pathParamsMap.put("recovery_range_id", getSourceResourceRecoveryRangeOptions.recoveryRangeId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults/{backup_vault_name}/recovery_ranges/{recovery_range_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "getSourceResourceRecoveryRange");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<RecoveryRange> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RecoveryRange>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * patch RecoveryRange info.
   *
   * Update a RecoveryRange via JSON-merge-patch semantics.
   *
   * Requires the user have `cloud-object-storage.backup_vault.put_retention` permissions to the Backup Vault.
   *
   * The retention.delete_after_days value may only be extended.
   *
   * @param patchSourceResourceRecoveryRangeOptions the {@link PatchSourceResourceRecoveryRangeOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RecoveryRange}
   */
  public ServiceCall<RecoveryRange> patchSourceResourceRecoveryRange(PatchSourceResourceRecoveryRangeOptions patchSourceResourceRecoveryRangeOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(patchSourceResourceRecoveryRangeOptions,
      "patchSourceResourceRecoveryRangeOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("backup_vault_name", patchSourceResourceRecoveryRangeOptions.backupVaultName());
    pathParamsMap.put("recovery_range_id", patchSourceResourceRecoveryRangeOptions.recoveryRangeId());
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults/{backup_vault_name}/recovery_ranges/{recovery_range_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "patchSourceResourceRecoveryRange");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithSerializeNulls().toJson(patchSourceResourceRecoveryRangeOptions.recoveryRangePatch()), "application/merge-patch+json");
    ResponseConverter<RecoveryRange> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RecoveryRange>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Initiate a Restore.
   *
   * Initiates a restore operation against some RecoveryRange to some destination bucket.
   *
   * The following shall be validated. Any failure to validate shall cause a HTTP 400 to be returned.
   *
   *   * The specified RecoveryRange must exist
   *   * The restore time must be within the RecoveryRange
   *   * the user has `cloud-object-storage.backup-vault.post_restore` permissions on the backup-vault
   *   * the target-bucket must exist and be able to be contacted by the Backup Vault
   *   * target-bucket must have versioning-on
   *   * the Backup Vault must have `cloud-object-storage.bucket.restore_sync` permissions on the target-bucket.
   *
   * @param createRestoreOptions the {@link CreateRestoreOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Restore}
   */
  public ServiceCall<Restore> createRestore(CreateRestoreOptions createRestoreOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createRestoreOptions,
      "createRestoreOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("backup_vault_name", createRestoreOptions.backupVaultName());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults/{backup_vault_name}/restores", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "createRestore");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("recovery_range_id", createRestoreOptions.recoveryRangeId());
    contentJson.addProperty("restore_type", createRestoreOptions.restoreType());
    contentJson.add("restore_point_in_time", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRestoreOptions.restorePointInTime()));
    contentJson.addProperty("target_resource_crn", createRestoreOptions.targetResourceCrn());
    builder.bodyJson(contentJson);
    ResponseConverter<Restore> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Restore>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List Restores.
   *
   * List all current and complete restores.
   *
   * Requires that the user have `cloud-object-storage.backup_vault.list_restores` permission on the backup vault.
   *
   * @param listRestoresOptions the {@link ListRestoresOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RestoreCollection}
   */
  public ServiceCall<RestoreCollection> listRestores(ListRestoresOptions listRestoresOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listRestoresOptions,
      "listRestoresOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("backup_vault_name", listRestoresOptions.backupVaultName());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults/{backup_vault_name}/restores", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "listRestores");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listRestoresOptions.token() != null) {
      builder.query("token", String.valueOf(listRestoresOptions.token()));
    }
    ResponseConverter<RestoreCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RestoreCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get Restore.
   *
   * Introspect on a specific restore.
   *
   * Requires that the user have `cloud-object-storage.backup_vault.get_restore` permission on the backup vault.
   *
   * @param getRestoreOptions the {@link GetRestoreOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Restore}
   */
  public ServiceCall<Restore> getRestore(GetRestoreOptions getRestoreOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRestoreOptions,
      "getRestoreOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("backup_vault_name", getRestoreOptions.backupVaultName());
    pathParamsMap.put("restore_id", getRestoreOptions.restoreId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/backup_vaults/{backup_vault_name}/restores/{restore_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("resource_configuration", "v1", "getRestore");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Restore> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Restore>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
