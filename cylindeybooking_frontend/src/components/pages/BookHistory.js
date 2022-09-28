import React, { Component } from 'react'
import {Table ,Button } from 'react-bootstrap'
import axios from 'axios'

export default class BookHistory extends Component {

    constructor(props)
    {
        super(props)
        this.state={

            error:null,
            book:[]
        }
    }

    componentDidMount = ()=>{
        fetch("http://localhost:8080/showbook/"+JSON.parse(sessionStorage.getItem("customer")).customerId)
        .then(resp => resp.json())
        .then(
            (result)=>{
                this.setState({
                    book:result
                })
            },
            (error) => {
                this.setState({error})
            }
        )
    }

    bookingCancel =(id)=>{

       const data= axios.get("http://localhost:8080/cancelbook/"+id)
        alert("Cancel Booking") 
         // this.setState({book:data});

      
    }


   
    render() {
        
        const {error ,book} = this.state;
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
                    <p className="text-center">  </p>
                    <Table /*className="table table-bordered table-striped"*/>
                    <thead>

                        <tr>
                            <th colSpan={"1"}>
                                <h3> Booking Details</h3>
                            </th>      
                        </tr>
                        <tr>
                            <th>Booking Id</th>
                            <th>Booking Date</th>
                            <th>Amount</th>
                            <th>Delivery Date</th>
                            <th>Pyment Type</th>
                            <th>Customer Name</th>
                            <th>Mobile Number</th>
                            <th>Address</th>
                            <th>Cylinder Type</th>
                            <th>Operation</th>
                                      
                        </tr>
                    </thead>
                    {book.map(obj =>(
                             <tr >
                                <td> {obj.bookingId} </td>
                                <td> {obj.bookingDate} </td>
                                <td> {obj.ammount}</td>
                                <td> {obj.deliveryDate} </td>
                                <td> {obj.paymentType} </td>
                                <td> {obj.customer.fullName} </td>
                                <td> {obj.customer.mobileNumber}</td>
                                <td> {obj.customer.address}</td>
                                <td> {obj.customer.cylinder.cylinderType} </td>

                                <td > <Button style={{backgroundColor : "brown"}} onClick={()=>this.bookingCancel(obj.bookingId)}>Cancel Booking</Button></td>
                             </tr>

                        ))}
                    </Table>
                </div>
            )
        }
 
    }
}