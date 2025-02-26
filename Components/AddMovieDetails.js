// import React, { Component } from 'react';
// import Service1 from '../service/service1';

// export default class AddMovieDetails extends Component {
//   constructor(props) {
//     super(props);
//     this.state = {
//       movieName: '',
//       language: '',
//       duration: new Date(), // Initialize duration as a Date object
//     };
//   }

//   handleChange = (e) => {
//     const { name, value } = e.target;

//     if (name === 'duration') {
//       // Handle the duration input as a Date object
//       const [hours, minutes] = value.split(':');
//       const durationDate = new Date();
//       durationDate.setHours(parseInt(hours, 10));
//       durationDate.setMinutes(parseInt(minutes, 10));
//       durationDate.setSeconds(0); // Set seconds to 0

//       this.setState({
//         [name]: durationDate,
//       });
//     } else {
//       // Handle other inputs as usual
//       this.setState({ [name]: value });
//     }
//   };

//   handleSubmit = (e) => {
//     e.preventDefault();
//     const { movieName, language, duration } = this.state;

//     // Convert the duration Date object to a string in "hh:mm:ss" format
//     const formattedDuration = `${duration.getHours()}:${duration.getMinutes()}:00`;

//     // Create an object with the form data
//     const data = {
//       movieName,
//       language,
//       duration: formattedDuration, // Send duration as a string in "hh:mm:ss" format
//     };

//     // Call the service to add movie data
//     Service1.addMovie(data)
//       .then((response) => {
//         console.log('Movie data added successfully:', response.data);
//         // Optionally, reset the form's state here
//         this.setState({
//           movieName: '',
//           language: '',
//           duration: new Date(), // Reset duration to a new Date object
//         });
//       })
//       .catch((error) => {
//         console.error('Error adding movie data:', error);
//       });
//   };

//   render() {
//     return (
//       <div>
//         <h2>Movie Information</h2>
//         <form onSubmit={this.handleSubmit}>
//           <div>
//             <label>Movie Name:</label>
//             <input
//               type="text"
//               name="movieName"
//               value={this.state.movieName}
//               onChange={this.handleChange}
//             />
//           </div>
//           <div>
//             <label>Language:</label>
//             <input
//               type="text"
//               name="language"
//               value={this.state.language}
//               onChange={this.handleChange}
//             />
//           </div>
//           <div>
//             <label>Duration (hh:mm):</label>
//             <input
//               type="text"
//               name="duration"
//               value={`${this.state.duration.getHours().toString().padStart(2, '0')}:${this.state.duration.getMinutes().toString().padStart(2, '0')}`}
//               onChange={this.handleChange}
//             />
//           </div>
//           <button type="submit">Submit</button>
//         </form>
//       </div>
//     );
//   }
// }

import React, { Component } from 'react';
import Service1 from '../service/service1';

export default class AddMovieDetails extends Component {
  constructor(props) {
    super(props);
    this.state = {
      movieName: '',
      language: '',
      duration: '', // Initialize duration as a string
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

    // Convert the hours and minutes back to the decimal format
    const [hours, minutes] = duration.split(':');
    const durationDecimal = parseFloat(hours) + parseFloat(minutes) / 60;

    // Create an object with the form data
    const data = {
      movieName,
      language,
      duration: durationDecimal, // Send duration as a decimal number
    };

    // Call the service to add movie data
    Service1.addMovie(data)
      .then((response) => {
        console.log('Movie data added successfully:', response.data);
        // Optionally, reset the form's state here
        window.location.href = '/admin';
        this.setState({
          movieName: '',
          language: '',
          duration: '', // Reset duration to an empty string
        });
      })
      .catch((error) => {
        console.error('Error adding movie data:', error);
      });
  };

  render() {
    return (
      <div>
        <h2>Movie Information</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Movie Name:</label>
            <input
              type="text"
              name="movieName"
              value={this.state.movieName}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label>Language:</label>
            <input
              type="text"
              name="language"
              value={this.state.language}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label>Duration (hh:mm):</label>
            <input
              type="text"
              name="duration"
              value={this.state.duration}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

