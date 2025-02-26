import React, { Component } from 'react'
import Service1 from '../service/service1';

export default class Addshowdetails extends Component {
    constructor(props) {
        super(props);
        this.state = {
          proxyTheatre: '',
          proxyMovie:'',
            timeSlot: '',
            pricePerSeat: '',
            regularSeats_Available: '',
          
        };
      }
    
      handleChange = (e) => {
        const { name, value } = e.target;
        this.setState({ [name]: value });
      };
    
      handleSubmit = (e) => {
        e.preventDefault();
        const { proxyTheatre,proxyMovie, timeSlot,  pricePerSeat, regularSeats_Available} = this.state;
      
        // Create an object with the form data
        const data = {
          proxyTheatre : parseInt(proxyTheatre,10),
          proxyMovie : parseInt(proxyMovie,10),
            timeSlot,
            pricePerSeat: parseFloat(pricePerSeat),
            regularSeats_Available: parseInt(regularSeats_Available), // Convert to integer
            
        };
      
        // Call the service to add theater data
        Service1.addShow(data)
          .then((response) => {
            console.log('Show data added successfully:', response.data);
            // Optionally, reset the form's state here
            window.location.href = '/admin';
            this.setState({
              proxyTheatre: '',
              proxyMovie:'',
                timeSlot: '',
                pricePerSeat: '',
                regularSeats_Available: '',
            });
          })
          .catch((error) => {
            console.error('Error adding show data:', error);
          });
      };
      
    
      render() {
        const timeSlotOptions = [
          '10:00 ',
          '12:00 ',
          '14:00 ',
          '16:00 ',
          '18:00 ',
          '20:00 ',
          '22:00 ',
        ];
        return (
          <div>
            <h2>Show Details</h2>
            <form onSubmit={this.handleSubmit}>
              <div>
                <label>Theatre Id:</label>
                <input
                  type="text"
                  name="proxyTheatre"
                  value={this.state.proxyTheatre}
                  onChange={this.handleChange}
                />
              </div>
              <div>
                <label>Movie Id:</label>
                <input
                  type="text"
                  name="proxyMovie"
                  value={this.state.proxyMovie}
                  onChange={this.handleChange}
                />
              </div>
              <div>
            <label>Time Slot:</label>
            <select
              name="timeSlot"
              value={this.state.timeSlot}
              onChange={this.handleChange}
            >
              <option value="">Select a Time Slot</option>
              {timeSlotOptions.map((slot, index) => (
                <option key={index} value={slot}>
                  {slot}
                </option>
              ))}
            </select>
          </div>
              <div>
                <label>Price Per Seat:</label>
                <input
                  type="number"
                  name="pricePerSeat"
                  value={this.state.pricePerSeat}
                  onChange={this.handleChange}
                />
              </div>
              <div>
                <label>Regular Seats Available:</label>
                <input
                  type="number"
                  name="regularSeats_Available"
                  value={this.state.regularSeats_Available}
                  onChange={this.handleChange}
                />
              </div>
              
              <button type="submit">Submit</button>
            </form>
          </div>
        );
      }
}
