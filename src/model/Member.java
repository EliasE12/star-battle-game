package model;

// Class
public abstract class Member {

    // Atributes
    protected int age;
    protected int yearsService;

    // Constructor
    public Member(int age, int yearsService) {
        this.age = age;
        this.yearsService = yearsService;
    }

    // Methods
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsService() {
        return yearsService;
    }

    public void setYearsService(int yearsService) {
        this.yearsService = yearsService;
    }
}
