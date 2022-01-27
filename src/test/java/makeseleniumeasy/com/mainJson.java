package makeseleniumeasy.com;

import java.util.List;

public class mainJson {

    public String getCompanyCEO() {
        return companyCEO;
    }

    public void setCompanyCEO(String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public String getCompanyHOCity() {
        return companyHOCity;
    }

    public void setCompanyHOCity(String companyHOCity) {
        this.companyHOCity = companyHOCity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<employee> employees) {
        this.employees = employees;
    }

    public List<makeseleniumeasy.com.contractors> getContractors() {
        return contractors;
    }

    public void setContractors(List<makeseleniumeasy.com.contractors> contractors) {
        this.contractors = contractors;
    }

    public companyPFDeails getCompanyPFDeails() {
        return companyPFDeails;
    }

    public void setCompanyPFDeails(companyPFDeails companyPFDeails) {
        this.companyPFDeails = companyPFDeails;
    }



    private String companyCEO;
    private String companyHOCity;
    private String companyName;
    private List<employee> employees;
    private List<contractors> contractors;
    private companyPFDeails companyPFDeails;

    public List<String> getSupportedSalaryBanks() {
        return supportedSalaryBanks;
    }

    public void setSupportedSalaryBanks(List<String> supportedSalaryBanks) {
        this.supportedSalaryBanks = supportedSalaryBanks;
    }

    public List<Integer> getPincodesOfCityOffice() {
        return pincodesOfCityOffice;
    }

    public void setPincodesOfCityOffice(List<Integer> pincodesOfCityOffice) {
        this.pincodesOfCityOffice = pincodesOfCityOffice;
    }

    private List<String> supportedSalaryBanks;
    private List<Integer> pincodesOfCityOffice;

}
