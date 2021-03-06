import java.time.LocalDate;
import java.util.ArrayList;

public class Employee2 {
    private final String name;
    private final String surname;
    private String address;
    private String fonNumber;
    private final LocalDate birthDay;
    private double salary;

    public Employee2(String name, String surname, String address, String fonNumber, double salary, LocalDate birthDay) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.fonNumber = fonNumber;
        this.salary = salary;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public void setAddress(String address) {this.address = address;}
    public String getAddress() {
        return address;
    }
    public void setFonNumber(String fonNumber) {this.fonNumber = fonNumber;}
    public String getFonNumber() {
        return fonNumber;
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
}

interface HandleEmployee {
    void handleEmployee(Employee2 employee2);
}

class Company1 {
    public ArrayList<Employee2> employee2s = new ArrayList<>();

    public void addEmployee2s(Employee2 employee2s1) {
        employee2s.add(employee2s1);
    }

    public void show() {
        for(Employee2 i : employee2s ) {
            System.out.println(i.getName() + i.getSurname() + i.getAddress() + i.getFonNumber() + i.getSalary() + " " + i.getBirthDay());
        }
        System.out.println(" ");
    }

    public void clear() {
        for (int i = 0; i < employee2s.size(); i++) {
            if (employee2s.get(i).getSalary() < 10000) {
                employee2s.remove(i);
            }
        }
    }
}

class HandleEmployees implements HandleEmployee {
    public void handleEmployee(Employee2 employee2) {
        int solar = 25000;
        if (employee2.getSalary() < 20000) {
            employee2.setSalary(solar);
        }
    }
}

class Main {
    public static void main(String[] args) {
        String city = "Moscow";
        Company1 firm = new Company1();
        LocalDate time = LocalDate.of(1985, 7, 14);

        for(int i = 0; i < 30; i++) {
            firm.addEmployee2s(new Employee2("Vase ", "Pumpkin ", "Zapopan_36_k1 ", "+79257653379 ", 1 + Math.random() * 30000, time));
        }

        firm.show();
        firm.clear();
        firm.show();
        HandleEmployee handleEmploy;
        handleEmploy = (employee2s) -> employee2s.setAddress(city);
        for (Employee2 i: firm.employee2s) {
            if (i.getSalary() > 29000) {
                handleEmploy.handleEmployee(i);
            }
        }
        firm.show();

        new HandleEmployee() {
            @Override
            public void handleEmployee(Employee2 employee2) {
                for (Employee2 j: firm.employee2s) {
                    if (j.getSalary() > 23000 && j.getSalary() < 26000) {
                        j.setFonNumber("676470704");
                    }
                }
            }
        };
    }
}