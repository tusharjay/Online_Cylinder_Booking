import React from "react";
export default class AboutUs extends React.Component {
    render() {
        return (
            <div>
                <div className="about-section"  >
                    <h1 style={{textAlign:"center",color:"yellowgreen"}}>About Us </h1>
                    <div style={{textAlign:"center"}}>
                       
                    <div/>
                </div>
            </div>
            <br/>

            <h2 style={{textAlign:"center",color:"red"}}>IACSD March 22</h2>
            <br></br>
                <h2 style={{textAlign:"center"}}>Our Team</h2>
                <div className="row" >

                    <div className="column"  >
                        <div className="card" style={{textAlign:"center"}}>
                            <div className="img" >
                                
                            </div>
                            <div class ="container">
                            <h2>Krushna Lilhare</h2>
                                                       
                            <p>krishnalilhare671@gmail.com</p>
                            <p>Mob:+917030442059</p>
                        </div>
                    </div>
                </div>

                    <div className="column">
                        <div className="card" style={{textAlign:"center"}}>
                            <div className="img" >
                               
                            </div>
                            <div className ="container">
                            <h2>Tushar Rangari</h2>
                            
                            
                            <p>rangaritushar@gmail.com</p>
                            <p>Mob:+918149891050</p>
                        </div>
                    </div>                
                </div>
                <div className="column">
                        <div className="card" style={{textAlign:"center"}}>
                            <div className="img" >
                               
                            </div>
                            <div className ="container">
                            <h2>Ritwik Sukla</h2>
                            
                            
                            <p>ritwik504@gmail.com</p>
                            <p>Mob:+918770469929</p>
                        </div>
                    </div>
               </div>
                           
                </div>

            </div>
        );
    }
}