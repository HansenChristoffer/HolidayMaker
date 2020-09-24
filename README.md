# Holiday Maker
This Project is a school-group-project written by
Stoffmeister Hansen
Olle Johansson
Frida Ek
Tanvir Siddique


## Table of contents
* [General info](#general-info)
* [Tech](#tech)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)


## General info
Holidaymakers should be a website where customers can book
holiday accommodation in a modern and simple way.
You can do complex searches for vacant accommodation based on several choices.
You can log in and book an accommodation, and see / change Already booked
accommodation.

## Technologies
* Springboot
* SQLite 3.32.x
* Java 14

## Setup
Setup and run this application on

 - Windows:
    cd [path-to-where-you-want-the-application-to-be-stored-without-the-brackets]
    * git clone https://github.com/ollejj/HolidayMaker
    * cd HolidayMaker
    * mvn spring-boot:run

    Access the server from http://localhost:8080/


## Code Examples

```
public List<Accommodation> getFilteredAccommodations(Filter filter) throws ParseException {
        Set<Accommodation> availableByDate = new HashSet<>();

        /**
         * These three nested for-each loops will check if the input filter
         * dates overlap the rooms taken dates. If the filter-dates overlap with
         * the rooms taken-dates it will return true. We check if the return is
         * false and add that accommodation with available dates to our
         * availableByDate List
         */
        for (Accommodation a : (filter.getLocation().equals("any") ? findAll() : findAccomodationsByLocationId(locationService.findLocationIdByName(filter.getLocation())))) {
            for (Room r : a.getRooms()) {
                for (ReservedDates rd : r.getReservedDates()) {
                    if (!rd.isOverlapping(
                            new SimpleDateFormat("dd/MM/yyyy").parse(filter.getDateFrom()),
                            new SimpleDateFormat("dd/MM/yyyy").parse(filter.getDateTo()))) {
                        availableByDate.add(a);
                    } else {
                        break;
                    }
                }
            }
        }

        /**
         * These anonymous functions returns true/false depending on the
         * statement. If the statement is true, the filter() function will pass
         * the object of
         * {@link com.group.foctg.holidayMaker.model.Accommodation} and be
         * appended to the List<Accommodation>
         */
        List<Accommodation> filtered = availableByDate.stream()
                .filter(a -> a.getDistanceToBeach() > filter.getMinDistBeach() && a.getDistanceToBeach() < filter.getMaxDistBeach())
                .filter(a -> a.getDistanceToCenter() > filter.getMinDistCenter() && a.getDistanceToCenter() < filter.getMaxDistCenter())
                .filter(a -> a.getPool() == true || filter.hasPool() == false)
                .filter(a -> a.getChildEvents() == true || filter.hasChildrenClub() == false)
                .filter(a -> a.getRestaurant() == true || filter.hasRestaurant() == false)
                .filter(a -> a.getNightEntertainment() == true || filter.hasNightEntertainment() == false)
                .filter(a -> a.getRooms().size() >= filter.getRooms())
                .collect(Collectors.toList());

        return filtered;
    }
```
  
  
  
  

## Features
List of features ready and TODOs for future development
* Filter all Accommodation objects
* Sort all Accommodation objects by rating
* Sort all Room objects by price
* Booking a Room
* Deleting a Booking
* Edit a Bookong
* Deleting an Accommodation
* Sign-in/Sign-up/Sign-out

## Status
Packed and Ready for Holidays!
