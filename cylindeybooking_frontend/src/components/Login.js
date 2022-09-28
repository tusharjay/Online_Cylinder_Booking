import React from 'react';
import './Login.css';
import mystore1 from './Store1';



export default class Login extends React.Component {

    constructor(props) {
        super(props);
        this.state =
        {
            userName: "",
            password: "",
            customer: {},
            distributer: {},
            admin: {},
            msg:"",
            loginerror: ""

        }
    }


    handleChange = (e) => {

        const input = e.target;
        const nm = input.name;
        const val = input.value;
        this.setState({ [nm]: val });
    }




    submitData = (e) => {
        e.preventDefault();
        /* alert("form is getting submitted ");
         console.log(this.state);*/

        const reqData =
        {
            method: 'POST',
            headers:
            {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'*'
            },
            body: JSON.stringify
                ({
                    //this must matches with the entity entered in springboot
                    userName: this.state.userName,
                    password: this.state.password,
                   // role:
                })
        }

        fetch("http://localhost:8080/login", reqData)
            .then(resp => resp.text())
            .then(data => {
                if (data.length != 0) 
                {
               
                    sessionStorage.setItem("customer",data)
                    console.log(data)
                        const json = JSON.parse(data);
                         // var response = JSON.parse(data);
                         // console.log(response['role']);
                        if (json.login_tbl.role == "Customer") {
                            this.setState({ customer: json });
                            localStorage.setItem("loggedinuser", JSON.stringify(this.state.customer));
                            //session Storage
                            mystore1.dispatch({ type: 'LOGGEDIN' })
                            this.props.history.push("/customerhome")
                        }
                        else if (json.login_tbl.role == "Distributor") {
                            this.setState({ distributer: json });
                            localStorage.setItem("loggedinuser", JSON.stringify(this.state.distributer));
                            //session Storage
                            mystore1.dispatch({ type: 'LOGGEDIN' })
                            this.props.history.push("/distributerhome")
                        }
                        else if (json.login_tbl.role == "Admin")
                        {
                            this.setState({ admin: json });
                            localStorage.setItem("loggedinuser", JSON.stringify(this.state.admin));
                            //session Storage
                            mystore1.dispatch({ type: 'LOGGEDIN' })
                            this.props.history.push("/adminhome")
                        }
                }  
                else 
                {
                    this.setState({ loginerror: "wrongId/pwd" });
                }
     
            }
            )}
        
        
            customerForm = ()=>{
                this.props.history.push("/CustomerForm");
            }

            distributorForm = ()=>{
                this.props.history.push("/DistributerForm");
            }
            
           
            
            forgetForm = ()=>{
                this.props.history.push("/Forgot");
            }


    render(){

        return (
            <div >
            <div className="Form my-5 mx- 3 " >
                <div className="container " >
                    <div className="row no-gutters " style={{ padding: "10px" }}>
                        <div className="col-lg-5 my-16 p-12">
                            <img src="./images/ucopy.jpg" className="img-fluid" style={{ marginTop: "15px" }} alt="Image Cylinder" />
                        </div>
                        <div className="col-lg px-5">
                            <h1 className="font-weight-bold py-3"> Welcome to E-Gas-Booking  </h1>
                            <h4> Sign into your account </h4>
                            <form >
                                <div className="form-row">
                                    <div className="col-lg-7">
                                        <input type="text" name="userName" placeholder="username" className="form-control my-2 p-2"  ref="user" value={this.state.userName} onChange={this.handleChange} /><span className="text-danger font-weight-bold "></span>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div className="col-lg-7">
                                        <input type="password" name="password" placeholder="******" className="form-control my-2 p-2 "  ref="password" value={this.state.password} onChange={this.handleChange} /><span className="text-danger font-weight-bold"></span>
                                    </div>
                                </div>
                                <br/>
                                <div className="form-row">
                                    <div className="col-lg-6">
                                        <input type="submit" name="login" value="Login" className="btn btn-success" onClick={this.submitData} />
                                    </div>
                                </div>
                                <br />
                                <button className="btn btn-warning" onClick={this.forgetForm} >Forget password </button><span> </span>
                                <br />
                                <br/>
                                <p style={{color:"darkred"}}>Dont have an account ? &nbsp;
                                    <button className="btn btn-info" onClick={this.customerForm}>Customer Registration</button>&nbsp;
                                    <button className="btn btn-info" onClick={this.distributorForm}>Distributor Registration</button> 
                                </p>
                            </form>
                            <br/>
                            <p>{this.state.loginerror}</p>
                        </div>
                    </div>
                </div>
            </div>
            </div >
        );
    }
}





