import java.util.*;
import java.time.LocalDate;
public class Hotel_System {
    
    public class Customer{
        public String name;
        public int age;

        public Customer(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public String getName()
        {
            return name;
        }
        public int getAge()
        {
            return age;
        }
        public void setName(String name)
        {
            this.name = name;
        }
        public void setAge(int age)
        {
            this.age = age;
        }

        public String getCustomerDetails()
        {
            return "Name: " + name + " | " + "Age: " + age;
        }
    }

    public class RoomDetails
    {
        int roomNo;
        String category;
        boolean availability;
        double price;

        public RoomDetails(int roomNo, String category, double price)
        {
            this.roomNo = roomNo;
            this.category = category;
            this.availability = true;;
            this.price = price;
        }
        public int getRoomNo()
        {
            return roomNo;
        }
        public String getCategory()
        {
            return category;
        }
        public boolean getAvailability()
        {
            return availability;
        }
        public void setAvailability(boolean available)
        {
            availability = available;
        }
        public double getPrice()
        {
            return price;
        }

        public String getRoomDetails()
        {
            return "Room No: " + roomNo + " | " + "Category: " + category + " | " + "Price: Rs. " + price;
        }
    }

    public class BookingService
    {
        private Customer customer;
        private RoomDetails roomDetails;
        private LocalDate dateOfBooking;
        //private PaymentService payment;

        public BookingService(Customer customer, LocalDate dateOfBooking, RoomDetails roomDetails)
        {
            this.customer = customer;
            this.roomDetails = roomDetails;
            this.dateOfBooking = dateOfBooking;
            //this.payment = payment;
        }
        public Customer getCustomer()
        {
            return customer;
        }

        public RoomDetails getRoom()
        {
            return roomDetails;
        }

        public LocalDate getDateOfBooking()
        {
            return dateOfBooking;
        }

        // public PaymentService getPayment()
        // {
        //     return payment;
        // }
        public String getBookingDetails()
        {
            return customer.getCustomerDetails() + "\n" + "Date Of Booking: " + dateOfBooking + "\n" + roomDetails.getRoomDetails() + "\n"; 
            
            //+ "Payment Status: " + 
            //(payment.getPaymentStatus() ? "Paid" : "Pending");
        }
    }

    public class PaymentService
    {
        private String modeOfPayment;
        private boolean status;

        public PaymentService(String modeOfPayment)
        {
            this.modeOfPayment = modeOfPayment;
            this.status = false;
        }

        public boolean getPaymentStatus()
        {
            return status;
        }

        public void processPayment()
        {
            System.out.println("Processing payment through " + modeOfPayment);
            this.status = true;
            System.out.println("Successfully Paid!");
        }

        
    }
    public class HotelReservation
    {
        public static List<BookingService> bookings;
        public static List<RoomDetails> rooms;

        public HotelReservation()
        {
            rooms = new ArrayList<RoomDetails>();
            bookings = new ArrayList<BookingService>();
            initializeRooms();
        }

        public void initializeRooms()
        {
            rooms.add(new RoomDetails(200, "Single", 500.00));
            rooms.add(new RoomDetails(201, "Standard Double", 650.00));
            rooms.add(new RoomDetails(202, "Standard Twin", 720.00));
            rooms.add(new RoomDetails(203, "Deluxe", 950.00));
            rooms.add(new RoomDetails(204, "Suite", 1150.00));
            rooms.add(new RoomDetails(300, "Executive Suite", 1500.00));

        }
        
        public BookingService Reservation(Customer customer, LocalDate bookingDate, String category)
        {   
            for(RoomDetails room : rooms)
            {
                if(category.equals(room.getCategory()) && room.getAvailability() == true)
                {
                    room.setAvailability(false);
                    BookingService bs = new BookingService(customer, bookingDate, room);

                    bookings.add(bs);
                    System.out.println("Room Successfully Booked!" + " | " + "Your Room No: " + room.getRoomNo());
                    return bs;
                }
            }  
            System.out.println("Please select an available Room...\n");
            return null;
        }

        public List<BookingService> getBookings()
        {
            return bookings;
        }

        public void getAvailableRooms()
        {
            //HotelReservation hr = new HotelReservation();
            for(RoomDetails room : rooms)
            {
                System.out.println("Category: " + room.getCategory() + " | " + "Room No: " + room.getRoomNo() + " | " + "Availability: " + room.getAvailability());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Hotel_System hotel = new Hotel_System();
        HotelReservation reserve = hotel.new HotelReservation();
        do
        {
            System.out.println("");
            System.out.println("--------------------------------- HOTEL SYSTEM ---------------------------------");
            //System.out.println("Welcome to our Esteemed Hotel Establishment! We strive to tend to your convenience!");
            System.out.println("Choose one of the following actions: ");
            //System.out.println("1. Customer Registration");
            System.out.println("1. Room Reservation");
            System.out.println("2. View Available Rooms");
            System.out.println("3. View Current Bookings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1:
                System.out.println("");
                System.out.println("~~~ Customer Registration ~~~");

                String name;
                int age;
                
                System.out.print("Enter name of customer: ");
                name = sc.nextLine();
                sc.nextLine();
                System.out.print("Enter age of customer: ");
                age = sc.nextInt();
                sc.nextLine();

                Customer customer = hotel.new Customer(name, age);
                System.out.println("Customer "+ name + " registered Successfully!\n" );
                LocalDate date = LocalDate.now();
                
                System.out.println("~~~ Room Reservation ~~~");
                System.out.println("Choose the desired Room Category: \n");
                reserve.getAvailableRooms();
                String option = sc.nextLine();
                //sc.nextLine();

                System.out.println("Enter Payment Method: (Credit Card, Debit Card, Google Pay, Paytm)");
                String paymentMethod = sc.nextLine();
                reserve.Reservation(customer, date, option);
                PaymentService pay = hotel.new PaymentService(paymentMethod);
                pay.processPayment();                
                
                System.out.println("");
                break;
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 2:
                System.out.println("");
                System.out.println("View Available Rooms: ");
                reserve.getAvailableRooms();
                System.out.println("");
                break;
// //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 3:
                System.out.println("");
                System.out.println("View Current Bookings: \n");
                System.out.println("----------------------------------------------------------------");
                List<BookingService> bookings = reserve.getBookings();
                if(bookings.isEmpty())
                {
                    System.out.println("No Bookings found...");
                }
                else
                {
                    for(BookingService booking : bookings)
                    {
                        System.out.println(booking.getBookingDetails());
                        System.out.println("----------------------------------------------------------------");
                    }
                }
                System.out.println("");
                break;
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            }
        }
        while(choice != 0);

        sc.close();
        System.out.println("Hotel System Application Successfully Closed");
    }
};
