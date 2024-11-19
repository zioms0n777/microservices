import axios from 'axios'

const EMPLOYEE_SERVICE_BASE_URL = "http://localhost:9090/api/employee";

const EMPLOYEE_ID = 2;

class EmployeeService {
    getEmployee(){
        return axios.get(EMPLOYEE_SERVICE_BASE_URL + '/' + EMPLOYEE_ID);
    }
}

export default new EmployeeService