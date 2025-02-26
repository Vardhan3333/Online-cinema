import React, { Component } from 'react';
import UserNavbar from './UserNavbar';
import Service1 from '../service/service1';
import { Link } from 'react-router-dom';
import Navbar from './Navbar';
import axios from 'axios';

export default class MovieList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
    };
  }

  componentDidMount() {
    Service1.getMovies()
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

  handleDeleteMovieClick = (movieId) => {
    // Ensure that movieId is a valid numeric string
    const movieIDAsLong = parseInt(movieId, 10);
    if (isNaN(movieIDAsLong)) {
      // Handle the case where movieId is not a valid number
      console.error('movieId is not a valid number:', movieId);
      return;
    }

    const formData = new FormData();
    formData.append('Id', movieIDAsLong);
    console.log(formData);
    // Send the data to the backend for movie deletion
    axios.delete(`http://localhost:8081/admin/deletemovie?Id=${movieIDAsLong}`)
      .then((response) => {
        // Handle the response from the backend if needed
        console.log('Movie deleted successfully:', response.data);

        // Refresh the movie list by fetching data again
        this.componentDidMount();
      })
      .catch((error) => {
        console.error('Error deleting movie:', error);
      });
  };

  render() {
    const { data } = this.state;
    return (
      <div>
        <Navbar />
        <table>
          <thead>
            <tr>
              <th>Movie Name</th>
              <th>Duration</th>
              <th>Language</th>
              <th>Action</th> {/* Added Action column for Edit and Delete buttons */}
            </tr>
          </thead>
          <tbody>
            {data.map((item) => (
              <tr key={item.movieID}>
                <td>
                  <Link to="usertheatres">{item.movieName}</Link>
                </td>
                <td>{item.duration}</td>
                <td>{item.language}</td>
                <td>
                  <Link to="/editmovie">
                    <button
                      onClick={() => this.handleShowDetailsClick(item.movieID)}
                    >
                      Edit Movie
                    </button>
                  </Link>
                  <button
                    onClick={() => this.handleDeleteMovieClick(item.movieID)}
                  >
                    Delete Movie
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
