package org.kuali.kfs.coa.rest;


import org.kuali.kfs.coa.businessobject.Chart;
import org.kuali.kfs.coa.businessobject.lookup.ChartSearch;
import org.kuali.kfs.sys.context.SpringContext;
import org.kuali.rice.krad.service.LookupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChartController {

    // Lines commented out here and line 378 of the web.xml render a different result that partially works in a different way

//    @RequestMapping(value="/lookup/coa/chart/{code}", method= RequestMethod.GET, produces="application/json")
    @RequestMapping(value="/lookup/coa/chart/BA", method= RequestMethod.GET, produces="application/json")
    public @ResponseBody Chart lookupChartByPrimaryKey(/**@PathVariable String code*/) {
        final LookupService lookupService = SpringContext.getBean(LookupService.class);
        final ChartSearch chartSearch = new ChartSearch(lookupService);
        return chartSearch.retrieveByChartCode("BA");
//        return chartSearch.retrieveByChartCode(code);
    }
}
