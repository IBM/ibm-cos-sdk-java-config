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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Utility class for accessing COS Config SDK versioning information.
 */
public class VersionUtils {

    private static final Logger LOGGER = Logger.getLogger(VersionUtils.class.getName());

    /** The COS Config SDK version info file with SDK versioning info */
    static final String VERSION_INFO_FILE = "version.properties";

    /** SDK version info */
    private static volatile String version;

    /**
     * Returns the current version for the COS Config SDK in which this class is
     * running. Version information is obtained from from the
     * versionInfo.properties file which the COS Config Java SDK build process
     * generates.
     *
     * @return The current version for the COS Config SDK, if known, otherwise
     *         returns a string indicating that the version information is
     *         not available.
     */
    public static String getVersion() {
        if (version == null) {
            synchronized(VersionUtils.class) {
                if (version == null) {
                    initializeVersion();
                }
            }
        }
        return version;
    }

    /**
     * Loads the versionInfo.properties file from the COS Config Java SDK and
     * stores the information so that the file doesn't have to be read the
     * next time the data is needed.
     */
    private static void initializeVersion() {
        InputStream inputStream = VersionUtils.class.getClassLoader().getResourceAsStream(VERSION_INFO_FILE);        

        Properties versionInfoProperties = new Properties();
        try {
            if (inputStream == null) {
                throw new IOException(VERSION_INFO_FILE + " not found on classpath");
            }
            versionInfoProperties.load(inputStream);
            version = versionInfoProperties.getProperty("version");
        } catch (IOException e) {
            LOGGER.info("Unable to load version information for the running SDK: " + e.getMessage());
            version = "unknown-version";
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.info("Ignore failure in closing the Closeable");
            }
        }
    }
}
