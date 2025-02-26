package com.example.Online.Cinema.Ticket.Booking.System.controller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Online.Cinema.Ticket.Booking.System.Entity.MovieDetails;
import com.example.Online.Cinema.Ticket.Booking.System.Entity.SelectedSeatsData;
import com.example.Online.Cinema.Ticket.Booking.System.Entity.ShowDetails;

import com.example.Online.Cinema.Ticket.Booking.System.Entity.TheatreDetails1;
import com.example.Online.Cinema.Ticket.Booking.System.Repository.MovieRepository;
import com.example.Online.Cinema.Ticket.Booking.System.Repository.ShowDetailsRepository;
import com.example.Online.Cinema.Ticket.Booking.System.Repository.TheatreRepository;
import com.google.common.base.Optional;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	TheatreRepository trepo; 
	
	@Autowired
	ShowDetailsRepository srepo;
	
	@Autowired
	MovieRepository mrepo; 
	
	
	
	String district ="";
	Long movieId;
	Long theatreId ;
	Long showId;
	List<String> list = new ArrayList<String>();
	List<String> selectedseatsdata = new ArrayList<String>();
	
	@PostMapping("/addtheatre")
	public ResponseEntity<TheatreDetails1> Add(@RequestBody TheatreDetails1 theatre){
		System.out.println("theatre added");
		 trepo.save(theatre);
		return new ResponseEntity<>(trepo.save(theatre),HttpStatus.OK);  
	}
	
	@PostMapping("/addmovie")
	public ResponseEntity<MovieDetails> AddMovie(@RequestBody MovieDetails movie){
		 mrepo.save(movie);
		return new ResponseEntity<>(mrepo.save(movie),HttpStatus.OK);  
	}
	
	@PostMapping("/addshow")
	public ResponseEntity<ShowDetails> AddShow(@RequestBody ShowDetails show){
		System.out.println("show add");
		System.out.println(show.getProxyMovie());
//		System.out.println(show);
		Long Id = show.getProxyTheatre();
		System.out.println(Id);
		TheatreDetails1 details = trepo.findById(Id).get();
		System.out.println(details);
		Long movieId = show.getProxyMovie() ;
		MovieDetails movie = mrepo.findById(movieId).get();
		System.out.println(movie);
//		System.out.println(movie);
//		System.out.println("hi");
		show.setTheatre(details);
		show.setMovie(movie);
		 srepo.save(show);
//		 System.out.println(show);
		return new ResponseEntity<>(srepo.save(show),HttpStatus.OK);  
	}
	
	@PutMapping("/editshow")
	public ResponseEntity<ShowDetails> EditShow(@RequestBody ShowDetails show){
		Long Id = showId;
		System.out.println("edit show");
//		System.out.println(Id);
		ShowDetails show1 = srepo.findById(Id).get();
//		System.out.println(show1);
//		System.out.println(show);
		System.out.println("edit show1");
		System.out.println(show.getProxyTheatre());
//		show1.setProxyMovie(show.getProxyMovie());
//		show1.setProxyTheatre(show.getProxyTheatre());
		show1.setRegularSeats_Available(show.getRegularSeats_Available());
		show1.setPricePerSeat(show.getPricePerSeat());
		show1.setTimeSlot(show.getTimeSlot());
		System.out.println("ttttt");
//		TheatreDetails1 tdet = trepo.findById(show.getProxyTheatre()).get();
//		System.out.println(show.getProxyTheatre());
//		System.out.println("ttttpp");
//		MovieDetails movie = mrepo.findById(show.getProxyMovie()).get();
//		show1.setMovie(movie);
//		show1.setTheatre(tdet);
//		System.out.println("tttttoooo");
		 srepo.save(show1);
//		 System.out.println("edited show");
//		 System.out.println(show1);
		return new ResponseEntity<>(srepo.save(show1),HttpStatus.OK);  
	}
	
	@PutMapping("/editmovie")
	public ResponseEntity<MovieDetails> EditMovie(@RequestBody MovieDetails movie){
		Long Id = movieId;
		System.out.println(Id);
//		System.out.println("edit show");
//		System.out.println(Id);
		MovieDetails movie1 = mrepo.findById(Id).get();
		movie1.setMovieName(movie.getMovieName());
		movie1.setDuration(movie.getDuration());
		movie1.setLanguage(movie.getLanguage());
		mrepo.save(movie1);
		return new ResponseEntity<>(mrepo.save(movie1),HttpStatus.OK);  
	}
	
	@PutMapping("/edittheatre")
	public ResponseEntity<TheatreDetails1> EditTheatre(@RequestBody TheatreDetails1 theatre){
		Long Id = theatreId;
//		System.out.println("edit show");
//		System.out.println(Id);
		TheatreDetails1 theatre1 = trepo.findById(Id).get();
		theatre1.setDistrict(theatre.getDistrict());
		theatre1.setMetroLocation(theatre.getMetroLocation());
		theatre1.setNumberOfShows(theatre.getNumberOfShows());
		theatre1.setReservationCapacityRegular(theatre.getReservationCapacityRegular());
		theatre1.setTheatreName(theatre.getTheatreName());
		theatre1.setSeatingCapacity(theatre.getSeatingCapacity());
		return new ResponseEntity<>(trepo.save(theatre1),HttpStatus.OK);  
	}
	
	@GetMapping("/theatrelist")
	public ResponseEntity<List<TheatreDetails1>> Get(){
		return new ResponseEntity<>( trepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/shows")
	public ResponseEntity<List<ShowDetails>> GetShows(){
		
		return new ResponseEntity<>(srepo.findAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/show")
	public ResponseEntity<List<ShowDetails>> GetShow(){
//		System.out.println("edit");
		Long Id = showId;
//		List<ShowDetails> showdetails = (List<ShowDetails>) srepo.findById(Id).get();
//		System.out.println(showdetails);
		java.util.Optional<ShowDetails> showDetailsOptional = srepo.findById(Id);

		List<ShowDetails> showDetailsList = showDetailsOptional
		    .map(Collections::singletonList) 
		    .orElse(Collections.emptyList());
//		System.out.println(showDetailsList);
		return new ResponseEntity<List<ShowDetails>>(showDetailsList ,HttpStatus.OK);
		
	}
	
	@PostMapping("/movies")
	public ResponseEntity<?> Movies(@RequestParam String location,HttpSession session){
//		System.out.println();
//		System.out.println(location);
//		List<TheatreDetails1> theatres = trepo.findByDistrict(location);
//		System.out.println(theatres);
//		session.setAttribute("theatres", theatres);
//		session.setAttribute("userlocation", location);
		district=location;
//		System.out.println((String)session.getAttribute("userlocation"));
		return ResponseEntity.ok().body("done");
		
	}
	
	@GetMapping("/movieslist")
	public ResponseEntity<List> GetMovies(HttpSession session){
//		System.out.println("Hi");
//		System.out.println(session.getAttribute("userlocation"));
		return new ResponseEntity<List>(mrepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/usertheatreslist")
	public ResponseEntity<List> UserTheatres(HttpSession session){
//		System.out.println("hi12");
		String location = district;
//		System.out.println(location);
		List<TheatreDetails1> theatres = trepo.findByDistrict(location);
		
//		System.out.println(theatres);
		return new ResponseEntity<List>(theatres,HttpStatus.OK);
	}
	
	@PostMapping("/theatreId")
	public ResponseEntity<TheatreDetails1> GetTheatreId(@RequestParam Long Id){
//		System.out.println("thetre");
		theatreId = Id;
//		System.out.println(theatreId);
		return new ResponseEntity<TheatreDetails1>(trepo.getById(Id),HttpStatus.OK) ;
	}
	
	@PostMapping("/movieId")
	public ResponseEntity<MovieDetails> GetMovieId(@RequestParam Long Id) {
	    movieId = Id;
	    return new ResponseEntity<MovieDetails>(mrepo.findById(movieId).get(),HttpStatus.OK);
	}

	
	@PostMapping("/showId")
	public ResponseEntity<ShowDetails> GetShowId(@RequestParam Long Id){
		System.out.println("show");
		showId = Id;
//		System.out.println(showId);
		ShowDetails show = srepo.getById(Id);
		movieId=show.getProxyMovie();
		return new ResponseEntity<ShowDetails>(show,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/timeslot/{showId}")
	public LocalTime GetTime(@PathVariable Long showId){
//		System.out.println("timeslot");
//		System.out.println(showId);
		ShowDetails show = srepo.getById(showId);
		LocalTime timeSlot = show.getTimeSlot();
		return timeSlot;
	}
	
	@GetMapping("/theatredetails/{theatreId}")
	public List<String> GetTheatre(@PathVariable Long theatreId){
//		System.out.println("thetare");
		List<String>details = new ArrayList<>();
		
		TheatreDetails1 tdets = trepo.getById(theatreId);
		details.add(tdets.getTheatreName());
		details.add(tdets.getMetroLocation());
		details.add(tdets.getDistrict());
		
		return details;
	}
	
	@GetMapping("/moviedetails/{movieId}")
	public List<String> GetMovie(@PathVariable Long movieId){
//		System.out.println("movieId");
		List<String>details = new ArrayList<>();
		
		MovieDetails mdets = mrepo.getById(movieId);
		details.add(mdets.getMovieName());
		details.add(mdets.getLanguage());
		
		return details;
	}
	
	@GetMapping("/duration/{movieId}")
	public Duration GetDuration(@PathVariable Long movieId){
		MovieDetails mdets = mrepo.getById(movieId);
		return mdets.getDuration();
	}
	
	
	@GetMapping("/usershowlist")
	public ResponseEntity<List> Usershow(){
//		System.out.println("hello");
		System.out.println(theatreId);
		
		List<ShowDetails> showdetails = srepo.findByProxyTheatre(theatreId);
		
//		System.out.println(showdetails);
		return new ResponseEntity<List>(showdetails,HttpStatus.OK);
	}
	
	@PostMapping("/bookingdetails")
	public ResponseEntity<List> BookingDetails(@RequestParam String selectedDate,@RequestParam Integer selectedSeats,@RequestParam Long showId){
//		System.out.println(selectedDate);
//		System.out.println(selectedSeats);
//		System.out.println(showId);
		ShowDetails show = srepo.getById(showId);
		String movieId = String.valueOf(show.getProxyMovie());
		String theatreId = String.valueOf(show.getProxyTheatre());
		String Seats = Integer.toString( selectedSeats);
		String Id = Long.toString(showId);
//		List<String> list = new ArrayList();
		list.clear();
		list.add(selectedDate);
		list.add(Seats);
		list.add(Id);
		list.add(movieId);
		list.add(theatreId);
		
		return new ResponseEntity<List>(list,HttpStatus.OK);
	}
	
//	@PostMapping("/seatdetails")
//	public ResponseEntity<List> SeatDetails(@RequestBody SelectedSeatsData selectedseats){
//		List<String> seats = selectedseats.getSelectedseatsdata();
//		selectedseatsdata.addAll(seats);
//		System.out.println(selectedseatsdata);
//		return new ResponseEntity<List>(selectedseatsdata,HttpStatus.OK);
//	}
	@PostMapping("/seatdetails")
	public ResponseEntity<List<String>> seatDetails(@RequestBody List<String> selectedSeats) {
        // Process the selectedSeats list here
//        System.out.println("Selected Seats received on the backend:");
//        List<String> selectedseatsdata = new ArrayList<String>();
        selectedseatsdata.clear();
        selectedseatsdata.addAll(selectedSeats);
        System.out.println(selectedseatsdata);
//        selectedSeats.forEach(System.out::println);
//        System.out.println(selectedSeats);

        // You can store the list or perform other actions here

        return new ResponseEntity<List<String>>(selectedSeats, HttpStatus.OK);
    }
	
	@GetMapping("/data")
	public List<String> Seats(){
//		System.out.println("data");
		return selectedseatsdata;
	}
	
	@GetMapping("/data2")
	public List<String> Details(){
//		System.out.println("data2");
		return list;
	}
	
	@DeleteMapping("/deletemovie")
	public ResponseEntity<?> DeleteMovie(@RequestParam Long Id){
		System.out.println("hi");
		mrepo.deleteById(Id);
		return ResponseEntity.ok("success");
	}
//	
	@DeleteMapping("/deleteshow")
	public ResponseEntity<?> DeleteShow(@RequestParam Long Id){
		System.out.println("hi");
		srepo.deleteById(Id);
		return ResponseEntity.ok("success");
	}
//	
	@DeleteMapping("/deletetheatre")
	public ResponseEntity<?> DeleteTheatre(@RequestParam Long Id){
		System.out.println("hi");
		trepo.deleteById(Id);
		return ResponseEntity.ok("success");
	}
	
	

	
	
}

