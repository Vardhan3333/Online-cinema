package com.example.OnlineCinemaTicketBookingSystemApplication1.Controller;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineCinemaTicketBookingSystemApplication1.Entity.Bookings;
import com.example.OnlineCinemaTicketBookingSystemApplication1.Entity.LoginForm;
import com.example.OnlineCinemaTicketBookingSystemApplication1.Entity.Seats;
import com.example.OnlineCinemaTicketBookingSystemApplication1.Entity.User;
import com.example.OnlineCinemaTicketBookingSystemApplication1.Repository.BookingsRepository;
import com.example.OnlineCinemaTicketBookingSystemApplication1.Repository.SeatRepository;
import com.example.OnlineCinemaTicketBookingSystemApplication1.Repository.UserRepository;
import com.google.common.base.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	SeatRepository srepo;
	
	@Autowired
	BookingsRepository brepo;
	
	@Autowired
	UserRepository urepo;
	
	@Autowired
	TheatreProxy tproxy;
	
	Long userId=0L ;
	Long bookingId;
	
	@PostMapping("/credentials")
	public ResponseEntity<String> Credentials(@RequestBody LoginForm loginform) {
	    if (loginform == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input.");
	    }

	    Long Id;
	    try {
	        Id = (loginform.getRegistrationId());
	    } catch (NumberFormatException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid registration ID format.");
	    }

	    String password = loginform.getPassword();

	    User user = urepo.findByRegistrationId(Id);
//	    System.out.println("hq");
	    
	    if (user == null || !user.getPassword().equals(password)) {
//	    	System.out.println("hq1");
	    	
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
	    } else {
	        // Determine the user's role and return it
	        String role = user.getRole(); // Assuming User entity has a 'role' field
	        userId = user.getUserId();
	        System.out.println(userId);
//	        System.out.println("hq2");
	        if ("user".equals(role)) {
//	        	System.out.println("hq3");
	        	String s = Long.toString( user.getRegistrationId());
	            return ResponseEntity.ok("user");
	        } else if ("admin".equals(role)) {
	        	System.out.println("hq4");
	            return ResponseEntity.ok("admin");
	        } else {
	        	System.out.println("hq5");
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown role.");
	        }
	    }
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> Register(@RequestBody User user){
		Random random = new Random();
        StringBuilder Id = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int digit = random.nextInt(10);
            Id.append(digit);
        }
        String number=Id.toString();
//        System.out.println(number);
        user.setRegistrationId (Long.parseLong(number));
        user.setRole("user");
        
        	urepo.save(user);
        
		return new ResponseEntity<String>(number,HttpStatus.OK);
	}
	
	@GetMapping("/Hi")
	public ResponseEntity<String> Hi(){
		
		return tproxy.Hi();
	}
	
	@PostMapping("/booking")
	public ResponseEntity<Bookings> Booking(@RequestParam String result){
		
//		Seats seatsnumber = new Seats();
		System.out.println("booking");
		System.out.println("hh");
		Bookings bookings = new Bookings();
		System.out.println(result);
		if(result.equals("success")) {
			List<String> Seatsdetails = new ArrayList<String>();
			
			List<String> Details = new ArrayList<String>();
			System.out.println("iam here");
			System.out.println(userId);
			User user = urepo.findById(userId).get();
			Seatsdetails.addAll(tproxy.Seats());
			System.out.println(Seatsdetails);
			List<Seats> seats22 = new ArrayList<Seats>();
//			for(String seat : Seatsdetails) {
//				seatsnumber.setSeat(seat);
//				seatsnumber.setUser(user);
//				seats22.add(seatsnumber);
//			}
//			System.out.println(seats22);
//			srepo.saveAll(seats22);
			
			for(int i =0;i<Seatsdetails.size();i++) {
				Seats seatsnumber = new Seats(); // Create a new Seats object for each seat
			    seatsnumber.setSeat(Seatsdetails.get(i));
			    seatsnumber.setUser(user);
			    srepo.save(seatsnumber);
			}
//			bookings.setSeatings(seatsnumber);
			Details.addAll(tproxy.Details());
			Long Id = Long.parseLong( Details.get(2));
			Long movieId = Long.parseLong( Details.get(3));
			Long theatreId = Long.parseLong( Details.get(4));
			Integer seats = Integer.parseInt(Details.get(1));
//			Date date = Date.parse(Details.get(0));
			bookings.setPaymentStatus("Payment Done");
			bookings.setBookingStatus("Booking Done");
			bookings.setSeats(seats);
			bookings.setSelectedSeats(Seatsdetails);
			bookings.setDate(Details.get(0));
//			System.out.println(userId);
			
			bookings.setUser(user);
			System.out.println("1");
			LocalTime timeSlot= tproxy.GetTime(Id);
			bookings.setTimeSlot(timeSlot);
			List<String> tmdetails = new ArrayList<String>();
			System.out.println("2");
			tmdetails.addAll(tproxy.GetTheatre(theatreId));
			bookings.setTheatreName(tmdetails.get(0));
			bookings.setMetroLocation(tmdetails.get(1));
			bookings.setDistrict(tmdetails.get(2));
			System.out.println("3");
			tmdetails.addAll(tproxy.GetMovie(movieId));
			bookings.setMovieName(tmdetails.get(3));
			bookings.setLanguage(tmdetails.get(4));
			System.out.println("4");
			Duration duration = tproxy.GetDuration(movieId);
			bookings.setDuration(duration);
//			System.out.println(Seatsdetails);
//			System.out.println(Details);
			brepo.save(bookings);
//			System.out.println(brepo.save(bookings));
			System.out.println("5");
			bookingId = (brepo.save(bookings)).getId();
			System.out.println(bookingId);
		}
		return new ResponseEntity<Bookings>(brepo.save(bookings),HttpStatus.OK);
	}
	
	@GetMapping("/ticket1/{Id}")
	public ResponseEntity<List> Ticket222(@PathVariable Long Id){
		Bookings bookings = brepo.findById(Id).get();
		List<String> seats = bookings.getSelectedSeats();
		return new ResponseEntity<List>(seats,HttpStatus.OK);
	}
	
	@GetMapping("/ticket")
//	public ResponseEntity<Bookings> Ticket(){
//		System.out.println("emaindhi");
//		System.out.println("bookings");
//		System.out.println(bookingId);
//		Bookings bookings = brepo.getById(bookingId) ;
//		System.out.println(bookings);
//		return new ResponseEntity<Bookings>(bookings,HttpStatus.OK);
//	}
	public ResponseEntity<List<Bookings>> Ticket(){
		if(userId!=0L) {
		
		System.out.println(userId);
		List<Bookings> list = brepo.findByUserUserId(userId);
		System.out.println(list);
		
		return new ResponseEntity<List<Bookings>>(list,HttpStatus.OK);}
		else {
			List<Bookings> list = new ArrayList<Bookings>();
			return new ResponseEntity<List<Bookings>>(list,HttpStatus.FORBIDDEN);
		}
				
	}
	
	@GetMapping("/userticket")
	public ResponseEntity<Bookings> Ticket(@RequestParam Long ticketId){
		System.out.println(ticketId);
		Bookings bookings = brepo.getById(ticketId) ;
		System.out.println(bookings);
		return new ResponseEntity<Bookings>(bookings,HttpStatus.OK);
	}
	
	@GetMapping("/userdetails")
	public ResponseEntity<User> user(){
		if(userId!=0L) {
		System.out.println(userId);
		User user = urepo.getById(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);}
		User user = new User(); 
		return new ResponseEntity<User>(user,HttpStatus.FORBIDDEN);
	}
	
	@DeleteMapping("/cancelticket")
	public ResponseEntity<?> CancelTicket(@RequestParam Long Id){
		brepo.deleteById(Id);
		return ResponseEntity.ok("done");
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> Logout(){
		
		userId=(userId-userId);
		System.out.println("userId is"+userId);
		return new ResponseEntity<String>("Successfull",HttpStatus.OK);
		
	}


}
