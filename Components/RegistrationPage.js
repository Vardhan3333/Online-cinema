import React, { Component } from 'react';
import Service1 from '../service/service1';
import './Registration.css'; // Import your CSS file

export default class RegistrationPage extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: '',
      firstName: '',
      lastName: '',
      age: '',
      gender: '',
      password: '',
      confirmPassword: '',
      address: '',
      phoneNo: '',
      errors: {}, // Object to store validation errors
    };
  }

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  // Validation function to check if the input is empty
  validateNotEmpty = (value) => {
    return value.trim() !== '';
  };

  // Validation function for password complexity
  validatePasswordComplexity = (value) => {
    // Use a regular expression to check for at least one capital letter, one small letter, and one special character
    const passwordRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()_+{}\[\]:;<>,.?~\\-]).{8,}$/;
    return passwordRegex.test(value);
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const {
      userName,
      firstName,
      lastName,
      age,
      gender,
      password,
      confirmPassword,
      address,
      phoneNo,
    } = this.state;

    const errors = {};

    // Validate each input field
    if (!this.validateNotEmpty(userName)) {
      errors.userName = 'Username is required.';
    }
    if (!this.validateNotEmpty(firstName)) {
      errors.firstName = 'First name is required.';
    }
    if (!this.validateNotEmpty(lastName)) {
      errors.lastName = 'Last name is required.';
    }
    if (!this.validateNotEmpty(age)) {
      errors.age = 'Age is required.';
    }
    if (!this.validateNotEmpty(gender)) {
      errors.gender = 'Gender is required.';
    }
    if (!this.validateNotEmpty(address)) {
      errors.address = 'Address is required.';
    }
    if (!this.validateNotEmpty(phoneNo)) {
      errors.phoneNo = 'Phone number is required.';
    }
    if (!this.validatePasswordComplexity(password)) {
      errors.password =
        'Password must contain at least one capital letter, one small letter, and one special character.';
    }
    if (password !== confirmPassword) {
      errors.confirmPassword = 'Passwords do not match.';
    }

    if (Object.keys(errors).length === 0) {
      // No validation errors, proceed with form submission

      const data = {
        userName,
        firstName,
        lastName,
        age: parseInt(age),
        gender,
        password,
        address,
        phoneNo: parseInt(phoneNo, 10),
      };

      Service1.addUser(data)
        .then((response) => {
          console.log('User added successfully', response.data);
          const registrationId = response.data; // Assuming the Registration ID is returned as a string
          alert(`Your Registration ID is: ${registrationId}`);
          window.location.href = '/login';
          // Optionally, reset the form's state here
          this.setState({
            userName: '',
            firstName: '',
            lastName: '',
            age: '',
            gender: '',
            password: '',
            confirmPassword: '',
            address: '',
            phoneNo: '',
            errors: {}, // Clear any previous errors
          });
        })
        .catch((error) => {
          console.error('Error adding user data:', error);
          // Handle other types of errors here, if needed
          this.setState({
            errors: { general: 'User already present' },
          });
        });
    } else {
      // Validation errors found, update the state with errors
      this.setState({ errors });
    }
  };

  render() {
    const { errors } = this.state;

    return (
      <div className="container">
        <h2>User Registration</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Username:</label>
            <input
              type="text"
              name="userName"
              value={this.state.userName}
              onChange={this.handleChange}
            />
            {errors.userName && <p className="error-message">{errors.userName}</p>}
          </div>
          <div>
            <label>First Name:</label>
            <input
              type="text"
              name="firstName"
              value={this.state.firstName}
              onChange={this.handleChange}
            />
            {errors.firstName && <p className="error-message">{errors.firstName}</p>}
          </div>
          <div>
            <label>Last Name:</label>
            <input
              type="text"
              name="lastName"
              value={this.state.lastName}
              onChange={this.handleChange}
            />
            {errors.lastName && <p className="error-message">{errors.lastName}</p>}
          </div>
          <div>
            <label>Age:</label>
            <input
              type="number"
              name="age"
              value={this.state.age}
              onChange={this.handleChange}
            />
            {errors.age && <p className="error-message">{errors.age}</p>}
          </div>
          <div>
            <label>Gender:</label>
            <input
              type="text"
              name="gender"
              value={this.state.gender}
              onChange={this.handleChange}
            />
            {errors.gender && <p className="error-message">{errors.gender}</p>}
          </div>
          <div>
            <label>Password:</label>
            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
            />
            {errors.password && <p className="error-message">{errors.password}</p>}
          </div>
          <div>
            <label>Confirm Password:</label>
            <input
              type="password"
              name="confirmPassword"
              value={this.state.confirmPassword}
              onChange={this.handleChange}
            />
            {errors.confirmPassword && (
              <p className="error-message">{errors.confirmPassword}</p>
            )}
          </div>
          <div>
            <label>Address:</label>
            <input
              type="text"
              name="address"
              value={this.state.address}
              onChange={this.handleChange}
            />
            {errors.address && <p className="error-message">{errors.address}</p>}
          </div>
          <div>
            <label>Phone No:</label>
            <input
              type="number"
              name="phoneNo"
              value={this.state.phoneNo}
              onChange={this.handleChange}
            />
            {errors.phoneNo && <p className="error-message">{errors.phoneNo}</p>}
          </div>
          {errors.general && <p className="error-message">{errors.general}</p>}
          
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}
