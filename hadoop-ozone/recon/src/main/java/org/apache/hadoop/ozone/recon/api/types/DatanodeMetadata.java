/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.ozone.recon.api.types;

import com.google.common.base.Preconditions;
import org.apache.hadoop.hdds.protocol.proto.HddsProtos.NodeState;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Metadata object that represents a Datanode.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public final class DatanodeMetadata {

  @XmlElement(name = "hostname")
  private String hostname;

  @XmlElement(name = "state")
  private NodeState state;

  @XmlElement(name = "lastHeartbeat")
  private long lastHeartbeat;

  @XmlElement(name = "storageReport")
  private DatanodeStorageReport datanodeStorageReport;

  @XmlElement(name = "pipelines")
  private List<DatanodePipeline> pipelines;

  @XmlElement(name = "containers")
  private int containers;

  @XmlElement(name = "leaderCount")
  private int leaderCount;

  private DatanodeMetadata(Builder builder) {
    this.hostname = builder.hostname;
    this.state = builder.state;
    this.lastHeartbeat = builder.lastHeartbeat;
    this.datanodeStorageReport = builder.datanodeStorageReport;
    this.pipelines = builder.pipelines;
    this.containers = builder.containers;
    this.leaderCount = builder.leaderCount;
  }

  public String getHostname() {
    return hostname;
  }

  public NodeState getState() {
    return state;
  }

  public long getLastHeartbeat() {
    return lastHeartbeat;
  }

  public DatanodeStorageReport getDatanodeStorageReport() {
    return datanodeStorageReport;
  }

  public List<DatanodePipeline> getPipelines() {
    return pipelines;
  }

  public int getContainers() {
    return containers;
  }

  public int getLeaderCount() {
    return leaderCount;
  }

  /**
   * Returns new builder class that builds a DatanodeMetadata.
   *
   * @return Builder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Builder for DatanodeMetadata.
   */
  @SuppressWarnings("checkstyle:hiddenfield")
  public static final class Builder {
    private String hostname;
    private NodeState state;
    private long lastHeartbeat;
    private DatanodeStorageReport datanodeStorageReport;
    private List<DatanodePipeline> pipelines;
    private int containers;
    private int leaderCount;

    public Builder() {
      this.containers = 0;
      this.leaderCount = 0;
    }

    public Builder withHostname(String hostname) {
      this.hostname = hostname;
      return this;
    }

    public Builder withState(NodeState state) {
      this.state = state;
      return this;
    }

    public Builder withLastHeartbeat(long lastHeartbeat) {
      this.lastHeartbeat = lastHeartbeat;
      return this;
    }

    public Builder withDatanodeStorageReport(DatanodeStorageReport 
                                                 datanodeStorageReport) {
      this.datanodeStorageReport = datanodeStorageReport;
      return this;
    }

    public Builder withPipelines(List<DatanodePipeline> pipelines) {
      this.pipelines = pipelines;
      return this;
    }

    public Builder withContainers(int containers) {
      this.containers = containers;
      return this;
    }

    public Builder withLeaderCount(int leaderCount) {
      this.leaderCount = leaderCount;
      return this;
    }

    /**
     * Constructs DatanodeMetadata.
     *
     * @return instance of DatanodeMetadata.
     */
    public DatanodeMetadata build() {
      Preconditions.checkNotNull(hostname);
      Preconditions.checkNotNull(state);

      return new DatanodeMetadata(this);
    }
  }
}
