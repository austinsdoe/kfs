/*
 * Copyright 2006-2007 The Kuali Foundation.
 * 
 * Licensed under the Educational Community License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.kfs.gl.batch.service;

import java.util.Map;

import org.kuali.kfs.gl.businessobject.OriginEntryGroup;

/**
 * An interface declaring the methods needed to run the organization reversion process
 */
public interface OrganizationReversionProcessService {

    /**
     * Runs the Organization Reversion Year End Process for the end of a fiscal year (ie, a process that
     * runs before the fiscal year end, and thus uses current account, etc.)
     * 
     * @param jobParameters the parameters used in the process
     * @param organizationReversionCounts a Map of named statistics generated by running the process
     */
    public void organizationReversionProcessEndOfYear(Map jobParameters, Map<String, Integer> organizationReversionCounts);

    /**
     * Organization Reversion Year End Process for the beginning of a fiscal year (ie, the process as it runs
     * after the fiscal year end, thus using prior year account, etc.)
     * 
     * @param jobParameters the parameters used in the process
     * @param organizationReversionCounts a Map of named statistics generated by running the process
     */
    public void organizationReversionProcessBeginningOfYear(Map jobParameters, Map<String, Integer> organizationReversionCounts);

    /**
     * Returns the parameters for this organization reversion job
     * 
     * @return a Map of standard parameters for the job
     */
    public Map getJobParameters();
}
