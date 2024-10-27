package com.luv2code.springboot.cruddemowithrelationaldatabase.service;

import com.luv2code.springboot.cruddemowithrelationaldatabase.entity.InstructorDetail;
import com.luv2code.springboot.cruddemowithrelationaldatabase.reposatity.InstructorDetailRepoInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorDetailServiceImplement implements InstructorDetailServiceInterface{

    private final InstructorDetailRepoInterface instructorDetailRepo;

    public InstructorDetailServiceImplement(InstructorDetailRepoInterface instructorDetailRepo) {
        this.instructorDetailRepo = instructorDetailRepo;
    }


    @Override
    public void saveInstructorDetail(InstructorDetail instructorDetail) {
        instructorDetailRepo.save(instructorDetail);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        Optional<InstructorDetail> instructorDetail=instructorDetailRepo.findById(id);
        return instructorDetail.orElse(null);
    }

    @Override
    public List<InstructorDetail> findAllInstructorDetails() {
        return instructorDetailRepo.findAll();
    }

    @Override
    public void updateInstructorDetail(InstructorDetail instructorDetail) {
       Optional<InstructorDetail> instructorDetailOptional =instructorDetailRepo.findById(instructorDetail.getId());
       if(instructorDetailOptional.isPresent()){
           instructorDetailOptional.get().setYoutubeChannel(instructorDetail.getYoutubeChannel());
           instructorDetailOptional.get().setHobby(instructorDetail.getHobby());

           instructorDetailRepo.save(instructorDetailOptional.get());
       }
    }

    @Override
    public void deleteInstructorDetailById(int id) {
        instructorDetailRepo.deleteById(id);
    }
}
