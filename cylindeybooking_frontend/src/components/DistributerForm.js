import React from "react";

export default class DistributerForm extends React.Component {

    constructor(props) {
        super(props);
        this.state={
            fullName:"",
            userName:"",
            password:"",
            email:"",
            mobileNumber:"",
            aadharCard:"",
            licenseNumber:"",
            address:"",
            city:"",
            distributor:{},
            success:"false",
            
           
            
            errors:{
                fullNameerror:"",
                userNameerror:"",
                passworderror:"",
                emailerror:"",
                mobileNumbererror:"",
                aadharCarderror:"",
                licenseNumbererror:"",
                addresserror:"",
                cityerror:"", 
               
            },
            fullNamevalid:false,
            userNamevalid:false,
            passwordvalid:false,
            emailvalid:false,
            mobileNumbervalid:false,
            aadharCardvalid:false,
            licenseNumbervalid:false,
            addressvalid:false,
            cityvalid:false,
            formvalid:false
        }

    }
     
    handleChange = (e)=>{

       const input = e.target;
       const nm = input.name;
       const val = input.value;
       let errors =this.state.errors;
       let fullNameflag = this.state.fullNamevalid;
       let userNameflag = this.state.userNamevalid;
       let passwordflag =this.state.passwordvalid;
       let emailflag= this.state.emailvalid
       let mobileNumberflag = this.state.mobileNumbervalid;
       let aadharCardflag = this.state.aadharCardvalid;
       let licenseNumberflag = this.state.licenseNumbervalid;
       let addressflag = this.state.addressvalid;
       let cityflag = this.state.cityvalid;

       switch(nm)
       {
           case 'fullName':
            if((val.length <= 2)||(val.length > 20))
            {
                errors.fullNameerror="***name length must be between 2 and 20 ";
                fullNameflag=false;
            }
            else if (val=== "") 
            {
                errors.fullNameerror="***Please fill the namename field ";
                fullNameflag=false;
            }  
            else if (!isNaN(val))
            {
                errors.fullNameerror="***only characters are allowed ! ";
                fullNameflag=false;
            } 
            else
            {
                errors.fullNameerror="";
                fullNameflag=true;
            }
            break;

            
            case 'userName' :

                if((val.length <= 2)||(val.length > 20))
                {
                    errors.userNameerror="***name length must be between 2 and 20 ";
                    userNameflag=false;
                }
                else if (val=== "") 
                {
                    errors.userNameerror="***Please fill the namename field ";
                    userNameflag=false;
                }  
                else
                {
                    errors.userNameerror="";
                    userNameflag=true;
                }
                break;

                
                case 'password':
                    if(val === "")
                    {
                        errors.passworderror="***Please fill the password field ";
                        passwordflag=false;
                    }
                    else if((val.length <= 5)||(val.length > 8))
                    {
                        errors.passworderror="***passwords length must be between 5 and 8  ";
                        passwordflag=false;
                    }
                
                    else
                    {
                        errors.passworderror="";
                        passwordflag=true;
        
                    }
                    break;
        
            case'email':
            if(val.indexOf('@') <= -1)
            {
                errors.emailerror="***@ symbol is required email id ! ";
                emailflag=false;
            }
            else if((val.charAt(val.length-4)!=='.' ) && (val.charAt(val.length-3)!=='.' ))
            {
                errors.emailerror="***incorrect email id ! ";
                emailflag=false;

            }
            else if (val=== "") 
            {
                errors.emailerror="***Please fill the email field ";
                emailflag=false;
            }
            else
            {
                  errors.emailerror="";
                  emailflag=true;
            }
            break;
            

           case'mobileNumber':
           if(val.length!==10)
           {
               errors.mobileNumbererror="***not a valid number ! ";
               mobileNumberflag=false;
           }
           else if (val=== "") 
           {
               errors.mobileNumbererror="***Please fill the contact field ";
               mobileNumberflag=false;
           }
           else
           {
                errors.mobileNumbererror="";
                mobileNumberflag=true;
           }
           break;

           case'licenseNumber':
           if(val.length !== 4)
           {
                errors.licenseNumbererror="*** invalid license number plz enter correct id ! ";
                licenseNumberflag=false;
            }
            else if (val=== "") 
            {
                errors.licenseNumbererror="***Please fill the license field ";
                licenseNumberflag=false;
            }
            else
            {
                errors.licenseNumbererror="";
                licenseNumberflag=true;
            }
            break;

            case'aadharCard':
            if(val.length!== 10)
            {
                 errors.aadharCarderror="*** invalid pancard_id plz enter correct id ! ";
                 aadharCardflag=false;
            }
            else if (val=== "") 
            {
                errors.aadharCarderror="***Please fill the pancard  field ";
                aadharCardflag=false;
            }
            else
            {
                errors.aadharCarderror="";
                aadharCardflag=true;
            }
            break;
  
           case'address':
           if((val.length <= 3)||(val.length <= 8))
           {
               errors.addresserror="*** address length must be between 10 to 50 charcters  ";
               addressflag=false;
           }
           else if (val=== "") 
           {
               errors.addresserror="***Please fill the address field ";
               addressflag=false;
           }  
           else
           {
               errors.addresserror="";
               addressflag=true;
           }
           break;

           case'city':
           if((val.length <= 3)||(val.length > 8))
           {
               errors.cityerror="*** city length must be between 3 to 10 charcters  ";
               cityflag=false;
           }
           else if (val=== "") 
           {
               errors.cityerror="***Please fill the city field ";
               cityflag=false;
           }  
           else
           {
               errors.cityerror="";
               cityflag=true;
           }
           break;

        
       }
       this.setState({errors,[nm] : val ,
            fullNamevalid:fullNameflag,
            userNamevalid:userNameflag,
            passwordvalid :passwordflag,
            emailvalid:emailflag,
            mobileNumbervalid:mobileNumberflag,
            licenseNumbervalid:licenseNumberflag,
            aadharCardvalid:aadharCardflag,
            addressvalid:addressflag,
            cityvalid:cityflag,
            },
            ()=>{this.setState({formvalid:this.state.fullNamevalid && this.state.userNamevalid && this.state.passwordvalid  && this.state.emailvalid && this.state.mobileNumbervalid && this.state.licenseNumbervalid && this.state.aadharCardvalid && this.state.addressvalid && this.state.cityvalid })}

    
    );

    }

       // Creating RestAPI 
       submitForm = (e)=>{
        e.preventDefault();
        alert("form is getting submitted ");
        console.log(this.state);

        const reqData = {
            method : 'POST',
            headers : {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'*'
            },
            body:JSON.stringify({
                fullName: this.state.fullName,
                userName: this.state.userName,
                password: this.state.password,
                email: this.state.email ,
                mobileNumber:this.state.mobileNumber,
                licenseNumber: this.state.licenseNumber,
                aadharCard : this.state.aadharCard,
                address: this.state.address,
                city: this.state.city,  

            })
        } ;
             fetch("http://localhost:8080/distributor/add",reqData)
            .then(resp => resp.json())
            .then(data => this.setState({distributor:data , success : true }))
            alert("Register Successfull");
    }

    loginForm = ()=>{
        this.props.history.push("/Login");
    }

    render() {
        return (
            <div >
                <div className="container"><br />
                    <h1 className="text-primary text-center  font-weight-bold">Distributer Registration Form </h1><br></br>

                    <div className="col-lg-8 m-auto d-block">

                        <form action="#" onsubmit="#" className="bg-light" >
                          <div className="form-group"></div>
                            <br></br>
                            <div className="form-group">
                                <label>Enter Full Name: </label>
                                <input type="text" name="fullName" className="form-control"  autocomplete="off" value={this.state.fullName} onChange={this.handleChange}/>
                                <span className="text-danger font-weight-bold">{this.state.errors.fullNameerror}</span>
                            </div>
                            <br></br>

                            <div class="form-group">
                                <label> User Name: </label>
                                <input type="text" name="userName" class="form-control"  autocomplete="off" value={this.state.userName} onChange={this.handleChange}/>
                                <span id="username" class="text-danger font-weight-bold">{this.state.errors.userNameerror}</span>
                             </div>
                             <br></br>

                             <div className="form-group">
                                <label> Password : </label>
                                <input type="password" name="password" className="form-control"  autocomplete="off" value={this.state.password} onChange={this.handleChange}/>
                                <span  className="text-danger font-weight-bold">{this.state.errors.passworderror}</span>
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label> Email : </label>
                                <input type="text" name="email" className="form-control"  autocomplete="off" value={this.state.email} onChange={this.handleChange}/>
                                <span  className="text-danger font-weight-bold">{this.state.errors.emailerror}</span>
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label> Mobile Number : </label>
                                <input type="number" name="mobileNumber" className="form-control"  autocomplete="off" value={this.state.mobileNumber} onChange={this.handleChange}/>
                                <span className="text-danger font-weight-bold">{this.state.errors.mobileNumbererror}</span>
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label> License Number : </label>
                                <input type="number" name="licenseNumber" className="form-control"  autocomplete="off" value={this.state.licenseNumber} onChange={this.handleChange}/>
                                <span className="text-danger font-weight-bold">{this.state.errors.licenseNumbererror}</span>
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label>Aadhar Card : </label>
                                <input type="text" name="aadharCard" className="form-control"  autocomplete="off" value={this.state.aadharCard} onChange={this.handleChange}/>
                                <span className="text-danger font-weight-bold">{this.state.errors.aadharCarderror}</span>
                            </div>
                            <br></br>
                           
                            <div className="form-group">
                                <label> Address: </label>
                                <input type="text" name="address" className="form-control"  autocomplete="off" value={this.state.address} onChange={this.handleChange}/>
                                <span  className="text-danger font-weight-bold">{this.state.errors.addresserror}</span>
                            </div>
                            <br></br>

                            <div className="form-group">
                                <label> City : </label>
                                <input type="text" name="city" className="form-control"  autocomplete="off" value={this.state.city} onChange={this.handleChange}/>
                                <span  className="text-danger font-weight-bold">{this.state.errors.cityerror}</span>
                            </div>
                            <br></br>
                            <br></br>
                            <input type="submit" name="submit" value="submit" className="btn btn-success" onClick={this.submitForm}  disabled={!this.state.formvalid}/>
                            <span> </span>
                            <span> </span>
                            <span> </span>
                            <button className="btn btn-primary" onClick={this.loginForm}>Login</button>
                            <br></br>
                            <br></br>
                            <br></br>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}



