import React, { Component } from 'react'
import Service1 from '../service/service1';

export default class demo extends Component {
    constructor(props){
        super(props);
        this.state= {
            message:'',
        };
    }
    componentDidMount(){
      // const service = new Service1(); 
Service1.getHi()
    .then((res) => {
        this.setState({ message: res.data });
    })
    .catch((error) => {
        console.error('Error fetching data:', error);
    });
    }
  render() {
    return (
      <div>
        <h1>{this.state.message}</h1>
      </div>
    )
  }
}
