package com.ibm.cloud.objectstorage.config.common;

import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.util.RequestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SdkCommon {
    private static final Logger LOG = Logger.getLogger(SdkCommon.class.getName());
    private static String userAgent = null;
    private static String sdkVersion = "1.0.0";

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
