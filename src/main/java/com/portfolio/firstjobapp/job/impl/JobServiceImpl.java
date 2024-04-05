package com.portfolio.firstjobapp.job.impl;

import com.portfolio.firstjobapp.job.Job;
import com.portfolio.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long autoId= 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {

        job.setId(autoId
        ++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {

        for (Job job : jobs) {
            if (job.getId().equals(id)) return job;
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator= jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
