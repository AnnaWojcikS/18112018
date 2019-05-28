package pl.sda.entity;

public class Company {

    private String companyName;
    private String companyAdress;
    private String companyCode;
    private String companyCity;

    public Company(String companyName, String companyAdress, String companyCode, String companyCity) {
        this.companyName = companyName;
        this.companyAdress = companyAdress;
        this.companyCode = companyCode;
        this.companyCity = companyCity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAdress() {
        return companyAdress;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getCompanyCity() {
        return companyCity;
    }
    public String getFullAdress(){
        return companyAdress + " " + companyCode + " " + companyCity;
    }
}
