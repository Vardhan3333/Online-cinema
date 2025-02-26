import React, { Component } from 'react'
import { Link } from 'react-router-dom';
import Service1 from '../service/service1';

export default class theatreslist extends Component {
    constructor(props) {
        super(props);
        this.state = {
          data: [],
          Id:'',
        };
      }
      
      componentDidMount() {
        Service1.getUserTheatres() // Replace with the actual API endpoint
          .then((response) => {
            this.setState({ data: response.data });
          })
          .catch((error) => {
            console.error('Error fetching data:', error);
          });
      }
      handleTheatreLinkClick = (theatreId) => {
        // Here, you can send data to the backend when a theatre link is clicked
        // You can use the theatreId or any other data you want to send
    
        // Example: Sending theatreId to the backend
        const theatreIdAsLong = parseInt(theatreId,10);
        const formData = new FormData();
      formData.append('Id', theatreIdAsLong);
        Service1.sendTheatreId(formData)
          .then((response) => {
            // Handle the response from the backend if needed
            console.log('Data sent to the backend:', response.data);
          })
          .catch((error) => {
            console.error('Error sending data to the backend:', error);
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
                  <th>No of shows</th>
                  <th>Seating capacity</th>
                  <th>Reservation capacity</th>
                  {/* Add more table headers for your data */}
                </tr>
              </thead>
              <tbody>
                {data.map((item) => (
                  <tr key={item.theatreID}>
                    <td><Link
                    to="shows"
                    onClick={() => this.handleTheatreLinkClick(item.theatreID)}
                  >
                    {item.theatreName}
                  </Link></td>
                    {/* <td><Link to="usertheatres">{item.movieName}</Link></td> */}
                    <td>{item.metroLocation}</td>
                    <td>{item.district}</td>
                    <td>{item.numberOfShows}</td>
                    <td>{item.seatingCapacity}</td>
                    <td>{item.reservationCapacityRegular}</td>
                    {/* Add more table cells for your data */}
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        );
      }
}


  




