import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

class UserDetails extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userDetailsData: {}, // Initialize userDetailsData as an object
    };
  }

  componentDidMount() {
    console.log('Fetching user details from the backend...');

    // Make a request to the backend to fetch user details
    axios
      .get('http://localhost:8082/user/userdetails') // Replace with your backend API endpoint
      .then((response) => {
        console.log('User details received from the backend:', response.data);
        this.setState({
          userDetailsData: response.data,
        });
      })
      .catch((error) => {
        console.error('Error fetching user details:', error);
      });
  }

  render() {
    const { userDetailsData } = this.state;

    return (
      <div className="user-details">
        <h2>User Details</h2>
        {Object.keys(userDetailsData).length > 0 ? ( // Check if userDetailsData is not empty
          <table>
            <tbody>
              <tr>
                <th>Registration ID</th>
                <td>{userDetailsData.registrationId}</td>
              </tr>
              <tr>
                <th>Username</th>
                <td>{userDetailsData.userName}</td>
              </tr>
              <tr>
                <th>First Name</th>
                <td>{userDetailsData.firstName}</td>
              </tr>
              <tr>
                <th>Last Name</th>
                <td>{userDetailsData.lastName}</td>
              </tr>
              <tr>
                <th>Age</th>
                <td>{userDetailsData.age}</td>
              </tr>
              <tr>
                <th>Gender</th>
                <td>{userDetailsData.gender}</td>
              </tr>
              <tr>
                <th>Address</th>
                <td>{userDetailsData.address}</td>
              </tr>
              <tr>
                <th>Phone Number</th>
                <td>{userDetailsData.phoneNo}</td>
              </tr>
              <tr>
                <th>Role</th>
                <td>{userDetailsData.role}</td>
              </tr>
            </tbody>
          </table>
        ) : (
          <p>No user details available</p>
        )}
        <Link to="/user" ><button>Back</button></Link>
      </div>
    );
  }
}

export default UserDetails;
