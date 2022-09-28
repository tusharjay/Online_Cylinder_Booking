import React, { Component ,useState} from 'react'

export default class BookCylinder extends Component {

        

    constructor(props) {

        super(props);
        this.state={
            ammount:"890",
            deliveryDate:"",
            paymentType:"",
            book:{},
            success:"false"
        }
    }
       
   
    

    handleChange=(e) =>{
        let nm = e.target.name;
        let val =e.target.value;
        this.setState({[nm]:val});
    }

    // creating Rest API 
    submitReq =(e)=>{
        e.preventDefault();
        console.log(this.state);

        const reqData = {
            method : 'POST',
            headers : {
                'Content-Type': 'application/json'
            },
            // given attribute must match exactly with the entity property !
            body:JSON.stringify({
                ammount: this.state.ammount,
                deliveryDate: this.state.deliveryDate,
                paymentType:this.state.paymentType
             
            })
        } ;
        
        //console.log(this.state);

        fetch("http://localhost:8080/book/"+JSON.parse(sessionStorage.getItem("customer")).customerId,reqData)
        .then(resp => resp.json())
        .then(data =>this.setState({book:data , success : true}));
        alert("Booking Confirm");
    }
    


    render() {
        return (
            <div >
                   <div className="container"><br />
                    <h1 className="text-success
                      text-center">Book Cylinder </h1><br></br>

                    <div className="col-lg-8 m-auto d-block">

                        <form onSubmit={this.submitReq} className="bg-light" >
                          
                            <div class="form-group">
                                <label> Amount : </label>
                                <h2>₹ 890</h2>
                             </div>
                             <br></br>

                             <div className="form-group">
                                <label> Delivery Date: </label>
                                <input type="date" name="deliveryDate" className="form-control"  autocomplete="off" value={this.state.deliveryDate} onChange={this.handleChange} />
                            </div>
                            <br></br>
                            <div className="form-group">
                                <label> Payment Mode: </label><br></br>
                                <input type="radio" id="online" name="paymentType" className="" value="online" autocomplete="off" onChange={this.handleChange} />
                                <label for="online">Online Payment</label><br></br>
                                <input type="radio" id="offline" name="paymentType" className="" value="offline" autocomplete="off" onChange={this.handleChange} />
                                <label for="offline">Cash On Delivery</label><br></br>

                           </div>
                            <br></br>

{/* this must be dynamically fect from the database or sever side if u know how to do it plz do this !
                             <div className="form-group">
                                <label>Actual Delivery Date: </label>
                                <input type="date" name="actual_date" className="form-control"  autocomplete="off" />
                            </div>
                            <br></br>


                            <div className="form-group">
                                <label>Payment Methode: </label>
                                    <div className="container p-3">
                                        <select className="custom-select">
                                            <option name="cod" value={this.state.cod}>Cod</option>
                                            <option  name="netbanking" value={this.state.netbanking}>Net Banking </option>
                                            <option  name ="upi_id"  value={this.state.upi_id}> UPI Id </option>
                                        </select>
                                        <br/>
                                        <br/>
                                        <button className="btn btn-primary">Payment Link</button>
                                    </div>
                            </div>
                            <br/>
                            <input type="submit" value="Book"/>*/}
                            <input type="submit"  value="book" className="btn btn-success" /*onClick={this.submitReq}*/ />
                        </form>
                        <br/>
                        {/*
                        <p style={{display:this.state.success ? 'block':'none'}}> Customer with  details had been saved {this.state.book.book_id}</p>
                        */}
                    </div>
                </div>   
            </div>
        );
    }
}
