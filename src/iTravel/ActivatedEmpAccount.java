package iTravel;

import iTravel.EmployeeAccount;


public class ActivatedEmpAccount {
    private final EmployeeAccount employeeAccount;

    public EmployeeAccount getEmployeeAccount() {
        return employeeAccount;
    }

    public ActivatedEmpAccount(EmployeeAccount employeeAccount) {
        this.employeeAccount = employeeAccount;
    }
}
