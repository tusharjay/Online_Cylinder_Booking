import React, { Component } from 'react'

export default class Complaint extends Component {

    constructor(props)
    {
        super(props)
        this.state={
            complaint:[]
        }
    }

    componentDidMount = ()=>{
        fetch("http://localhost:8080/allcomplain")
        .then(resp => resp.json())
        .then(data => {this.setState({complaint:data});
                                       // alert(this.state.complaint.length)  
                                      })
    }

    render() {
        return (
            <div>
             <br/>
                <p className="text-center">  All Complaint Details   </p>
                <table className="table table-bordered table-striped">
                    <tr>
                        <th colSpan={"2"}>
                            <h3>All Complaints  Details</h3>
                        </th>      
                    </tr>
                    <tr>
                        <th>Customer ID</th>
                        <th>Customer Name</th>
                        <th>Mobile Number</th>
                        <th>Complaint Date</th>
                        <th>Complaint Topic</th>
                        <th>Complaint Description</th>
                                    
                    </tr>
                    {
                      this.state.complaint.map(
                          obj =>{
                              return(
                                  <tr>
                                      <td> {obj.customer.customerId} </td>
                                      <td> {obj.customer.fullName} </td>
                                      <td> {obj.customer.mobileNumber} </td>
                                      <td> {obj.complaintDate} </td>
                                      <td>{obj.complainTopic}</td>
                                      <td>{obj.description}</td>
                                     
                                  </tr>
                        
                              )
                          }
                      )
                    }

                </table>
            </div>
        )
    }
}
