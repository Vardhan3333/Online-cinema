import React, { Component } from 'react'
import { Link } from 'react-router-dom'


export class Navbar extends Component {
  

  render() {
    return (
      <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container-fluid">  
    <a className="navbar-brand" href="/">Book Now</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/addtheatre" exact>Add Theatre</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/addshow" exact>Add Show</Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link active" aria-current="page" to="/addmovie" exact>Add Movie</Link>
        </li>
        
        
      </ul>
     
    </div>
  </div>
        </nav>
      </div>
    )
  }
}

export default Navbar
