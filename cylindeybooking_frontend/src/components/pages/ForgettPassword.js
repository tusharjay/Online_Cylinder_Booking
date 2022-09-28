import React, { Component } from 'react'

export default class ForgettPassword extends Component {
    constructor(props) {
        super(props);
        this.state =
        {
            userName: "",
            mobileNumber:"",
            newPassword: "",
            login:{}
            
        }
    }

    handleChange = (e) => {

        const input = e.target;
        const nm = input.name;
        const val = input.value;
        this.setState({ [nm]: val });
    }

     updateData =(e) =>{
        /*e.preventDefault();
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
                    mobileNumber:this.state. mobileNumber,
                    newPassword: this.state.newPassword,
                   
                })
        }
    
       // alert("Changed Password");
     fetch("http://localhost:8080/changepass", reqData)
     .then(resp => resp.json())
     /*.then(data => this.setState({login:data , success : true }))  */
     //.then(data => this.setState({login:data , success : true }))
     

     .then(data => {
        alert("Changed Password");
        if (data.length != 0) 
        {
           
            console.log(data);
            const json = JSON.parse(data);
            if (json.login_tbl.user == this.state.user) 
            {
                this.setState({ newPassword: json });
            }
        }
       
        })
    }

     
     loginForm = ()=>{
        this.props.history.push("/Login");
    }

    render() {
        return (
            <div>
                <br/>
                <div className="container"><br />
                    <h2 className="text-primary text-center">Forgot Password ! </h2><br></br>

                    <div className="col-lg-8 m-auto d-block">
                <form onSubmit={ this.handleSubmit }>
                   

                    <div className="form-group">
                        <label><b>Enter User:</b></label>
                        <input type="text" name="userName" className="form-control"  autocomplete="off" value={this.state.userName} onChange={this.handleChange}/>
                    </div> 
                    <br/><br/>  
                    <div className="form-group">
                        <label><b>Enter Register Mobile Number:</b></label>
                        <input type="text" name="mobileNumber" className="form-control"  autocomplete="off" value={this.state.mobileNumber} onChange={this.handleChange}/>
                    </div> 
                    <br/><br/>   

                      <div className="form-group">
                        <label><b>Enter  New Password  :</b></label>
                        <input type="password" name="newPassword" placeholder="******" className="form-control my-2 p-2 "   value={this.state.newPassword} onChange={this.handleChange} />
                    </div>  
                    <br/><br/> 

                     <button className="btn btn-success"   onClick={this.updateData}> Update </button>&nbsp;&nbsp;<button className="btn btn-primary" onClick={this.loginForm} >Login</button><br/><br/> 
                     <br/><br/>
                     <br/><br/>
                     <br/><br/>

                </form>

                </div>

                </div>
            </div>
        )
    }
}

