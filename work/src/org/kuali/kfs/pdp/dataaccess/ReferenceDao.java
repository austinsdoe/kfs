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
/*
 * Created on Jul 8, 2004
 *
 */
package org.kuali.kfs.pdp.dataaccess;

import java.util.List;
import java.util.Map;

import org.kuali.rice.kns.bo.user.UniversalUser;


/**
 * @author jsissom
 */
public interface ReferenceDao {
    //public Code getCode(String type, String key);

    public List getAll(String type);

    public Map getAllMap(String type);

    //public Code addCode(String type, String code, String description, UniversalUser u);

    public void updateCode(String code, String description, String type, UniversalUser u);

    //public void updateCode(Code item, UniversalUser u);

    //public void deleteCode(Code item);
}
