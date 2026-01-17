package id.my.hendisantika.springbootk8s.service;

import id.my.hendisantika.springbootk8s.model.Department;
import id.my.hendisantika.springbootk8s.model.Employee;
import id.my.hendisantika.springbootk8s.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
