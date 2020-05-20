/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * <p>Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.apache.hadoop.hdds.scm.ha;

import org.apache.hadoop.hdds.conf.OzoneConfiguration;
import org.apache.hadoop.hdds.scm.server.ratis.SCMRatisServer;

import java.io.IOException;
import java.util.Collections;

public class SCMHAManager {

  private static boolean isLeader = true;

  private final SCMRatisServer ratisServer;

  public SCMHAManager(OzoneConfiguration conf) throws IOException {
    SCMNodeDetails scmNodeDetails = SCMNodeDetails
        .initStandAlone(conf);
    this.ratisServer = SCMRatisServer.newSCMRatisServer(
        conf.getObject(SCMRatisServer.SCMRatisServerConfiguration.class),
        //TODO should depend on SCM?
        null, scmNodeDetails, Collections.EMPTY_LIST,
        SCMRatisServer.getSCMRatisDirectory(conf));
  }

  public static boolean isLeader() {
    return isLeader;
  }

  public void startRatisServer() throws IOException {
    ratisServer.start();
  }

  public SCMRatisServer getRatisServer() {
    return ratisServer;
  }

  public void stopRatisServer() throws IOException {
    ratisServer.stop();
  }

}
