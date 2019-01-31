# IBM COS Resource Configuration SDK for Java

This package allows Java developers to write software that interacts with the Resource Configuration API for [IBM
Cloud Object Storage](https://cloud.ibm.com/apidocs/cos/cos-configuration).

## Documentation

* [Core documentation for IBM COS](https://cloud.ibm.com/docs/services/cloud-object-storage/getting-started.html)
* [REST API Reference and Code Examples](https://cloud.ibm.com/apidocs/cos/cos-configuration)
* [Java Resource Configuration API reference documentation](https://ibm.github.io/ibm-cos-sdk-java-config)

Changes to the SDK are tracked in the [CHANGELOG.md][changes-file] file.

  - [IBM COS Resource Configuration SDK for Java](#ibm-cos-resource-configuration-sdk-for-java)
  - [Documentation](#documentation)
  - [Quick start](#quick-start)
  - [Getting the SDK](#getting-the-sdk)
  - [Building from source](#building-from-source)
  - [Getting help](#getting-help)
  - [License](#license)

## Quick start
You'll need:
  * An instance of COS.
  * An API key from [IBM Cloud Identity and Access Management](https://cloud.ibm.com/docs/iam/users_roles.html).
  * **Java 1.6+**

## Getting the SDK
The recommended way to use the IBM COS SDKs for Java in your project is to consume it from Maven. Import the `ibm-cos-java-config` and specify the SDK Maven modules that your project needs in the dependencies:

```xml
<dependencies>
  <dependency>
    <groupId>com.ibm.cos.config</groupId>
    <artifactId>ibm-cos-java-config</artifactId>
  </dependency>
</dependencies>
```

## Building from source

Once you check out the code from GitHub, you can build it using Maven:

```sh
mvn clean install
```

## Getting help
Feel free to use GitHub issues for tracking bugs and feature requests, but for help please use one of the following resources:

* Read a quick start guide in [IBM Cloud Docs][bluemix-docs]
* Ask a question on [StackOverflow][stack-overflow] and tag it with `ibm` and `object-storage`
* Open a support ticket with [IBM Cloud Support][ibm-bluemix-support]
* If it turns out that you may have found a bug, please [open an issue][open-an-issue]

[changes-file]: ./CHANGELOG.md
[bluemix-docs]: https://cloud.ibm.com/docs/services/cloud-object-storage/
[stack-overflow]: http://stackoverflow.com/questions/tagged/object-storage+ibm
[ibm-bluemix-support]: https://cloud.ibm.com/unifiedsupport/supportcenter
[open-an-issue]: https://github.com/ibm/ibm-cos-sdk-java-config/issues/new

## License

This SDK is distributed under the
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
