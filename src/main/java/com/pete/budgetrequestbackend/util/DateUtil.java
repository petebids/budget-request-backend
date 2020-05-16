package com.pete.budgetrequestbackend.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

    public LocalDate getEndOfCurrentFinYearFromNow(LocalDate now){
        LocalDate endOfFinYearInThisCalendarYear = LocalDate.of(now.getYear() , 06, 30);
        if (now.isBefore(endOfFinYearInThisCalendarYear) || now.isEqual(endOfFinYearInThisCalendarYear)){
            return endOfFinYearInThisCalendarYear;
        }
        else{
            return LocalDate.of((endOfFinYearInThisCalendarYear.getYear()+1),endOfFinYearInThisCalendarYear.getMonthValue(), endOfFinYearInThisCalendarYear.getDayOfMonth());
        }
        
    }

    public LocalDate getStartOfMonthFromNow(LocalDate now){

        return LocalDate.of(now.getYear(), now.getMonthValue() , 1);

    }
    
    
}