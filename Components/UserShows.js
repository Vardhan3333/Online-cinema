import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Service1 from '../service/service1';
import './modal.css';

export default class UserShows extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      showModal: false,
      selectedSeats: 1,
      selectedDate: '',
      showId: null, // Add showId to the state
    };
  }

  handleShowDetailsClick = (showID) => {
    const showIDAsLong = parseInt(showID, 10);
    // const formData = new FormData();
    // formData.append('Id', showIDAsLong);
    this.setState({ showModal: true, showId: showIDAsLong }); // Show the modal and set showId
  };

  handleSubmit = () => {
    const { selectedSeats, selectedDate, showModal, showId } = this.state;
    const formData = new FormData();
    formData.append('showId', showId); // Add showId to formData
    formData.append('selectedSeats', selectedSeats);
    formData.append('selectedDate', selectedDate);

    Service1.sendBookingData(formData)
      .then((response) => {
        console.log('Data sent to the backend:', response.data);
        this.setState({ showModal: false });
      })
      .catch((error) => {
        console.error('Error sending data to the backend:', error);
      });
  };

  componentDidMount() {
    Service1.getUserShowList()
      .then((response) => {
        this.setState({ data: response.data });
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }

  render() {
    const { data, showModal, selectedSeats, selectedDate } = this.state;

    return (
      <div>
        <table>
          <thead>
            <tr>
              <th>Show Timing</th>
              <th>Price Per Seat</th>
              <th>Regular Seats Available</th>
            </tr>
          </thead>
          <tbody>
            {data.map((item) => (
              <tr key={item.showID}>
                <td>{item.timeSlot}</td>
                <td>{item.pricePerSeat}</td>
                <td>{item.regularSeats_Available}</td>
                <td>
                  <button onClick={() => this.handleShowDetailsClick(item.showID)}>Book Ticket</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        {showModal && (
          <div className="modal">
            <div className="modal-content">
              <h2>Book Tickets</h2>
              <label>
                Number of Seats:
                <input
                  type="number"
                  value={selectedSeats}
                  onChange={(e) => this.setState({ selectedSeats: e.target.value })}
                />
              </label>
              <label>
                Select Date:
                <input
                  type="date"
                  value={selectedDate}
                  onChange={(e) => this.setState({ selectedDate: e.target.value })}
                />
              </label><Link to="/theatre">
              <button onClick={this.handleSubmit}>Submit</button></Link>
              <button onClick={() => this.setState({ showModal: false })}>Cancel</button>
            </div>
          </div>
        )}
      </div>
    );
  }
}
