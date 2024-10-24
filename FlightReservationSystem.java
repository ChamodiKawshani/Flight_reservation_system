import java.util.*;

public class FlightReservationSystem {
    
    // Merge Sort implementation for sorting flight data
    public static void mergeSort(Flight[] flights, Comparator<Flight> comparator) {
        if (flights.length <= 1) {
            return;
        }
        
        int mid = flights.length / 2;
        Flight[] left = Arrays.copyOfRange(flights, 0, mid);
        Flight[] right = Arrays.copyOfRange(flights, mid, flights.length);
        
        mergeSort(left, comparator);
        mergeSort(right, comparator);
        
        merge(flights, left, right, comparator);
    }
    
    private static void merge(Flight[] flights, Flight[] left, Flight[] right, Comparator<Flight> comparator) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;
        
        while (leftIndex < left.length && rightIndex < right.length) {
            if (comparator.compare(left[leftIndex], right[rightIndex]) <= 0) {
                flights[resultIndex++] = left[leftIndex++];
            } else {
                flights[resultIndex++] = right[rightIndex++];
            }
        }
        
        while (leftIndex < left.length) {
            flights[resultIndex++] = left[leftIndex++];
        }
        
        while (rightIndex < right.length) {
            flights[resultIndex++] = right[rightIndex++];
        }
    }
    
    // Flight class representing flight information
    static class Flight {
        String flightNumber;
        String departure;
        String destination;
        int price;
        
        public Flight(String flightNumber, String departure, String destination, int price) {
            this.flightNumber = flightNumber;
            this.departure = departure;
            this.destination = destination;
            this.price = price;
        }
        
        @Override
        public String toString() {
            return "Flight " + flightNumber + " - " + departure + " to " + destination + " | Price: $" + price;
        }
    }
    
    // Example usage
    public static void main(String[] args) {
        // Sample flight data with 15 new records
        Flight[] flights = {
            new Flight("ABC123", "New York", "Los Angeles", 350),
            new Flight("DEF456", "Chicago", "San Francisco", 400),
            new Flight("GHI789", "Atlanta", "Dallas", 300),
            new Flight("JKL012", "Miami", "Seattle", 450),
            new Flight("MNO345", "Seattle", "Denver", 320),
            new Flight("PQR678", "Denvar", "Phoenix", 270),
            new Flight("STU901", "Orlando", "Orlando", 380),
            new Flight("VWX234", "San Diego", "Portland", 340),
            new Flight("NOP012", "San Francisco", "Las Vegas", 315),
            new Flight("YZA567", "Houston", "Minneapolis", 290),
            new Flight("BCD890", "Los Angeles", "Austin", 310),
            new Flight("EFG123", "Dallas", "Kansas City", 330),
            new Flight("HIJ456", "Las Vegas", "Indianapolis", 275),
            new Flight("KLM789", "Boston", "Nashville", 360),
            new Flight("QRS345", "Washington", "Miami", 410)
            
        };
        
        // Sort flights by price (ascending)
        mergeSort(flights, Comparator.comparingInt(flight -> flight.price));
        
        // Display sorted flights
        System.out.println("Sorted Flights by Price:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}