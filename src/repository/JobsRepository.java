/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Jobs;
import model.ModelJobs;
import java.util.ArrayList;

/**
 *
 * @author firman_hutasoit
 */
public class JobsRepository implements IJobsRepository{

    @Override
    public ArrayList<Jobs> repoGetAllJobs() {
        return ModelJobs.getAllJobs("");
    }

    @Override
    public Integer repoAddJobs(Jobs jobs) {
        return ModelJobs.addJob(jobs);
    }

    @Override
    public Boolean repoRemoveJobs(Integer jobId) {
        return ModelJobs.deleteJob(jobId);
    }

    @Override
    public Boolean repoUpdateJobs(Jobs jobs) {
        return ModelJobs.updateJob(jobs);
    }

//  

    @Override
    public ArrayList<Jobs> repoSearchJobs(String keyword) {
        return ModelJobs.searchJobsByKeyword(keyword);
    }

    @Override
    public ArrayList<Jobs> repoGetJObsByRole(String rolePekerjaan) {
        return ModelJobs.getJobsByRole(rolePekerjaan);
    }


}
