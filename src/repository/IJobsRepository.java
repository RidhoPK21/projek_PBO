/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.ArrayList;
import entity.Jobs;

/**
 *
 * @author firman_hutasoit
 */
public interface IJobsRepository {   
    ArrayList<Jobs> repoGetAllJobs();
    
    Integer repoAddJobs(Jobs jobs);

    Boolean repoRemoveJobs(Integer id);
    
    Boolean repoUpdateJobs(Jobs jobs);
    
    ArrayList<Jobs> repoGetJObsByRole(String rolePekerjaan);
    ArrayList<Jobs> repoSearchJobs(String keyword);
    
}
