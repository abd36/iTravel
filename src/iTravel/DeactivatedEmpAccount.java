package iTravel;

import iTravel.EmployeeAccount;

public class DeactivatedEmpAccount {
    private final EmployeeAccount employees[];

    public DeactivatedEmpAccount(EmployeeAccount[] employees) {
        this.employees = employees;
    }

    public EmployeeAccount[] getEmployees() {
        return employees;
    }

}
