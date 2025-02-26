package com.MovieApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.MovieApp.Entity.ShowDetails;
import com.MovieApp.Repo.ShowRepo;

@Service
public class ShowServiceImpl implements ShowService{
	
	@Autowired
	private ShowRepo showRepo;

	
	public List<ShowDetails> getShowDetails(){
		return (List<ShowDetails>) showRepo.findAll();
	}


	@Override
	public void saveShow(ShowDetails s) {
		// TODO Auto-generated method stub
		showRepo.save(s);
	}


	@Override
	public void deleteShow(ShowDetails sd) {
		// TODO Auto-generated method stub
		showRepo.delete(sd);
	}


	@Override
	public ShowDetails findshow(int showID) {
		// TODO Auto-generated method stub
		return showRepo.findById(showID).orElse(null);
	}
}
