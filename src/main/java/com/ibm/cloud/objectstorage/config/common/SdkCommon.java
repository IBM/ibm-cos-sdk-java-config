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
package com.ibm.cloud.objectstorage.config.common;

import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.util.RequestUtils;

import java.util.HashMap;
import java.util.Map;

public class SdkCommon {

    private static String userAgent = null;
    private static String sdkVersion = VersionUtils.getVersion();

    private SdkCommon() { }

    private static String getUserAgent() {
        if (userAgent == null) {
            userAgent = "ibm-cos-resource-config-sdk-java/" + sdkVersion + "; " + RequestUtils.getSystemInfo();
        }
        return userAgent;
    }

    public static Map<String, String> getSdkHeaders(String serviceName, String serviceVersion, String operationId) {
        Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.USER_AGENT, getUserAgent());
        return headers;
    }
}
