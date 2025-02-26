import React, { Component } from 'react'
import UserNavbar from './UserNavbar'
import Service1 from '../service/service1';
import { Link } from 'react-router-dom';

export default class UserMovie extends Component {
    constructor(props) {
        super(props);
        this.state = {
          data: [],
        };
      }

      componentDidMount(){
        Service1.getMovies() // Replace with the actual API endpoint
          .then((response) => {
            this.setState({ data: response.data });
          })
          .catch((error) => {
            console.error('Error fetching data:', error);
          });
      }
      handleShowDetailsClick = (movieId) => {
        // Ensure that movieId is a valid numeric string
        const movieIDAsLong = parseInt(movieId, 10);
        if (isNaN(movieIDAsLong)) {
          // Handle the case where movieId is not a valid number
          console.error('movieId is not a valid number:', movieId);
          return;
        }
      
        const formData = new FormData();
        formData.append('Id', movieIDAsLong);
      
        // Send the data to the backend
        Service1.sendMovieId(formData)
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
      
      
  render() {
    const { data } = this.state;
    return (
        <div>
            <UserNavbar/>
        <table>
          <thead>
            <tr>
              <th>Movie Name</th>
              <th>Duration</th>
              <th>Language</th> 
            </tr>
          </thead>
          <tbody>
            {data.map((item) => (
              <tr key={item.movieID}>
                
                <td><Link to="usertheatres">{item.movieName}</Link></td>
                <td>{item.duration}</td>
                <td>{item.language}</td>
                
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    )
  }
}
