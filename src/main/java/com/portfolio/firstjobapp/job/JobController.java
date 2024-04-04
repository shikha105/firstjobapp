package com.portfolio.firstjobapp.job;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class JobController {

private List<Job> jobs = new ArrayList<>();

     @GetMapping
    public List<Job> findAll(){
        return jobs;
    }
}
