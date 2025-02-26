import React, { Component } from 'react';
import axios from 'axios';
import './Ticket.css';
import { Link } from 'react-router-dom';

export default class Ticket extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cinemaTicketData: [],
      loading: true,
      selectedTicket: null,
    };
  }

  componentDidMount() {
    console.log('Fetching ticket details from the backend...');

    // Make a request to the backend to fetch the ticket details
    axios
      .get('http://localhost:8082/user/ticket')
      .then((response) => {
        console.log('Ticket details received from the backend:', response.data);
        this.setState({
          cinemaTicketData: response.data,
          loading: false,
        });
      })
      .catch((error) => {
        console.error('Error fetching ticket details:', error);
        // Handle errors as needed
      });
  }

  handleShowTicket = (ticket) => {
    // Set the selected ticket when "Show Ticket" button is clicked
    this.setState({ selectedTicket: ticket });
  };

  handleCancelTicket = (id) => {
    const ticketIDAsLong = parseInt(id, 10);
    // Send a request to the backend to cancel the ticket for the given ticketId
    axios
      .delete(`http://localhost:8082/user/cancelticket?Id=${ticketIDAsLong}`)
      .then((response) => {
        console.log('Ticket canceled successfully:', response.data);
        // Update the ticket data to reflect the canceled status
        const updatedTicketData = this.state.cinemaTicketData.map((ticket) => {
          if (ticket.id === id) {
            return { ...ticket, bookingStatus: 'Canceled' };
          }
          return ticket;
        });

        this.setState({ cinemaTicketData: updatedTicketData });
      })
      .catch((error) => {
        console.error('Error canceling ticket:', error);
        // Handle errors as needed
      });
  };

  render() {
    const { cinemaTicketData, loading, selectedTicket } = this.state;

    return (
      <div className="cinema-ticket">
        <h2>Ticket Details</h2>
        {loading ? (
          <p>Loading...</p>
        ) : cinemaTicketData.length > 0 ? (
          <table>
            <thead>
              <tr>
                <th>Date</th>
                <th>Seats</th>
                <th>Payment Status</th>
                <th>Booking Status</th>
                <th>Selected Seats</th>
                <th>Time Slot</th>
                <th>Movie Name</th>
                <th>Language</th>
                <th>Duration</th>
                <th>Theatre Name</th>
                <th>Metro Location</th>
                <th>District</th>
                <th>Actions</th> {/* New column for Actions */}
              </tr>
            </thead>
            <tbody>
              {cinemaTicketData.map((ticket, index) => (
                <tr key={index}>
                  <td>{ticket.date}</td>
                  <td>{ticket.seats}</td>
                  <td>{ticket.paymentStatus}</td>
                  <td>{ticket.bookingStatus}</td>
                  <td>{ticket.selectedSeats?.join(', ')}</td>
                  <td>{ticket.timeSlot?.toString()}</td>
                  <td>{ticket.movieName}</td>
                  <td>{ticket.language}</td>
                  <td>{ticket.duration}</td>
                  <td>{ticket.theatreName}</td>
                  <td>{ticket.metroLocation}</td>
                  <td>{ticket.district}</td>
                  <td>
                    <button onClick={() => this.handleShowTicket(ticket)}>
                      Show Ticket
                    </button>
                    {ticket.bookingStatus === 'Booking Done' && (
                      <button
                        onClick={() => this.handleCancelTicket(ticket.id)}
                      >
                        Cancel Ticket
                      </button>
                    )}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p>No ticket details available</p>
        )}
        {selectedTicket && (
          <div className="ticket-details">
            <h2>Ticket Details</h2>
            <p>Date: {selectedTicket.date}</p>
            <p>Seats: {selectedTicket.seats}</p>
            <p>Payment Status: {selectedTicket.paymentStatus}</p>
            <p>Booking Status: {selectedTicket.bookingStatus}</p>
            <p>Selected Seats: {selectedTicket.selectedSeats?.join(', ')}</p>
            <p>Time Slot: {selectedTicket.timeSlot?.toString()}</p>
            <p>Movie Name: {selectedTicket.movieName}</p>
            <p>Language: {selectedTicket.language}</p>
            <p>Duration: {selectedTicket.duration}</p>
            <p>Theatre Name: {selectedTicket.theatreName}</p>
            <p>Metro Location: {selectedTicket.metroLocation}</p>
            <p>District: {selectedTicket.district}</p>
          </div>
        )}
        <Link to="/user" ><button>Back</button></Link>
      </div>
    );
  }
}
