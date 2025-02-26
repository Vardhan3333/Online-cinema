import axios from 'axios';
import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Service1 from '../service/service1';
import './ShowList.css';

export default class ShowsList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
    };
  }

  componentDidMount() {
    Service1.getShowsData() // Replace with the actual API endpoint
      .then((response) => {
        this.setState({ data: response.data });
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }

  handleShowDetailsClick = (showID) => {
    // Example: Sending showID to the backend
    const showIDAsLong = parseInt(showID, 10);
    const formData = new FormData();
    formData.append('Id', showIDAsLong);

    // Send the data to the backend
    Service1.sendshowID(formData)
      .then((response) => {
        // Handle the response from the backend if needed
        console.log('Data sent to the backend:', response.data);

        // Navigate to the '/editshow' route
        // this.props.history.push('/editshow');
      })
      .catch((error) => {
        console.error('Error sending data to the backend:', error);
      });
  };

  handleDeleteShowClick = (showID) => {
    // Example: Sending showID to the backend for deletion
    const showIDAsLong = parseInt(showID, 10);
    const formData = new FormData();
    formData.append('Id', showIDAsLong);

    // Send the data to the backend for deletion
    axios.delete(`http://localhost:8081/admin/deleteshow?Id=${showIDAsLong}`)
      .then((response) => {
        // Handle the response from the backend if needed
        console.log('Show deleted successfully:', response.data);

        // Optionally, update the state to remove the deleted show from the list
        this.setState((prevState) => ({
          data: prevState.data.filter((item) => item.showID !== showID),
        }));
      })
      .catch((error) => {
        console.error('Error deleting show:', error);
      });
  };

  render() {
    const { data } = this.state;

    return (
      <div>
        <table>
          <thead>
            <tr>
              <th>Show Timing</th>
              <th>Price Per Seat</th>
              <th>Regular Seats Available</th>
              <th>Edit Show</th>
              <th>Delete Show</th>
            </tr>
          </thead>
          <tbody>
            {data.map((item) => (
              <tr key={item.showID}>
                <td>{item.timeSlot}</td>
                <td>{item.pricePerSeat}</td>
                <td>{item.regularSeats_Available}</td>
                <td>
                  <Link to="/editshow">
                    <button
                      onClick={() => this.handleShowDetailsClick(item.showID)}
                    >
                      Edit Show
                    </button>
                  </Link>
                </td>
                <td>
                  <button
                    onClick={() => this.handleDeleteShowClick(item.showID)}
                  >
                    Delete Show
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}
