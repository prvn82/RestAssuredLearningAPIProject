package makeseleniumeasy.com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class mainJsonTest {

    public static void main(String[] args) throws JsonProcessingException {

        mainJson json = new mainJson();
        companyPFDeails companyPFDeails = new companyPFDeails();
        companyPFDeails.setNoOfEmployees(10);
        companyPFDeails.setPfCity("Benagluru");
        companyPFDeails.setPfName("XYZ");
        companyPFDeails.setPfYear(2012);

        json.setCompanyPFDeails(companyPFDeails);

        List<contractors> contractorslist = new ArrayList<>();

        contractors contractors = new contractors();
        contractors.setContractFrom("Jan-2019");
        contractors.setContractTo("JAN-2025");
        contractors.setFirstName("Seema");
        contractors.setLastName("Singh");

        contractors contractors2 = new contractors();
        contractors2.setContractFrom("Jan-2019");
        contractors2.setContractTo("JAN-2025");
        contractors2.setFirstName("Seema");
        contractors2.setLastName("Singh");

        contractorslist.add(contractors);
        contractorslist.add(contractors2);

        json.setContractors(contractorslist);

        List<employee> employeeslist = new ArrayList<>();

        employee emp = new employee();
        emp.setFirstName("Amod");
        emp.setLastName("Mahajan");
        emp.setAge(28);
        emp.setGender("Male");
        emp.setMarried(true);
        emp.setSalary(10000.56);

        employee emp1 = new employee();
        emp1.setFirstName("Animesh");
        emp1.setLastName("Prashant");
        emp1.setAge(30);
        emp1.setGender("Male");
        emp1.setMarried(false);
        emp1.setSalary(20000.56);

        employee emp2 = new employee();
        emp2.setFirstName("Kitty");
        emp2.setLastName("Gupta");
        emp2.setAge(26);
        emp2.setGender("Female");
        emp2.setMarried(false);
        emp2.setSalary(30000.56);

        employeeslist.add(emp);
        employeeslist.add(emp1);
        employeeslist.add(emp2);

        json.setEmployees(employeeslist);

        List<String> supportedSalaryBanks = new ArrayList<>();
        supportedSalaryBanks.add("HDFC");
        supportedSalaryBanks.add("ICICI");
        supportedSalaryBanks.add("AXIS");

        json.setSupportedSalaryBanks(supportedSalaryBanks);

        List<Integer> pincodesOfCityOffice = new ArrayList<>();
        pincodesOfCityOffice.add(560037);
        pincodesOfCityOffice.add(360034);
        pincodesOfCityOffice.add(456343);

        json.setPincodesOfCityOffice(pincodesOfCityOffice);

        json.setCompanyCEO("Amod");
        json.setCompanyHOCity("Benagluru");
        json.setCompanyName("MSE");


        ObjectMapper mapper = new ObjectMapper();
        System.out.println( mapper.writeValueAsString(json));






    }
}
