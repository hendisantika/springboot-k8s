package id.my.hendisantika.springbootk8s.service;

import id.my.hendisantika.springbootk8s.model.Department;
import id.my.hendisantika.springbootk8s.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 13.02
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department department) {

        Department existingDept = departmentRepository.findById(department.getId()).orElseThrow(() -> new RuntimeException("Department not found"));
        existingDept.setDeptName(department.getDeptName());
        return departmentRepository.save(existingDept);
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }


    public void deleteDepartment(Long deptId) {
        departmentRepository.deleteById(deptId);
    }
}
