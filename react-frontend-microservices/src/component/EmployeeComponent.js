import React, { Component } from 'react'
import EmployeeService from '../service/EmployeeService';

export default class 
 extends Component {

    constructor(props)
    {
        super(props);

        this.state = {
            employeeDto: {},
            departmentDto:{},
            organizationDto:{}
        }
    }
    
componentDidMount()
{
    EmployeeService.getEmployee().then((response)=> {
     this.setState({employeeDto : response.data.employeeDto})
     this.setState({departmentDto : response.data.departmentDto})
     this.setState({organizationDto: response.data.organizationDto})   

     console.log(this.state.employeeDto)
     console.log(this.state.departmentDto)
     console.log(this.state.organizationDto)
    })
}

  render() {
    return (
      <div>
        <br/> <br/> <br/>
<div className='card col-md-7 offset-md-3'>
    <h3 className='text-center card-header'> View Employee Details</h3>
    <div className='card-body'>
        <div className='row'>
        <p><strong>Employee First Name: </strong>{this.state.employeeDto.firstName}</p>
        </div>
        <div className='row'>
        <p><strong>Employee Last Name: </strong>{this.state.employeeDto.lastName}</p>
        </div>
        <div className='row'>
        <p><strong>Employee Email: </strong>{this.state.employeeDto.email}</p>
        </div>
       
        <h3 className='text-center card-header'> View Department Details</h3>
        <div class='card-body'>
        <div className='row'>
        <p><strong>Department Name: </strong>{this.state.departmentDto.departmentName}</p>
        </div>
        <div className='row'>
        <p><strong>Department Description: </strong>{this.state.departmentDto.departmentDescription}</p>
        </div>
        <div className='row'>
        <p><strong>Department Code: </strong>{this.state.departmentDto.departmentCode}</p>
        </div>
        </div>
        <h3 className='text-center card-header'> View Department Details</h3>
        <div class = 'card-body'>
        <div className='row'>
        <p><strong>Organization Name: </strong>{this.state.organizationDto.organizationName}</p>
        </div>
        <div className='row'>
        <p><strong>Organization Description: </strong>{this.state.organizationDto.organizationDescription}</p>
        </div>
        <div className='row'>
        <p><strong>Organization Code: </strong>{this.state.organizationDto.organizationCode}</p>
        </div>
        </div>
    </div>
</div>
      </div>
    );
  }
}
