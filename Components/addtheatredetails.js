import React, { Component } from 'react'
import Service1 from '../service/service1';

export default class addtheatredetails extends Component {
    constructor(props) {
        super(props);
        this.state = {
            theatreName: '',
            metroLocation: '',
          district: '',
          numberOfShows: 0,
          seatingCapacity: 0,
          reservationCapacityRegular: 0,
        };
      }
    
      handleChange = (e) => {
        const { name, value } = e.target;
        this.setState({ [name]: value });
      };
    
      handleSubmit = (e) => {
        e.preventDefault();
        const { theatreName, metroLocation, district, numberOfShows, seatingCapacity, reservationCapacityRegular } = this.state;
      
        // Create an object with the form data
        const data = {
          theatreName,
          metroLocation,
          district,
          numberOfShows: parseInt(numberOfShows), // Convert to integer
          seatingCapacity: parseInt(seatingCapacity), // Convert to integer
          reservationCapacityRegular: parseInt(reservationCapacityRegular), // Convert to integer
        };
      
        // Call the service to add theater data
        Service1.addTheatre(data)
          .then((response) => {
            console.log('Theater data added successfully:', response.data);
            // Optionally, reset the form's state here
            window.location.href = '/admin';
            this.setState({
              theatreName: '',
              metroLocation: '',
              district: '',
              numberOfShows: 0,
              seatingCapacity: 0,
              reservationCapacityRegular: 0,
            });
          })
          .catch((error) => {
            console.error('Error adding theater data:', error);
          });
      };
      
    
      render() {
        return (
          <div>
            <h2>Theater Information</h2>
            <form onSubmit={this.handleSubmit}>
              <div>
                <label>Theatre Name:</label>
                <input
                  type="text"
                  name="theatreName"
                  value={this.state.theatreName}
                  onChange={this.handleChange}
                />
              </div>
              <div>
                <label>Metro Location:</label>
                <input
                  type="text"
                  name="metroLocation"
                  value={this.state.metroLocation}
                  onChange={this.handleChange}
                />
              </div>
              <div>
                <label>District:</label>
                <input
                  type="text"
                  name="district"
                  value={this.state.district}
                  onChange={this.handleChange}
                />
              </div>
              <div>
                <label>Number of Shows:</label>
                <input
                  type="number"
                  name="numberOfShows"
                  value={this.state.numberOfShows}
                  onChange={this.handleChange}
                />
              </div>
              <div>
                <label>Total Capacity:</label>
                <input
                  type="number"
                  name="seatingCapacity"
                  value={this.state.seatingCapacity}
                  onChange={this.handleChange}
                />
              </div>
              <div>
                <label>Reservation Capacity:</label>
                <input
                  type="number"
                  name="reservationCapacityRegular"
                  value={this.state.reservationCapacityRegular}
                  onChange={this.handleChange}
                />
              </div>
              <button type="submit">Submit</button>
            </form>
          </div>
        );
      }
}
