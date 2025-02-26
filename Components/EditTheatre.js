import React, { Component } from 'react';
import Service1 from '../service/service1';

export default class EditTheatre extends Component {
  constructor(props) {
    super(props);
    this.state = {
      theatreName: '',
      metroLocation: '',
      district: '',
      numberOfShows: '',
      seatingCapacity: '',
      reservationCapacityRegular: '',
    };
  }

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const {
      theatreName,
      metroLocation,
      district,
      numberOfShows,
      seatingCapacity,
      reservationCapacityRegular,
    } = this.state;

    const data = {
      theatreName,
      metroLocation,
      district,
      numberOfShows: parseInt(numberOfShows, 10),
      seatingCapacity: parseInt(seatingCapacity, 10),
      reservationCapacityRegular: parseInt(reservationCapacityRegular, 10),
    };

    Service1.editTheatre(data)
      .then((response) => {
        console.log('Theatre data edited successfully:', response.data);
        this.setState({
          theatreName: '',
          metroLocation: '',
          district: '',
          numberOfShows: '',
          seatingCapacity: '',
          reservationCapacityRegular: '',
        });
      })
      .catch((error) => {
        console.error('Error editing theatre data:', error);
      });
  };

  render() {
    return (
      <div>
        <h2>Edit Theatre Information</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label htmlFor="theatreName">Theatre Name:</label>
            <input
              type="text"
              id="theatreName"
              name="theatreName"
              value={this.state.theatreName}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="metroLocation">Metro Location:</label>
            <input
              type="text"
              id="metroLocation"
              name="metroLocation"
              value={this.state.metroLocation}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="district">District:</label>
            <input
              type="text"
              id="district"
              name="district"
              value={this.state.district}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="numberOfShows">Number of Shows:</label>
            <input
              type="number"
              id="numberOfShows"
              name="numberOfShows"
              value={this.state.numberOfShows}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="seatingCapacity">Seating Capacity:</label>
            <input
              type="number"
              id="seatingCapacity"
              name="seatingCapacity"
              value={this.state.seatingCapacity}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="reservationCapacityRegular">Reservation Capacity (Regular):</label>
            <input
              type="number"
              id="reservationCapacityRegular"
              name="reservationCapacityRegular"
              value={this.state.reservationCapacityRegular}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Edit Theatre</button>
        </form>
      </div>
    );
  }
}
