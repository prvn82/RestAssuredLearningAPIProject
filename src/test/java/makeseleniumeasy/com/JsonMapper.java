package makeseleniumeasy.com;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JsonMapper {


    public static void main(String[] args) {

        Map<String, Object> firstloop = new HashMap<>();
        firstloop.put("firstname","Amod");
        firstloop.put("additionalneeds","Breakfast");

        Map<String,String> bookingdates = new ConcurrentHashMap<>();
        bookingdates.put("checkin","2021-08-01");

        firstloop.put("bookingdates",bookingdates);



        Map<String, Object> firstloop2 = new HashMap<>();
        firstloop2.put("firstname","Pravee");
        firstloop2.put("additionalneeds","Lunch");

        Map<String,String> bookingdates2 = new ConcurrentHashMap<>();
        bookingdates2.put("checkin","2021-02-01");

        firstloop2.put("bookingdates",bookingdates2);

        List<Map> check = new ArrayList<>();
        check.add(firstloop);
        check.add(firstloop2);

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            //Convert Map to JSON
            String json = mapper.writeValueAsString(check);

            //Print JSON output
            System.out.println(json);
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
