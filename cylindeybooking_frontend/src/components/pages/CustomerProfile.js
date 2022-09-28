import React, { Component } from 'react'
import {Table ,Button } from 'react-bootstrap'



export default class CustomerProfile extends Component {

    constructor(props)
    {
        super(props)
        this.state={
            error:null,
            customer:[]
        }

    }
    
    
    componentDidMount = ()=>{       
        fetch("http://localhost:8080/customer/"+JSON.parse(sessionStorage.getItem("customer")).customerId)
        .then(resp => resp.json())
        .then(
            (result)=>{
                this.setState({
                    customer:result
                })
            },
            (error) => {
                this.setState({error})
            }
        )
    }


   
    render() {
        const {error ,customers} = this.state;
        if(error)
        {
            return
            (
                <div>Error: {error.message}</div>
            )
        }
        else
        {
            return (
                <div>
                 <br/>
                    <p className="text-center">  Customers will be displayed here using rest API </p>
                    <Table /*className="table table-bordered table-striped"*/>
                    <thead>

                        <tr>
                            <th colSpan={"3"}>
                                <h3> Customer Details</h3>
                            </th>      
                        </tr>
                        <tr>
                            <th>Customer ID</th>
                            <th>Full Name</th>            
                            <th>Email</th>
                            <th>User Name</th>
                            <th>Contact</th>
                            <th>Address</th>
                            <th>City</th>               
                            <th>Aadhar Card</th>
                            <th>Connection Status</th>  
                            <th>Operation</th>          
                        </tr>
                    </thead>
                    
                             <tr >
                                <td> {this.state.customer.customerId} </td>
                                <td> {this.state.customer.fullName} </td>
                                <td> {this.state.customer.email} </td>
                                <td> {this.state.customer.userName} </td>     
                                <td> {this.state.customer.mobileNumber} </td>
                                <td> {this.state.customer.address} </td>
                                <td> {this.state.customer.city}   </td>                              
                                <td> {this.state.customer.aadharCard} </td>
                                <td> {this.state.customer.connectionStatus} </td>
                                <td> <Button style={{backgroundColor : "brown"}} varient="info" /*onClick={()=>this.props.editCustomer(obj.cid)}*/>Edit</Button></td>
                             </tr>

                       
                    </Table>
                </div>
            )
        }
 
    }
}