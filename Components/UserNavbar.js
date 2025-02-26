import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios'; // Make sure to import axios

export class UserNavbar extends Component {
  // Define the handleLogout function inside the class
  handleLogout = () => {
    axios.get('http://localhost:8082/user/logout') // Replace with your server URL
      .then((response) => {
        // Redirect the user to the login page or any other appropriate page
        if (response.data === "Successfull") {
          window.location.href = '/login';
        }
      })
      .catch(error => {
        console.error('Logout failed:', error);
      });
  }

  render() {
    return (
      <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
          <div className="container-fluid">
            <a className="navbar-brand" href="/">BookNow</a>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="navbar-content d-flex justify-content-end" id="navbarSupportedContent">
              <ul className="navbar-nav me-auto mb-2 mb-lg-0 ">
                <li className="nav-item ">
                  <Link className="nav-link active" aria-current="page" to="/userdetails">User Details</Link>
                </li>
                <li className="nav-item ms-auto">
                  <Link className="nav-link active" aria-current="page" to="/ticket">Bookings</Link>
                </li>
                <li className="nav-item ms-auto">
                  {/* Call handleLogout function on click */}
                  <Link className="nav-link active" aria-current="page" to="/logout" onClick={this.handleLogout}>Logout</Link>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
    );
  }
}

export default UserNavbar;
