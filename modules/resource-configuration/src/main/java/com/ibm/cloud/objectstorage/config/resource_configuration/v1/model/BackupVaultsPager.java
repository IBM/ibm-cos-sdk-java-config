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

package com.ibm.cloud.objectstorage.config.resource_configuration.v1.model;

import com.ibm.cloud.objectstorage.config.resource_configuration.v1.ResourceConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * BackupVaultsPager can be used to simplify the use of the "listBackupVaults" method.
 */
public class BackupVaultsPager {
  private static class PageContext {
    private String next;
    public String getNext() {
      return next;
    }
    public void setNext(String next) {
      this.next = next;
    }
  }

  protected boolean hasNext;
  protected ListBackupVaultsOptions options;
  protected ResourceConfiguration client;
  protected PageContext pageContext;

  // Hide the default ctor.
  protected BackupVaultsPager() { }

  /**
   * Constructs a new BackupVaultsPager instance with the specified client and options model instance.
   * @param client the ResourceConfiguration instance to be used to invoke the "listBackupVaults" method
   * @param options the ListBackupVaultsOptions instance to be used to invoke the "listBackupVaults" method
   */
  public BackupVaultsPager(ResourceConfiguration client, ListBackupVaultsOptions options) {
    if (options.token() != null) {
      throw new IllegalArgumentException("The options 'token' field should not be set");
    }

    this.hasNext = true;
    this.client = client;
    this.options = options.newBuilder().build();
    this.pageContext = new PageContext();
  }

  /**
   * Returns true if there are more results to be retrieved.
   * @return boolean
   */
  public boolean hasNext() {
    return hasNext;
  }

  /**
   * Returns the next page of results.
   * @return a List&lt;String&gt; that contains the next page of results
   */
  public List<String> getNext() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more results available");
    }

    ListBackupVaultsOptions.Builder builder = this.options.newBuilder();
    if (this.pageContext.getNext() != null) {
      builder.token(this.pageContext.getNext());
    }
    this.options = builder.build();

    BackupVaultCollection result = client.listBackupVaults(options).execute().getResult();

    String next = null;
    if (result.getNext() != null) {
      next = result.getNext().getToken();
    }
    this.pageContext.setNext(next);
    if (next == null) {
      this.hasNext = false;
    }

    return result.getBackupVaults();
  }

  /**
   * Returns all results by invoking getNext() repeatedly until all pages of results have been retrieved.
   * @return a List&lt;String&gt; containing all results returned by the "listBackupVaults" method
   */
  public List<String> getAll() {
    List<String> results = new ArrayList<>();
    while (hasNext()) {
      List<String> nextPage = getNext();
      results.addAll(nextPage);
    }
    return results;
  }
}
