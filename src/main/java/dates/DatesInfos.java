package dates;

//timestamp - in Java is the number of milliseconds from 01.01.1970, 00:00 in the time zone +0:00 (GMT - Greenwich Mean Time - universal time)
//Poland is in the time zone +1:00 (CET - Central European Time or CEST - Central European Summer Time)
//so according to this time zone, the timestamp starts from 01.01.1970 01:00:00 CET.Timestamp with a negative value means "the number of milliseconds through 01.01.1970 0:00 GMT"

//Based on the timestamp, were created classes that wrap it and add methods that make it easier to work with dates

//basic format of dates - java.util.Date

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DatesInfos {

    //basic format of dates - java.util.Date
    //we create new data by 2 ways:
    //constructor without parameters - new Date() - creates an object containing the date and time - of constructor execution
    //constructor accepting a number - new Date(123L) - creates an object containing the date and time based on the given timestamp

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("Now date :" + date);

        long time = date.getTime();
        System.out.println("Time get from date " + time);

        Date date1 = new Date(1727175309789L);
        System.out.println("Date from timestamp :" + date1);

        //in class java.util.Date are methods: before(java.util.Date date) and after(java.util.Date date) that are used to check whether a date is before or after another date
        Date firstDate = new Date(1590264000000L);
        Date secondDate = new Date(1570270000000L);

        boolean before = firstDate.before(secondDate);
        System.out.println(before);

        boolean after = firstDate.after(secondDate);
        System.out.println(after);

        //formating of dates - SimpleDateFormat
        //we have to insert format, e.g. yyyy-MM-dd

        //Symbol Meaning
        //y year digit
        //M month digit
        //d day digit
        //h hour digit (1-12)
        //H hour digit (0-23)
        //m minute digit
        //s second digit
        //S millisecond digit
        //Z time zone (numeric) -> documentation https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.d H:m:ss:SS Z"); //we can add here instead of '.' ,  '-', or '/'
        System.out.println(simpleDateFormat.format(date2));

        //Date parsing
        //we need to create SimpleDateFormat object - giving it a pattern - and then use the parse(String dateAsString) method
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
            Date date3 = sdf1.parse("2024.01.02");
            System.out.println("First date: " + date3);

            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date date4 = sdf2.parse("25-10-2024 15:30");
            System.out.println("Second date: " + date4);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Date format in JDBC (part responsible for connecting in databases)  - java.sql.Date
        //does not store time, only date (day, month, year)

        //Creating a date object with JDBC
        //date used in JDBC does not have a parameterless constructor like in java.util.Date
        //to create the current date - we can create a java.util.Date - and use its timestamp to create a java.sql.Date

        //creating sql.Date from timestamp
        java.sql.Date sqlDate = new java.sql.Date(1540264000000L);
        System.out.println("Sql date: " + sqlDate);

        //creating actual date
        java.sql.Date sqlDateNow = new java.sql.Date(new java.util.Date().getTime());
        System.out.println("Sql date (now): " + sqlDateNow); // so util -> to sql
        System.out.println("Util date (now)" + new Date());

        //conversion between java.util.Date and java.sql.Date
        //sql -> to util
        java.util.Date dateUtil = sqlDateNow; //we put sql.Date to the util.Date variable
        System.out.println("Util date: " + dateUtil);

        Date parse = null; //we have to initialize here Date object - in case to print it - after block try-catch in which, we try to parse value
        SimpleDateFormat formatOfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            parse = formatOfDate.parse("25-10-2024 15:30:44");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Date parsed from string: " + parse);

        //Calendar
        //this class contains infos about calendar type (Gregorian, Japanese, Buddhist), time zone,date and time (default - object creation time)

        //TimeZone, Locale - using the Calendar we can often come across two other classes
        //TimeZone - class representing the time zone / its objects can be created using the default computer settings,based on the "country name" (Poland) or using the time zone designation adopted in Java (EST)
        //Locale - class representing the system's language/localization settings, including the default language and location (country)
        //Locale class objects can be created using the default computer settings, language and country codes (pl-PL) / or using predefined constants e.g. Locale.CHINESE)
        //You will get all the allowed time zone names by calling method - String[] TimeZone.getAvailableIDs()

        //creating time zones
        TimeZone timeZone1 = TimeZone.getDefault();
        TimeZone timeZone2 = TimeZone.getTimeZone("Poland");
        TimeZone timeZone3 = TimeZone.getTimeZone("EST");
        System.out.println("TimeZone #1: " + timeZone1.getDisplayName());
        System.out.println("TimeZone #2: " + timeZone2.getDisplayName());
        System.out.println("TimeZone #3: " + timeZone3.getDisplayName());

        // creating localization
        Locale locale1 = Locale.getDefault();
        Locale locale2 = Locale.CHINESE;
        Locale locale3 = Locale.forLanguageTag("pl-PL");
        System.out.println("Locale #1: " + locale1);
        System.out.println("Locale #2: " + locale2);
        System.out.println("Locale #3: " + locale3);

        // default calendar for system
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1);
        // calendar created on basis time zone passed as argument
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Poland"));
        System.out.println(calendar2);
        // calendar created on basis time zone of computer localization settings
        Calendar calendar3 = Calendar.getInstance(Locale.forLanguageTag("pl-PL"));
        System.out.println(calendar3);

        //calendar objects have many infos, but we can get from each separate infos
        //every calendar object has get(int field) method and we can get number representing a specific time unit
        //These units are defined in the Calendar class as constants (e.g. Calendar.YEAR)

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);

        //by java.util.Date getTime() / void setTime(java.util.Date date) ->  we can extract or set a date from the calendar
        System.out.println("--- CALENDAR TO DATE CONVERSION ---");
        Calendar calendar4 = Calendar.getInstance();
        Date dateFromCalendar = calendar4.getTime();
        System.out.println("DATE from CALENDAR" + dateFromCalendar);

        System.out.println("--- SETTING DATE IN CALENDAR ---");
        Calendar calendar5 = Calendar.getInstance();
        Date date3 = new Date(123546451234L);
        System.out.println("Date: " + date3); //
        calendar5.setTime(date3);
        System.out.println("Calendar: " + calendar2);

        //Date/time manipulation
        //add(int field, int amount) method - we can change saved date by given number (days, months, hours).
        //By entering negative number we subtract that unit from date

        Calendar calendar6 = Calendar.getInstance();

        System.out.println("--- 3 months later ---");
        calendar6.add(Calendar.MONTH, 3);
        System.out.println(calendar.getTime());

        System.out.println("--- 50 hours later ---");
        calendar.add(Calendar.HOUR, 50);
        System.out.println(calendar.getTime());

        System.out.println("--- 6 years ago ---");
        calendar.add(Calendar.YEAR, -6);
        System.out.println(calendar.getTime());

        //above described mechanisms are depricated , in java 8 were introduced new solution:
        //new types for storing time/date, divided according to 2 criteria:

        //type of stored data
        //Date - date only //Time - time only //DateTime - date + time

        //local or including time zone
        //Local - without time zone information - LocalDate / LocalTime / LocalDateTime
        //Zoned - with time zone information - ZonedDateTime

        //LocalDate - date with ISO format  yyyy-MM-dd
        //Since LocalDate only stores the date in a specific format, creating objects is much simpler:
        //LocalDate.now() - current date
        //LocalDate.of(int year, int month, int day) - date given as year-month-day numbers
        //LocalDate.parse(String date) - date given as ISO format ("2019-05-25")

        //date from now()
        LocalDate localDate1 = LocalDate.now();
        System.out.println("Local date #1: " + localDate1);
        // date from number
        LocalDate localDate2 = LocalDate.of(2019, 5, 25);
        System.out.println("Local date #2: " + localDate2);
        // date from text
        LocalDate localDate3 = LocalDate.parse("2019-06-13");
        System.out.println("Local date #3: " + localDate3);

        //Modifying Dates
        //we can also add or subtract a specific number of time units using LocalDate

        //Dates introduced in Java 8 are immutable. Similar to Strings, any "modification" of a date creates a new modified date
        //passing a negative value to any plus...() method will not decrement the date (e have to remember to assign it to a new or existing variable)

        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.plusDays(3));
        System.out.println(now.minusDays(3));
        System.out.println(now.plusMonths(3));

        //ChronoUnit
        //with methods of the LocalDate class we can use time units from ChronoUnit - class which was created to representing constamts units (e.g. ChronoUnit.YEARS)
        //LocalDate plus(long amountToAdd, TemporalUnit unit)
        //LocalDate minus(long amountToAdd, TemporalUnit unit)

        LocalDate now1 = LocalDate.now();
        now1.plus(2, ChronoUnit.YEARS);
        now1.minus(2, ChronoUnit.DAYS);

        //Period
        //special class representing the period - interval between two dates expressed as a difference in years, days, weeks and months
        //LocalDate has methods that allow to modify date using periods

        //public LocalDate plus(TemporalAmount amountToAdd)
        //public LocalDate minus(TemporalAmount amountToAdd)

        //asTemporalAmount we can pass an object of class Period
        Period period = Period.of(1, 2, 3);
        LocalDate parse1 = LocalDate.parse("2023-07-20");
        LocalDate parse2 = LocalDate.parse("2024-09-30");
        Period between = Period.between(parse1, parse2);
        System.out.println(between);

        LocalDate now2 = LocalDate.now();
        LocalDate plusPeriod = now2.plus(between);
        System.out.println(plusPeriod);

        LocalDate minusPeriod = now2.minus(period);
        System.out.println(minusPeriod);

        //LocalTime - object only with hour, minute, second - without time zone information
        //creating LocalTime objects
        LocalTime now3 = LocalTime.now();
        System.out.println(now3);
        LocalTime parse3 = LocalTime.parse("01:20:34");
        System.out.println(parse3);

        //time modification
        LocalTime now4 = LocalTime.now();
        System.out.println(now4);

        System.out.println(now4.plusHours(3));
        System.out.println(now4.plusMinutes(30));
        System.out.println(now4.plus(5, ChronoUnit.HOURS));

        //LocalDateTime
        //combination of LocalDate and LocalTime - so that class stores date and time without time zone
        LocalDateTime now5 = LocalDateTime.now();
        System.out.println(now5);
        LocalDateTime parse4 = LocalDateTime.parse("1984-05-20T12:05:34");
        System.out.println(parse4);
        Period period1 = Period.ofYears(1);
        LocalDateTime plus = parse4.plus(period1);
        System.out.println(plus);
        LocalDateTime localDateTime = parse4.plusMonths(5);
        System.out.println(localDateTime);

        //ZonedDateTime - date + time with time zone information
        ZonedDateTime now6 = ZonedDateTime.now();
        System.out.println(now6);
        //actual in given zone
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("Poland"));
        System.out.println(zonedDateTime2);
        //parsed for given zone
        LocalDateTime parse5 = LocalDateTime.parse("2023-05-23T17:20:50");
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(parse5, ZoneId.of("Japan"));
        System.out.println(zonedDateTime3);

        //Modifications - time zone change
        //ZonedDateTime class has all methods of LocalDateTime.Most important difference is time zone modification

        //e.g. when we are flying out of Warsaw on 22.05.2019 at 15:00, to Tokyo for 7 hours. What time and what date will be in Tokyo?
        //ZonedDateTime can be changed to another time zone at the same time, you can use the ZonedDateTime withZoneSameInstant(ZoneId zoneId) method:
        LocalDateTime localDepartureTime = LocalDateTime.parse("2024-09-30T15:00:00");
        ZoneId departureZone = ZoneId.of("Europe/Warsaw");
        ZonedDateTime departureTime = ZonedDateTime.of(localDepartureTime, departureZone);
        System.out.println("Date and time of departure in the polish time zone: " + departureTime);

        ZonedDateTime arrivalTime = departureTime.plusHours(7);
        System.out.println("Date and time of arrival in Poland time zone: " + arrivalTime);

        ZonedDateTime arrivalTimeTokyo = arrivalTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Date and time of arrival in Japan time zone " + arrivalTimeTokyo);

        //Date formatting
        //Java 8 introduced the DateTimeFormatter - equivalent of the SimpleDateFormat
        //difference is that new "formatter" can work with new time types (ZonedDateTime, LocalDateTime), so we can present date as text in a specific format or parse it from text to objects

        //date formatting
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Actual date (default format): " + zonedDateTime);
        System.out.println("Actual date (format dd.MM.yyyy hh:mm): " + dtf1.format(zonedDateTime)); //we put here format

        //date parsing - with a ready formatter(yyyy-MM-ddThh:mm)
        DateTimeFormatter dtf2 = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTimeParsed = LocalDateTime.parse("2024-09-24T18:20", dtf2);
        System.out.println("Parsed LocalDateTime: " + localDateTimeParsed);

        //date parsing - own formatter with given date
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm")
                .withZone(ZoneId.of("Europe/Warsaw"));
        ZonedDateTime zonedDateTimeParsed = ZonedDateTime.parse("10/25/2019 18:20", dtf3);
        System.out.println("Parsed ZonedDateTime: " + zonedDateTimeParsed);
    }
}

