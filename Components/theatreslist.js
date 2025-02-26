import axios from 'axios';
import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Service1 from '../service/service1';
import './theatrelist.css';

export default class theatreslist extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
    };
  }

  componentDidMount() {
    Service1.getTheatres() // Replace with the actual API endpoint
      .then((response) => {
        this.setState({ data: response.data });
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  }

  handleShowDetailsClick = (theatreID) => {
    // Example: Sending showID to the backend
    const theatreIDAsLong = parseInt(theatreID, 10);
    const formData = new FormData();
    formData.append('Id', theatreIDAsLong);

    // Send the data to the backend
    Service1.sendTheatreId(formData)
      .then((response) => {
        // Handle the response from the backend if needed
        console.log('Data sent to the backend:', response.data);

        // Navigate to the '/edittheatre' route
        // this.props.history.push('/edittheatre');
      })
      .catch((error) => {
        console.error('Error sending data to the backend:', error);
      });
  };

  handleDeleteTheatreClick = (theatreID) => {
    // Example: Sending theatreID to the backend for deletion
    const theatreIDAsLong = parseInt(theatreID, 10);
    const formData = new FormData();
    formData.append('Id', theatreIDAsLong);

    // Send the data to the backend for deletion
    axios.delete(`http://localhost:8081/admin/deletetheatre?Id=${theatreIDAsLong}`)
      .then((response) => {
        // Handle the response from the backend if needed
        console.log('Theatre deleted successfully:', response.data);

        // Optionally, update the state to remove the deleted theatre from the list
        this.setState((prevState) => ({
          data: prevState.data.filter((item) => item.theatreID !== theatreID),
        }));
      })
      .catch((error) => {
        console.error('Error deleting theatre:', error);
      });
  };

  render() {
    const { data } = this.state;

    return (
      <div>
        <table>
          <thead>
            <tr>
              <th>Theatre Name</th>
              <th>Metro Location</th>
              <th>District</th>
              <th>No of Shows</th>
              <th>Seating Capacity</th>
              <th>Reservation Capacity</th>
              <th>Edit Theatre</th>
              <th>Delete Theatre</th>
            </tr>
          </thead>
          <tbody>
            {data.map((item) => (
              <tr key={item.theatreID}>
                <td>{item.theatreName}</td>
                <td>{item.metroLocation}</td>
                <td>{item.district}</td>
                <td>{item.numberOfShows}</td>
                <td>{item.seatingCapacity}</td>
                <td>{item.reservationCapacityRegular}</td>
                <td>
                  <Link to="/edittheatre">
                    <button
                      onClick={() => this.handleShowDetailsClick(item.theatreID)}
                    >
                      Edit Theatres
                    </button>
                  </Link>
                </td>
                <td>
                  <button
                    onClick={() => this.handleDeleteTheatreClick(item.theatreID)}
                  >
                    Delete Theatre
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
