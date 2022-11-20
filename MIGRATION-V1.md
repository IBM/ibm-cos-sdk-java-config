# Migration Guide - upgrading to ibm-cos-sdk-java-config@2.0.0

- [Breaking Changes](#breaking-changes)
  - [Changes in Package Imports](#changes-in-package-imports)
  - [Changes in Create Client](#changes-in-create-client)
  - [Changes in API methods and updating bucket configuration](#changes-in-api-methods-and-updating-bucket-configuration)
  - [Changes in Response](#changes-in-response)

## Breaking changes

### Changes in Package Imports

```js
=======================================================================================================================================================
|                       Current                              |                                         New                                            |
=======================================================================================================================================================
| import com.ibm.cloud.sdk.core.service.security.IamOptions; | import com.ibm.cloud.sdk.core.security.IamAuthenticator;                               |
|                                                            | import com.ibm.cloud.sdk.core.http.Response;                                           |
|                                                            | import com.ibm.cloud.objectstorage.config.resource_configuration.v1.model.BucketPatch; |
```

### Changes in Create Client

#### Method-1: Using API Key

```js
===================================================================================================================================================================
|                       Current                                          |                                         New                                            |
===================================================================================================================================================================
| IamOptions iamOptions = new IamOptions.Builder()                       | IamAuthenticator authenticator = new IamAuthenticator.Builder()                        |
|                         .apiKey(apiKey).url(ibmAuthEndpoint).build();  |                                  .apikey(apiKey).url(ibmAuthEndpoint).build();         |
|                                                                        |                                                                                        |
```

#### Method-2: Using Access Token

```js
==========================================================================================================================================================================
|                       Current                                                    |                                         New                                         |
==========================================================================================================================================================================
| IamOptions iamOptions = new IamOptions.Builder()                                 | BearerTokenAuthenticator authenticator = new BearerTokenAuthenticator(bearerToken); |
|                         .accessToken(accessToken).url(ibmAuthEndpoint).build();  |                                                                                     |
|                                                                                  |                                                                                     |
```

#### Creating Client

Credentials using `IamOptions` are no longer supported. Rather,
`resource-configuration` String and an instance of `Authenticator`
should be passed as below.

```js
==========================================================================================================================================================================================
|                       Current                                               |                                         New                                                              |
==========================================================================================================================================================================================
| ResourceConfiguration configClient = new ResourceConfiguration(iamOptions); | ResourceConfiguration configClient = new ResourceConfiguration("resource-configuration", authenticator); |
```

### Changes in API methods and updating bucket configuration

- Step-1 - Creating API objects

    Activity-Tracking

    ```js
    ======================================================================================================================================================================================
    |                                    Current                                            |                                          New                                               |
    ======================================================================================================================================================================================
    | ActivityTracking activityTrackingConfig = new ActivityTracking()                      | ActivityTracking activityTrackingConfig = new ActivityTracking.Builder()                   |
    |                                           .setActivityTrackerCrn(activityTrackerCrn); |                                           .activityTrackerCrn(activityTrackerCrn).build(); |
    |                                                                                       |                                                                                            |
    | ActivityTracking activityTrackingConfig = new ActivityTracking()                      | ActivityTracking activityTrackingConfig = new ActivityTracking.Builder()                   |
    |                                           .setReadDataEvents(boolean);                |                                           .readDataEvents(boolean).build();                |
    |                                                                                       |                                                                                            |
    | ActivityTracking activityTrackingConfig = new ActivityTracking()                      | ActivityTracking activityTrackingConfig = new ActivityTracking.Builder()                   |
    |                                           .setWriteDataEvents(boolean);               |                                           .writeDataEvents(boolean).build();               |
    ```

    Metrics-Monitoring

    ```js
    ==================================================================================================================================================================================
    |                                    Current                                            |                                           New                                          |
    ==================================================================================================================================================================================
    | MetricsMonitoring metricsMonitoringConfig = new MetricsMonitoring()                   | MetricsMonitoring metricsMonitoringConfig = new MetricsMonitoring.Builder()            |
    |                                             .setMetricsMonitoringCrn(metricsCrn);     |                                             .metricsMonitoringCrn(metricsCrn).build(); |
    |                                                                                       |                                                                                        |
    | MetricsMonitoring metricsMonitoringConfig = new MetricsMonitoring()                   | MetricsMonitoring metricsMonitoringConfig = new MetricsMonitoring.Builder()            |
    |                                             .setRequestMetricsEnabled(boolean);       |                                             .requestMetricsEnabled(boolean).build();   |
    |                                                                                       |                                                                                        |
    | MetricsMonitoring metricsMonitoringConfig = new MetricsMonitoring()                   | MetricsMonitoring metricsMonitoringConfig = new MetricsMonitoring.Builder()            |
    |                                             .setUsageMetricsEnabled(boolean);         |                                             .usageMetricsEnabled(boolean).build();     |
    ```

    Firewall

  - Passing List as parameter

    ```js
    |==================================================================================================================================================================|
    |                                  Current                                     |                                       New                                         |
    |==================================================================================================================================================================|
    |  Firewall firewallConfig = new Firewall()                                    |  Firewall firewallConfig = new Firewall.Builder()                                 |
    |                            .setAllowedIp(allowedIpAsList);                   |                            .allowedIp(allowedIpAsList).build();                   |
    |                                                                              |                                                                                   |
    |  Firewall firewallConfig = new Firewall()                                    |  Firewall firewallConfig = new Firewall.Builder()                                 |
    |                            .setAllowedNetworkType(allowedNetworkTypeAsList); |                            .allowedNetworkType(allowedNetworkTypeAsList).build(); |
    |                                                                              |                                                                                   |
    |  Firewall firewallConfig = new Firewall()                                    |  Firewall firewallConfig = new Firewall.Builder()                                 |
    |                            .setDeniedIp(deniedIpAsList);                     |                            .deniedIp(deniedIpAsList).build();                     |
    ```

  - Passing String as parameter

    ```js
    Firewall firewallConfig  = new Firewall.Builder().addAllowedIp(allowedIpAsString).build();
    
    Firewall firewallConfig  = new Firewall.Builder().addAllowedNetworkType(allowedNetworkTypeaAString).build();
    
    Firewall firewallConfig  = new Firewall.Builder().addDeniedIp(deniedIpAsString).build();
    
    ```

    **NOTE:**  `allowedNetworkType` accepted values are like `AllowedNetworkType.X_PRIVATE`/`AllowedNetworkType.X_PUBLIC`/`AllowedNetworkType.DIRECT`.

- Step-2 - Building a Patch Object from the above API objects

    ```js
    BucketPatch bucketPatch = new BucketPatch.Builder().activityTracking(activityTrackingConfig).build();
    
    BucketPatch bucketPatch = new BucketPatch.Builder().firewall(firewallConfig).build();
    
    BucketPatch bucketPatch = new BucketPatch.Builder().hardQuota(integer).build();
    
    BucketPatch bucketPatch = new BucketPatch.Builder().metricsMonitoring(metricsMonitoringConfig).build();
    
    ```
  
- Step-3 - Updating bucket configuration

     ```js
    |=============================================================================================================================================================================================|
    |                                           Current                                            |                                             New                                              |
    |=============================================================================================================================================================================================|
    |  UpdateBucketConfigOptions bucketOptions = new UpdateBucketConfigOptions.Builder(bucketName) |   UpdateBucketConfigOptions updateBucket = new UpdateBucketConfigOptions.Builder(bucketName) |
    |                                            .apiName(apiConfig).build();                      |                                            .bucketPatch(bucketPatch.asPatch()).build();      |
    ```

  - **NOTE:**  `apiName` and `apiConfig` are `activityTracking/firewall/hardQuota/metricsMonitoring` and `activityTrackingConfig/firewallConfig/hardQuotaConfig/metricsMonitoringConfig` respectively.

### Changes in Response

- Get-Bucket-Configuration

     ```js
    |=======================================================================================================================================================================|
    |                                      Current                                    |                                       New                                           |
    |=======================================================================================================================================================================|
    |  Bucket bucket = = configClient.getBucketConfig(bucketOptions).execute();       |  Bucket bucket = configClient.getBucketConfig(bucketOptions).execute().getResult(); |
    ```

- Activity-Tracking

   ```js
    |==========================================================================================================================================================================================|
    |                                           Current                                            |                                            New                                            |
    |==========================================================================================================================================================================================|
    |  String activityTrackingCrn = getBucketConfig.getActivityTracking().getActivityTrackerCrn(); |  String activityTrackingCrn = getBucketConfig.getActivityTracking().activityTrackerCrn(); |
    |                                                                                              |                                                                                           |
    |  boolean isReadEvents = getBucketConfig.getActivityTracking().isReadDataEvents();            |  boolean isReadEvents = getBucketConfig.getActivityTracking().readDataEvents();           |
    |                                                                                              |                                                                                           |
    |  boolean isWriteEvents = getBucketConfig.getActivityTracking().isWriteDataEvents();          |  boolean isWriteEvents = getBucketConfig.getActivityTracking().writeDataEvents();         |
    |                                                                                              |                                                                                           |
    ```

- Firewall

    ```js
    |===================================================================================================================================================================================|
    |                                         Current                                           |                                          New                                          |
    |===================================================================================================================================================================================|
    |  List<String> allowedIp = getBucketConfig.getFirewall().getAllowedIp();                   |  List<String> allowedIp = getBucketConfig.getFirewall().allowedIp();                  |
    |                                                                                           |                                                                                       |
    |  List<String> allowedNetworkType = getBucketConfig.getFirewall().getAllowedNetworkType(); |  List<String> allowedNetworkType = getBucketConfig.getFirewall().allowedNetworkType();|
    |                                                                                           |                                                                                       |
    |  boolean isWriteEvents = getBucketConfig.getFirewall().getDeniedIp();                     |  List<String> deniedIp = getBucketConfig.getFirewall().deniedIp();                    |
    |                                                                                           |                                                                                       |
    ```

- Metrics-Monitoring

     ```js
    |======================================================================================================================================================================================================================|
    |                                           Current                                                    |                                                  New                                                          |
    |======================================================================================================================================================================================================================|
    |  String metricsMonitoringCrn = getBucketConfig.getMetricsMonitoring().getMetricsMonitoringCrn();     |  String metricsMonitoringCrn = getBucketConfig.getBucketConfig.getMetricsMonitoring().metricsMonitoringCrn(); |
    |                                                                                                      |                                                                                                               |
    |  boolean isRequestMetricsEnabled = getBucketConfig.getMetricsMonitoring().isRequestMetricsEnabled(); |  boolean isRequestMetricsEnabled = getBucketConfig.getMetricsMonitoring().requestMetricsEnabled();            |
    |                                                                                                      |                                                                                                               |
    |  boolean isUsageMetricsEnabled = getBucketConfig.getMetricsMonitoring().isUsageMetricsEnabled();     |  boolean isUsageMetricsEnabled = getBucketConfig.getMetricsMonitoring().usageMetricsEnabled();                |
    |                                                                                                      |                                                                                                               |
    ```

### Changes in Agent Name

```js
  |============================================================= |
  |             Current              |           New             |
  |==============================================================|
  | ibm-cos-resource-config-sdk-java |   ibm-cos-sdk-java-config |
```
