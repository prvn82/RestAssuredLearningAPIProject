package makeseleniumeasy.com;

import com.google.gson.Gson;

import java.util.List;

public class GSONClassTest {

    public static void main(String[] args) {

        String samepl ="{\"companyCEO\":\"Amod\",\"companyHOCity\":\"Benagluru\",\"companyName\":\"MSE\",\"employees\":[{\"firstName\":\"Amod\",\"gender\":\"Male\",\"lastName\":\"Mahajan\",\"married\":true,\"salary\":10000.56,\"age\":28},{\"firstName\":\"Animesh\",\"gender\":\"Male\",\"lastName\":\"Prashant\",\"married\":false,\"salary\":20000.56,\"age\":30},{\"firstName\":\"Kitty\",\"gender\":\"Female\",\"lastName\":\"Gupta\",\"married\":false,\"salary\":30000.56,\"age\":26}],\"contractors\":[{\"contractFrom\":\"Jan-2019\",\"contractTo\":\"JAN-2025\",\"firstName\":\"Seema\",\"lastName\":\"Singh\"},{\"contractFrom\":\"Jan-2019\",\"contractTo\":\"JAN-2025\",\"firstName\":\"Seema\",\"lastName\":\"Singh\"}],\"companyPFDeails\":{\"pfName\":\"XYZ\",\"pfCity\":\"Benagluru\",\"pfYear\":2012,\"noOfEmployees\":10},\"supportedSalaryBanks\":[\"HDFC\",\"ICICI\",\"AXIS\"],\"pincodesOfCityOffice\":[560037,360034,456343]}";

        Gson gson = new Gson();
       mainJson em= gson.fromJson(samepl,mainJson.class);
        System.out.println("*****"+em.getContractors().get(0).getFirstName());

    }

}
