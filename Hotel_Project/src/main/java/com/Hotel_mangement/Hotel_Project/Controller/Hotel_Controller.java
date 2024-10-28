package com.Hotel_mangement.Hotel_Project.Controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Hotel_mangement.Hotel_Project.Hotel_Entity.Billing;
import com.Hotel_mangement.Hotel_Project.Hotel_Entity.Hotel;
import com.Hotel_mangement.Hotel_Project.Hotel_Entity.Login;
import com.Hotel_mangement.Hotel_Project.Hotel_Entity.OnlineFood;
import com.Hotel_mangement.Hotel_Project.Hotel_Entity.RoomDetails;
import com.Hotel_mangement.Hotel_Project.Hotel_Service.HotelService;
import com.Hotel_mangement.Hotel_Project.Hotel_Service.OnlineFoodService;
import com.Hotel_mangement.Hotel_Project.Hotel_Service.RoomDetailService;
@Controller
@Service
public class Hotel_Controller {
	@Value("${login.username}")
	private String userName;
	
	@Value("${login.password}")
	private String password;
			
	private HotelService theHotelService ;
	
	

	private OnlineFoodService theFoodService;
	
	private RoomDetailService theRoomDetailService;
	 
	

		public Hotel_Controller(HotelService theHotelService, OnlineFoodService theFoodService,RoomDetailService theRoomDetailService) {
		super();
		this.theHotelService = theHotelService;
		this.theFoodService = theFoodService;
		this.theRoomDetailService = theRoomDetailService;
		
	}

		@RequestMapping("/")
		public String Index(Model theModel)
		{
			Hotel theHotel = new Hotel();
			theModel.addAttribute("Mybooking",theHotel);
			theModel.addAttribute("updateList",theHotel);
			
			OnlineFood theOnlineFood = new OnlineFood();
			theModel.addAttribute("OrderFood",theOnlineFood);
			
			RoomDetails theRoomDetails = new RoomDetails();
			theModel.addAttribute("details",theRoomDetails);
			return "index";
			}
		
		@RequestMapping("/list")
		public String ListCustomer(Model theModel) {
			
			//get the Customer List from db
			List<Hotel> theHotel =theHotelService.findAll();
			
			theModel.addAttribute("Mybooking", theHotel );
			return "customer_list";
		}
		
		
//		
//		@RequestMapping("/saveData")
//		public String SaveDate(Model theModel, @ModelAttribute("Mybooking") Hotel theHotel,@ModelAttribute("details") RoomDetails theRoomDetails,@ModelAttribute("billing") Billing bil)
//		{
//			System.out.println("SaveDATA"+theHotel);
//			System.out.println(theRoomDetails);
//			theHotelService.save(theHotel);
//			List<RoomDetails> theroomdetails = theRoomDetailService.findAll();
//			LocalDate checkin = LocalDate.parse(theHotel.getCheck_in());
//			LocalDate checkout = LocalDate.parse(theHotel.getCheck_out());
//			long days = ChronoUnit.DAYS.between(checkin, checkout);		
//			
//			
//			float price=0;
//			for (Iterator iterator = theroomdetails.iterator(); iterator.hasNext();) {
//				RoomDetails roomDetails = (RoomDetails) iterator.next();
//				System.out.println("Database room type: "+roomDetails.getRoom_type());
//				System.out.println("Form room type: "+theRoomDetails.getRoom_type());
//				if(roomDetails.getRoom_type().equals(theRoomDetails.getRoom_type())){
//					price=roomDetails.getPrice();
//					break;
//				}
//				
//			}
//			
////			Billing bil = new Billing();
//			bil.setDays(days);
//			
//			float totalBill = days * theHotel.getGuest() * price ;
//			bil.setTotalBill(totalBill);
//			System.out.println("Final bill = "+totalBill);
//			System.out.println("Price="+price);
//			theModel.addAttribute("details",theRoomDetails);
////			System.out.println("Room Details" + theroomdetails);
//			theModel.addAttribute("Mybooking",theHotel);
//			theModel.addAttribute("billing",bil);
//			
//			
//			return "confirmBooking";
//		}
		@RequestMapping("/saveData")
		public String saveData(Model theModel, @ModelAttribute("Mybooking") Hotel theHotel, 
		                       @ModelAttribute("details") RoomDetails theRoomDetails, 
		                       @ModelAttribute("billing") Billing bil) {
		    // Logging to debug
		    System.out.println("SaveDATA: " + theHotel);
		    System.out.println(theRoomDetails);

		    // Save hotel booking information
		    theHotelService.save(theHotel);

		    // Calculate number of days between check-in and check-out
		    LocalDate checkin = LocalDate.parse(theHotel.getCheck_in());
		    LocalDate checkout = LocalDate.parse(theHotel.getCheck_out());
		    long days = ChronoUnit.DAYS.between(checkin, checkout);

		    // Find the room price based on room type
		    float price = 0;
		    List<RoomDetails> theroomdetails = theRoomDetailService.findAll();
		    for (RoomDetails roomDetails : theroomdetails) {
		        if (roomDetails.getRoom_type().equals(theRoomDetails.getRoom_type())) {
		            price = roomDetails.getPrice();
		            break;
		        }
		    }

		    // Calculate the total bill
		    bil.setDays(days);
		    float totalBill = days * theHotel.getGuest() * price;
		    bil.setTotalBill(totalBill);

		    // Logging to debug
		    System.out.println("Final bill = " + totalBill);
		    System.out.println("Price = " + price);

		    // Add attributes to the model for the view
		    theModel.addAttribute("details", theRoomDetails);
		    theModel.addAttribute("Mybooking", theHotel);
		    theModel.addAttribute("billing", bil);

		    // Forward to the confirmBooking view
		    return "confirmBooking";
		}

		
		@RequestMapping("/deleteCustomer")
		public String DeleteCustomer(@RequestParam("Id") int theId) {
			theHotelService.deleteById(theId);
			return "redirect:/list";
		}
		

		@RequestMapping("/addOrder")
		public String AddOrder(@ModelAttribute("OrderFood") OnlineFood theOnlineFood) {
			theHotelService.save(theOnlineFood);
			return "redirect:/foodlist";
		}
		
		@RequestMapping("/foodlist")
		public String FoodList(Model theModel) {
			List<OnlineFood> theOnlineFood = theFoodService.findAll();
			theModel.addAttribute("OrderFood",theOnlineFood);
			return "foodlist";
			
		}
		
		@RequestMapping("/return")
		public String ReturnHome(Model theModel) {
			Hotel theHotel = new Hotel();
			theModel.addAttribute("Mybooking",theHotel);
			return "redirect:/";
		}
		
		@RequestMapping("/deletefood")
		public String Delete(@RequestParam("Id") int theId) {
			theFoodService.deleteById(theId);
			return "redirect:/foodlist";
		}
		@RequestMapping("/returnFoodform")
		public String ReturnHomeIndex(Model theModel) {
			OnlineFood theOnlineFood = new OnlineFood();
			theModel.addAttribute("OrderFood",theOnlineFood);
			return "redirect:/";
		}
		
//		@RequestMapping("/updateData")
//		public String UpdateData(@RequestParam("Id")int theId, Model theModel) {
//		
//			Hotel theHotel = theHotelService.findById(theId);
//			
//			theModel.addAttribute("Mybooking",theHotel);
//			theHotel.setId(theId);
//			
//			return "updateForm";
//			
//		}
//	
		
	@RequestMapping("/showLogin")
		
		public String showLogin(Model theModel) {
			theModel.addAttribute("login" ,new Login());
			return "login";
		}
		
		@RequestMapping("/submitLogin")
		
		public String showList(@ModelAttribute("login") Login login, Model theModel) {
			
			System.out.println(login);
			System.out.println("username : "+userName + " Password:"+password);
			if(userName.equals(login.getUsername())) {
			
				List<Hotel> theHotel =theHotelService.findAll();
				
				theModel.addAttribute("Mybooking", theHotel );
				
				return "redirect:/list";
			
			
			}
			else {
				return "login";
			}
		}
		 
		
		@RequestMapping("/updateData")
		    public String showUpdateForm(@RequestParam("Id") int Id, Model theModel) {
		        Hotel theHotel = theHotelService.findById(Id);
		        theModel.addAttribute("MyBooking", theHotel);
		        return "updateForm"; // Return the view name where the form is shown
		    }

		    @RequestMapping("/saveUpdate")
		    public String saveUpdatedHotel(@ModelAttribute("MyBooking") Hotel theHotel) {
		    	theHotelService.updateHotel(theHotel.getId(), theHotel);
		        return "redirect:/list"; // Redirect to the list page after update
		    }

	}


