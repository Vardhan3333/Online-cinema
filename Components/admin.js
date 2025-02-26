import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import Navbar from './Navbar'
import './adminstyle.css';

export default class admin extends Component {
  render() {
    return (
      <div>
        <Navbar/>
        
        <Link to="/theatres">
        <button>Theatres</button>
      </Link>
      <Link to="/showsdetails">
        <button>Show Details</button>
      </Link>

      <Link to="/moviedetails">
        <button>Movie Details</button>
      </Link>
      
      </div>
      
    )
  }
}
