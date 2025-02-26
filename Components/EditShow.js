import React, { Component } from 'react';
import Service1 from '../service/service1';

export default class EditShow extends Component {
  constructor(props) {
    super(props);
    this.state = {
      proxyTheatre: '',
      proxyMovie: '',
      timeSlot: '',
      pricePerSeat: '',
      regularSeats_Available: '',
    };
  }

  // componentDidMount() {
  //   Service1.getShowData()
  //     .then((response) => {
  //       const {
  //         proxyTheatre,
  //         proxyMovie,
  //         timeSlot,
  //         pricePerSeat,
  //         regularSeats_Available,
  //       } = response.data;

  //       this.setState({
  //         proxyTheatre: proxyTheatre || '',
  //         proxyMovie: proxyMovie || '',
  //         timeSlot: timeSlot || '',
  //         pricePerSeat: pricePerSeat || '',
  //         regularSeats_Available: regularSeats_Available || '',
  //       });
  //     })
  //     .catch((error) => {
  //       console.error('Error fetching show data:', error);
  //     });
  // }

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const {
      proxyTheatre,
      proxyMovie,
      timeSlot,
      pricePerSeat,
      regularSeats_Available,
    } = this.state;

    const data = {
      proxyTheatre: parseInt(proxyTheatre, 10),
      proxyMovie: parseInt(proxyMovie, 10),
      timeSlot,
      pricePerSeat: parseFloat(pricePerSeat),
      regularSeats_Available: parseInt(regularSeats_Available, 10),
    };

    Service1.editShow(data)
      .then((response) => {
        console.log('Show data edited successfully:', response.data);
        this.setState({
          proxyTheatre: '',
          proxyMovie: '',
          timeSlot: '',
          pricePerSeat: '',
          regularSeats_Available: '',
        });
      })
      .catch((error) => {
        console.error('Error editing show data:', error);
      });
  };

  render() {
    const timeSlotOptions = [
      '10:00',
      '12:00',
      '14:00',
      '16:00',
      '18:00',
      '20:00',
      '22:00',
    ];
    return (
      <div>
        <h2>Edit Show Details</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label htmlFor="proxyTheatre">Proxy Theatre:</label>
            <input
              type="number"
              id="proxyTheatre"
              name="proxyTheatre"
              value={this.state.proxyTheatre}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="proxyMovie">Proxy Movie:</label>
            <input
              type="number"
              id="proxyMovie"
              name="proxyMovie"
              value={this.state.proxyMovie}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="timeSlot">Time Slot:</label>
            <select
              id="timeSlot"
              name="timeSlot"
              value={this.state.timeSlot}
              onChange={this.handleChange}
            >
              {timeSlotOptions.map((slot) => (
                <option key={slot} value={slot}>
                  {slot}
                </option>
              ))}
            </select>
          </div>
          <div>
            <label htmlFor="pricePerSeat">Price Per Seat:</label>
            <input
              type="number"
              step="0.01"
              id="pricePerSeat"
              name="pricePerSeat"
              value={this.state.pricePerSeat}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="regularSeats_Available">Regular Seats Available:</label>
            <input
              type="number"
              id="regularSeats_Available"
              name="regularSeats_Available"
              value={this.state.regularSeats_Available}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Edit Show</button>
        </form>
      </div>
    );
  }
}
