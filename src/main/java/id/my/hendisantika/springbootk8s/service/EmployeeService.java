package id.my.hendisantika.springbootk8s.service;

import id.my.hendisantika.springbootk8s.model.Department;
import id.my.hendisantika.springbootk8s.model.Employee;
import id.my.hendisantika.springbootk8s.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 13.03
 * To change this template use File | Settings | File Templates.
 */
@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    private EntityManager entityManager;

    @Transactional
    public Employee createEmployee(Employee employee, Long departmentId) {
        addEmployeeDept(employee, departmentId);
        return employeeRepository.save(employee);
    }

    @Transactional
    public void addEmployeeDept(Employee employee, Long departmentId) {
        Department department = entityManager.find(Department.class, departmentId);
        System.out.println("DEPARTMENT===> " + department.getDeptName());
        employee.setDepartment(department);
        entityManager.persist(employee);
    }

    public List<Employee> findByDepartmentDeptName(String departmentName) {
        return employeeRepository.findByDepartmentDeptName(departmentName);
    }

    public Employee updateEmployee(Employee employee) {
        Employee existingEmp = employeeRepository.findById(employee.getId()).orElseThrow(() -> new RuntimeException("Employee not found"));
        if (employee.getFirstName() != null) {
            existingEmp.setFirstName(employee.getFirstName());
        } else {
            existingEmp.setFirstName(existingEmp.getFirstName());
        }

        if ((employee.getLastName() != null)) {
            existingEmp.setLastName(employee.getLastName());
        } else {
            existingEmp.setLastName(existingEmp.getLastName());
        }

        if ((employee.getSalary() != 0)) {
            existingEmp.setSalary(employee.getSalary());
        } else {
            existingEmp.setSalary(existingEmp.getSalary());
        }

        return employeeRepository.save(existingEmp);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
