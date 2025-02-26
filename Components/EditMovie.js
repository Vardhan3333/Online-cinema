import React, { Component } from 'react';
import Service1 from '../service/service1';

export default class EditMovie extends Component {
  constructor(props) {
    super(props);
    this.state = {
      movieName: '',
      language: '',
      duration: '',
    };
  }

  handleChange = (e) => {
    const { name, value } = e.target;

    if (name === 'duration') {
      // Handle the duration input as hours and minutes
      this.setState({ [name]: value });
    } else {
      // Handle other inputs as usual
      this.setState({ [name]: value });
    }
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const { movieName, language, duration } = this.state;
    const [hours, minutes] = duration.split(':');
    const durationDecimal = parseFloat(hours) + parseFloat(minutes) / 60;

    const data = {
      movieName,
      language,
      duration: durationDecimal,
    };

    Service1.editMovie(data)
      .then((response) => {
        console.log('Movie data edited successfully:', response.data);
        this.setState({
          movieName: '',
          language: '',
          duration: '',
        });
      })
      .catch((error) => {
        console.error('Error editing movie data:', error);
      });
  };

  render() {
    return (
      <div>
        <h2>Edit Movie Information</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label htmlFor="movieName">Movie Name:</label>
            <input
              type="text"
              id="movieName"
              name="movieName"
              value={this.state.movieName}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="language">Language:</label>
            <input
              type="text"
              id="language"
              name="language"
              value={this.state.language}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label htmlFor="duration">Duration:</label>
            <input
              type="text"
              id="duration"
              name="duration"
              value={this.state.duration}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Edit Movie</button>
        </form>
      </div>
    );
  }
}
