package com.efsokli.birthday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Scanner;

/**
 *
 * @author froo
 */
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the Magical BirthDAY Calculator!");
        System.out.println();
        System.out.println("What's your birthday? (MM-dd-yyyy)");
        String dateString=sc.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate ld = LocalDate.parse(dateString, formatter);
        int year  = ld.getYear();
        int month  = ld.getMonthValue();
        int day  = ld.getDayOfMonth();
        System.out.println("That's means you were born on a "+ld.getDayOfWeek()+"!");
        LocalDate now = LocalDate.now();
        int thisYear  = now.getYear();
        
        if(month<10&&day<10){
            LocalDate thisYearsB = LocalDate.parse("0"+month+"-0"+day+"-"+thisYear, formatter);
            System.out.println("This year it falls on a  "+thisYearsB.getDayOfWeek()+"...");
            long numOfDaysBetween = ChronoUnit.DAYS.between(now,thisYearsB);
            System.out.println("And since today is "+formatter.format(now)+", there's only "+numOfDaysBetween+" more days until the next one!");
        }
        if(month<10&&day>9){
            LocalDate thisYearsB = LocalDate.parse("0"+month+"-"+day+"-"+thisYear, formatter);
            System.out.println("This year it falls on a  "+thisYearsB.getDayOfWeek()+"...");
            long numOfDaysBetween = ChronoUnit.DAYS.between(now,thisYearsB);
            System.out.println("And since today is "+formatter.format(now)+", there's only "+numOfDaysBetween+" more days until the next one!");
        }
        if(month>9&&day<10){
            LocalDate thisYearsB = LocalDate.parse(month+"-0"+day+"-"+thisYear, formatter);
            System.out.println("This year it falls on a  "+thisYearsB.getDayOfWeek()+"...");
            long numOfDaysBetween = ChronoUnit.DAYS.between(now,thisYearsB);
            System.out.println("And since today is "+formatter.format(now)+", there's only "+numOfDaysBetween+" more days until the next one!");
        }
       
        System.out.println("Bet yer excited to be turning "+(2020-year)+"!");
    }
}
