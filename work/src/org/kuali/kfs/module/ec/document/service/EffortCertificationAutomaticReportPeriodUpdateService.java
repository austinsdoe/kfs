/*
 * Copyright 2007 The Kuali Foundation.
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
package org.kuali.module.effort.service;

import java.util.List;

import org.kuali.module.effort.bo.EffortCertificationReportDefinition;

/**
 * Contains service methods for the Effort Certification Automatic Period Update Process
 */
public interface EffortCertificationAutomaticReportPeriodUpdateService {

    /**
     * Checks if this report definition will overlap an already existing report definition
     * @param reportDefinition
     * @return true reportDefinition is an overlapping report defintion
     */
    public boolean isAnOverlappingReportDefinition(EffortCertificationReportDefinition reportDefinition);

    /**
     * gets all EffortCertificationReportDefinition records
     * @return list of EffortCertificationReportDefinition records
     */
    public List<EffortCertificationReportDefinition> getAllReportDefinitions();
}
