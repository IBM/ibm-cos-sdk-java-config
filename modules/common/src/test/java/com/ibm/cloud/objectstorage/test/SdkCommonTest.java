/**
 * Copyright 2019 IBM Corp. All Rights Reserved.
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

package com.ibm.cloud.objectstorage.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.ibm.cloud.objectstorage.common.SdkCommon;

/**
 * This class contains tests for the SdkCommon class.
 */
public class SdkCommonTest {

    @Test
    public void testGetSdkHeaders() {
        Map<String, String> headers = SdkCommon.getSdkHeaders("service1", "v1", "operation1");
        assertNotNull(headers);
        assertFalse(headers.isEmpty());
        assertTrue(headers.containsKey("User-Agent"));
        String userAgent = headers.get("User-Agent");
        System.out.println("User-Agent: " + userAgent);
        String expectedUserAgentRegex = String.format("%s/%s .*", SdkCommon.getProjectName(), SdkCommon.getVersion());
        assertTrue(userAgent.matches(expectedUserAgentRegex));
    }
}
