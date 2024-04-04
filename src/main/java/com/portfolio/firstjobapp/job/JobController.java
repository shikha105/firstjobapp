package com.portfolio.firstjobapp.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {


    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job added successfully";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if(job!=null)
          return job;
        return new Job(1L, "testtitle", "testDescription", "1000", "40000", "van");
    }
}
