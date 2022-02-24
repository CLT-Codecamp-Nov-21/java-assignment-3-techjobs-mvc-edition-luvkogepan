package org.launchcode.techjobs.mvc.controllers;

import org.launchcode.techjobs.mvc.models.Job;
import org.launchcode.techjobs.mvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import static org.launchcode.techjobs.mvc.controllers.ListController.columnChoices;
import static org.launchcode.techjobs.mvc.models.JobData.findByColumnAndValue;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @PostMapping(value="results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        ArrayList<Job> jobs;

        if (searchTerm.equals("all") || searchTerm.equals("")) {
        jobs= JobData.findAll();
        } else {
            jobs=JobData.findByColumnAndValue(searchType, searchTerm);
        }
        model.addAttribute("jobs", jobs);
        return "search";
    }
    //Post request
    //Path: /results
    //Method params: model(to pass search results), searchType, searchTerm

    //if searchTerm is "all" or "" return all jobs
    //else call findByColumnAndValue

    //add jobs to model

    //item7
    //        model.addAttribute("columns", columnChoices);

    //return template: search
    //search with th:if=result
}
