package Ticket_Booking_System;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TicketBookingSystem  {
//
//	Multiple users (threads) are trying to book tickets from the same pool — we must synchronize access to prevent overbooking.
	
	
	int avaibleTicket=10;
	private Object lock=new Object();
	public void ticketBooking(String user,int noOfTicket) {
		
		try {
			System.out.println(user+" "+"requird"+noOfTicket);
			synchronized (lock) {
				if(avaibleTicket>=noOfTicket) {
					avaibleTicket-=noOfTicket;
	                System.out.println("Tickets remaining: " + avaibleTicket);
				}else {
	                System.out.println("❌ Sorry " + user + ", not enough tickets available.");
				}
			}
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		TicketBookingSystem booking=new TicketBookingSystem();
		
		ExecutorService exeutor=Executors.newFixedThreadPool(3);
		
		exeutor.submit(()->{
			booking.ticketBooking("user-1", 3);
			booking.ticketBooking("user-2", 1);	
			booking.ticketBooking("user-3", 2);
			booking.ticketBooking("user-4", 1);
			booking.ticketBooking("user-5", 4);
			booking.ticketBooking("user-6", 3);
			booking.ticketBooking("user-7", 2);
			booking.ticketBooking("user-8", 2);
			booking.ticketBooking("user-9", 1);
			booking.ticketBooking("user-10", 2);
			booking.ticketBooking("user-11", 3);
			booking.ticketBooking("user-12", 5);
		});
		exeutor.shutdown();
		exeutor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(" All booking attempts completed.");

	}
}
