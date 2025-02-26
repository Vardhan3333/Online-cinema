package com.MovieApp.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MovieApp.Entity.Book;
import com.MovieApp.Entity.Login;
import com.MovieApp.Entity.Movie;
import com.MovieApp.Entity.Payment;
import com.MovieApp.Entity.ShowClass;
import com.MovieApp.Entity.ShowDetails;
import com.MovieApp.Entity.Theatre;
import com.MovieApp.Repo.BookRepo;
import com.MovieApp.Repo.PaymentRepo;
import com.MovieApp.Repo.UserRepo;
import com.MovieApp.Service.LoginService;
import com.MovieApp.Service.MovieService;
import com.MovieApp.Service.ShowService;
import com.MovieApp.Service.TheatreService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
public class MainController {
	
	@Autowired
	private TheatreService theatreService;
	

	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private LoginService userService;
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	private int userSession=0;
	
	@PostMapping("/reg")
	public int register(@RequestBody Login u) {
		userService.getRegister(u);
		return u.getLoginID();
	}
	
	@PostMapping("/userLogin")
	public ResponseEntity<String> userLogin(@RequestParam("loginID") int loginID,@RequestParam("password") String password) {
		
		
		System.out.print(loginID);
		Login u=ur.findById(loginID).orElse(null);
		
		System.out.println(u);
		if(userService.validateLogin(loginID,password).equals("success")) {	
			userSession=loginID;
			return ResponseEntity.status(200).body("Successfull");	
		}
		else if(userService.validateLogin(loginID,password).equals("Invalid")) {
			return ResponseEntity.status(200).body("Failed");
		
		}
		return ResponseEntity.status(200).body("");
	}	
	
	@PostMapping("/adminLogin")
    public String adminLogin(@RequestParam String emailId,@RequestParam String password) { 
        if ("admin@gmail.com".equals(emailId) && "admin123".equals(password)) {
            return "Successfull";
        } else {
            return "Failed";
        }
    }
	@GetMapping("/getTheatre")
	public List<Theatre> GetTheatre() {
		return theatreService.getTheatreDetails();
	}
	@GetMapping("/getTheatre/{theatreID}")
	public Theatre GetTheatreById(@PathVariable int theatreID) {
		return theatreService.findTheatre(theatreID);
	}
	@PostMapping("/saveTheatre")
	public ResponseEntity<String> saveTheatre(@RequestBody Theatre t){
		//System.out.println(t);
		theatreService.saveTheatre(t);
		return ResponseEntity.status(200).body("Successfull");
	}
	
	@PutMapping("/editTheatre/{theatreID}")
	public ResponseEntity<String> editTheatre(@PathVariable int theatreID,@RequestBody Theatre t) {
		
		Theatre td=theatreService.findTheatre(theatreID);
		if(t==null)
			return ResponseEntity.status(200).body("Failed");
		else {
		td.setDistrict(t.getDistrict());
		td.setLocationName(t.getLocationName());
		td.setNoOfShows(t.getNoOfShows());
		td.setReservationCapacityRegular(t.getReservationCapacityRegular());
		td.setSeatingCapacity(t.getSeatingCapacity());
		td.setTheatreName(t.getTheatreName());
		System.out.println(td);
		theatreService.saveTheatre(td);
		return ResponseEntity.status(200).body("Successfull");
		}
	}
	@DeleteMapping("/deleteTheatre/{theatreID}")
	public ResponseEntity<String> deleteTheatre(@PathVariable int theatreID){
		Theatre td=theatreService.findTheatre(theatreID);
		if(td==null)
			return ResponseEntity.status(200).body("Failed");
		else {
			theatreService.deleteTheatre(td);
			return ResponseEntity.status(200).body("Successfull");
		}
	}
	
	
	
	
	@GetMapping("/getMovie")
	public List<Movie> GetMovie() {
		return movieService.getMovieDetails();
	}
	@GetMapping("/getMovie/{movieID}")
	public Movie getMovieById(@PathVariable int movieID) {
		System.out.println(movieID);
		System.out.println(movieService.findMovie(movieID));
		return movieService.findMovie(movieID);
	}
	
	
	@PostMapping("/saveMovie")
	public ResponseEntity<String> saveMovie(@RequestBody Movie m){
		//System.out.println(t);
		movieService.saveMovie(m);
		return ResponseEntity.status(200).body("Successfull");
	}
	
	@PutMapping("/editMovie/{movieID}")
	public ResponseEntity<String> editMovie(@PathVariable String movieID,@RequestBody Movie m) {
		System.out.println("hi");
	 Integer movieId=Integer.parseInt(movieID);
		Movie md=movieService.findMovie(movieId);
		if(m==null)
			return ResponseEntity.status(200).body("Failed");
		else {
		md.setDuration(m.getDuration());
		md.setLanguage(m.getLanguage());
		md.setMovieName(m.getMovieName());
		md.setMovieID(movieId);
		System.out.println(md);
		movieService.saveMovie(md);
		return ResponseEntity.status(200).body("Successfull");
		}
	}
	@DeleteMapping("/deleteMovie/{movieID}")
	public ResponseEntity<String> deleteMovie(@PathVariable int movieID){
		Movie md=movieService.findMovie(movieID);
		if(md==null)
			return ResponseEntity.status(200).body("Failed");
		else {
			movieService.deleteMovie(md);
			return ResponseEntity.status(200).body("Successfull");
		}
	}
	
	@GetMapping("/getShow")
	public List<ShowDetails> GetShow() {
		return showService.getShowDetails();
	}
	
	@GetMapping("/getShow/{showID}")
	public ShowDetails GetShowById(@PathVariable int showID) {
		System.out.println(showService.findshow(showID));
		return showService.findshow(showID);
	}
	@PostMapping("/saveShow")
	public ResponseEntity<String> saveShow(@RequestBody ShowClass s,ShowDetails sd){
//		System.out.println(movieID);
//		System.out.println(theatreID);
		Movie m=movieService.findMovie(s.getMovieID());
		Theatre t=theatreService.findTheatre(s.getTheatreID());
		if(m==null||t==null) {
			return ResponseEntity.status(200).body("Failed");
		}
		sd.setPricePerSeat(s.getPricePerSeat());
		sd.setRegularSeats_available(s.getRegularSeats_available());
		sd.setTimeSlot(s.getTimeSlot());
		sd.setMovie(m);
		sd.setTheatre(t);
		System.out.println(sd);
		
		showService.saveShow(sd);
		return ResponseEntity.status(200).body("Successfull");
	}
	
	@PutMapping("/editShow/{showID}")
	public ResponseEntity<String> editShow(@PathVariable int showID,@RequestBody ShowDetails s) {
		
		ShowDetails sd=showService.findshow(showID);
		if(s==null)
			return ResponseEntity.status(200).body("Failed");
		else {
		sd.setPricePerSeat(s.getPricePerSeat());
		sd.setRegularSeats_available(s.getRegularSeats_available());	
		sd.setTimeSlot(s.getTimeSlot());
		System.out.println(sd);
		showService.saveShow(sd);
		return ResponseEntity.status(200).body("Successfull");
		}
	}
	@DeleteMapping("/deleteShow/{showID}")
	public ResponseEntity<String> deleteShow(@PathVariable int showID){
		ShowDetails sd=showService.findshow(showID);
		if(sd==null)
			return ResponseEntity.status(200).body("Failed");
		else {
			showService.deleteShow(sd);
			return ResponseEntity.status(200).body("Successfull");
		}
	}
	
	@PostMapping("Book/{showID}")
	public int book(@PathVariable int showID,@RequestParam int noOfTickets,HttpSession session){
		System.out.println(showID);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(noOfTickets);
		ShowDetails s=showService.findshow(showID);
//		int noOfTickets=book.getNoOfTickets();
		Book b=new Book();
		int uid=userSession;
//		if(s==null) {
//			return ResponseEntity.status(200).body("Failed");
//		}
//		else {
			b.setLoginID(uid);
			b.setNoOfTickets(noOfTickets);
			b.setMovieName(s.getMovie().getMovieName());
			b.setTheatreName(s.getTheatre().getTheatreName());
			b.setTheatreLocation(s.getTheatre().getLocationName());
			b.setCostPerTicket(s.getPricePerSeat());
			b.setTotalCost(noOfTickets*s.getPricePerSeat());
			b.setShowID(showID);
			bookRepo.save(b);
			System.out.println(b);
			
		return b.getBookID();
	//	}
		
	}
	
	@PostMapping("/getCost/{bookID}")
	public int getCost(@PathVariable int bookID) {
		Book b=bookRepo.findById(bookID).orElse(null);
		return b.getTotalCost();
		
	}
	@GetMapping("/print")
	public List<Book> print()
	{
//		Book book= bookRepo.findById(bookID).orElse(null);
		int loginID=userSession;
		System.out.print(bookRepo.findByLoginID(loginID));
		return bookRepo.findByLoginID(loginID);
	}
	
	@PostMapping("/payment")
	   public double payment(@RequestBody Payment p,@RequestParam double  totalCharges ){
		if(userSession==0) {
			return 0.00 ;
		}
		   Payment pay=new Payment();
		   p.setTotalCharges(totalCharges);
		   p.setRemainingBalance(p.getBalance()-p.getTotalCharges());
		   paymentRepo.save(p);
		   //ps.savingPaymentDetails(p);
		   return p.getRemainingBalance();
	   }
	@DeleteMapping("deleteBook/{bookID}")
	public ResponseEntity<String> deleteTicket(@PathVariable int bookID){
		
		Book sd=bookRepo.findById(bookID).orElse(null);
		if(sd==null)
			return ResponseEntity.status(200).body("Failed");
		else {
			bookRepo.deleteById(bookID);
			return ResponseEntity.status(200).body("Successfull");
		}
	}
	
	@GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
//		System.out.println("hi");
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();
//        }
//        return "redirect:/login"; // Redirect to the login page
		userSession=0;
		return ResponseEntity.status(200).body("Successfull");
    }
	
	
}
