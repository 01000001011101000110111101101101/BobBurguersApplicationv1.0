package dev.lpa;

import java.util.Comparator;

public class Employee {
    public static class EmployeeComparator <T extends Employee>
            implements Comparator<Employee> {

        //PRIVATE ATTRIBUTE TO IT CALLED...
        private String sortType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }

        public int compare(Employee o1, Employee o2){
            if (sortType.equalsIgnoreCase("yearStarted")) {
                return o1.yearsStarted - o2.yearsStarted;
            }
            return o1.name.compareTo(o2.name);
        }
    }
    private int employeeId;
    private String name;
    private int yearsStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearsStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearsStarted = yearsStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearsStarted);
    }
}
