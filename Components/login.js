import React, { Component } from 'react';
import Service1 from '../service/service1';
import { Link, useNavigate } from 'react-router-dom';
import './Login.css';
import LoginNav from './LoginNav';

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      registrationId: '',
      password: '',
      error: null,
    };
  }

  handleSubmit = async (e) => {
    e.preventDefault();
    const { registrationId, password } = this.state;

    // Validate if registrationId and password are provided
    if (!registrationId || !password) {
      this.setState({ error: 'Please provide necessary credentials.' });
      return;
    }

    try {
      const data = {
        registrationId,
        password,
      };

      const response = await Service1.getCredentials(data);

      if (response.status === 200) {
        const data = response.data;

        if (data === 'user') {
          // Redirect to the user page for regular users
          this.props.navigate('/user');
        } else if (data === 'admin') {
          // Redirect to the admin page for admins
          this.props.navigate('/admin');
        }
      } else {
        // Display an error message for incorrect credentials
        this.setState({ error: 'Login failed. Please check your credentials.' });
      }
    } catch (error) {
      // Handle exceptions and display an alert message
      console.error('Login error:', error);
      this.setState({ error: 'An error occurred. Please try again later.' });
    }
  };

  render() {
    return (
      
      <div >
        <LoginNav/>
        <div className="container1">
        <form onSubmit={this.handleSubmit}>
          <h3>Registration Id</h3>
          <input
            type="text"
            placeholder="Registration Id"
            value={this.state.registrationId}
            onChange={(e) => this.setState({ registrationId: e.target.value })}
          />
          <h3>Password</h3>
          <input
            type="password"
            placeholder="Password"
            value={this.state.password}
            onChange={(e) => this.setState({ password: e.target.value })}
          />
          <button type="submit">Login</button>
        </form>
        <h3>If you already have an account, <Link to="/Register">Register</Link></h3>
        {this.state.error && <p className="error">{this.state.error}</p>}
        </div>
      </div>
    );
  }
}

function LoginWrapper() {
  const navigate = useNavigate();

  return <Login navigate={navigate} />;
}

export default LoginWrapper;
